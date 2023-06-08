package Techeer.HealthIn.backend.domain.workout.service;

import Techeer.HealthIn.backend.domain.workout.dto.WorkoutDto;
import Techeer.HealthIn.backend.domain.workout.domain.entity.Workout;
import java.util.List;
import java.util.UUID;

public interface WorkoutService {
    WorkoutDto createWorkout(UUID userUuid, WorkoutDto workoutDto);

    List<WorkoutDto> getAllWorkouts(UUID userUuid);

    WorkoutDto getWorkout(UUID userUuid, UUID workoutUuid);

    WorkoutDto updateWorkout(UUID userUuid, UUID workoutUuid, WorkoutDto workoutDto);

    void deleteWorkout(UUID userUuid, UUID workoutUuid);
}
