package Techeer.HealthIn.backend.domain.workout.service.impl;

import Techeer.HealthIn.backend.domain.user.repository.UserRepository;
import Techeer.HealthIn.backend.domain.workout.domain.repository.WorkoutRepository;
import Techeer.HealthIn.backend.domain.workout.service.WorkoutService;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

import Techeer.HealthIn.backend.domain.workout.domain.entity.Workout;
import Techeer.HealthIn.backend.domain.user.entity.User;
import Techeer.HealthIn.backend.domain.workout.dto.WorkoutDto;
import Techeer.HealthIn.backend.domain.workout.exception.UserNotFoundException;
import Techeer.HealthIn.backend.domain.workout.exception.WorkoutNotFoundException;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    private final UserRepository userRepository;
    private final WorkoutRepository workoutRepository;

    public WorkoutServiceImpl(UserRepository userRepository, WorkoutRepository workoutRepository) {
        this.userRepository = userRepository;
        this.workoutRepository = workoutRepository;
    }

    @Transactional
    public WorkoutDto createWorkout(UUID userUuid, WorkoutDto workoutDto) {
        User user = userRepository.findByUuidAndIsActivatedTrue(userUuid).orElseThrow(() -> new UserNotFoundException("해당하는 유저가 없습니다. UUID: " + userUuid));
        Workout workout = workoutDto.toEntity(user);
        workout = workoutRepository.save(workout);
        return WorkoutDto.fromEntity(workout);
    }

    @EntityGraph(attributePaths = "works")
    @Transactional(readOnly = true)
    public List<WorkoutDto> getAllWorkouts(UUID userUuid) {
        User user = userRepository.findByUuidAndIsActivatedTrue(userUuid).orElseThrow(() -> new UserNotFoundException("해당하는 유저가 없습니다. UUID: " + userUuid));
        List<Workout> workouts = workoutRepository.findByUserAndIsActivatedTrue(user);
        return workouts.stream()
                .map(WorkoutDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public WorkoutDto getWorkout(UUID userUuid, UUID workoutUuid) {
        Workout workout = workoutRepository.findByUserUuidAndWorkoutUuidAndIsActivatedTrue(userUuid, workoutUuid)
                .orElseThrow(() -> new WorkoutNotFoundException("해당하는 운동이 없습니다. UUID: " + workoutUuid));
        return WorkoutDto.fromEntity(workout);
    }

    @Transactional
    public WorkoutDto updateWorkout(UUID userUuid, UUID workoutUuid, WorkoutDto workoutDto) {
        Workout workout = workoutRepository.findByUserUuidAndWorkoutUuidAndIsActivatedTrue(userUuid, workoutUuid)
                .orElseThrow(() -> new WorkoutNotFoundException("해당하는 운동이 없습니다. UUID: " + workoutUuid));
        workout.update(workoutDto);
        workout = workoutRepository.save(workout);
        return WorkoutDto.fromEntity(workout);
    }


    @Transactional
    public void deleteWorkout(UUID userUuid, UUID workoutUuid) {
        Workout workout = workoutRepository.findByUserUuidAndWorkoutUuidAndIsActivatedTrue(userUuid, workoutUuid)
                .orElseThrow(() -> new WorkoutNotFoundException("해당하는 운동이 없습니다. UUID: " + workoutUuid));
        workout.activeOff();
        workoutRepository.save(workout);
    }


}
