package Techeer.HealthIn.backend.domain.workout.controller;

import Techeer.HealthIn.backend.domain.workout.domain.entity.Workout;
import Techeer.HealthIn.backend.domain.workout.dto.WorkoutDto;
import Techeer.HealthIn.backend.domain.workout.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users/{userUuid}/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping
    public ResponseEntity<WorkoutDto> createWorkout(@PathVariable UUID userUuid, @RequestBody WorkoutDto workoutDto) {
        WorkoutDto workout = workoutService.createWorkout(userUuid, workoutDto);
        return ResponseEntity.ok(workout);
    }

    @GetMapping
    public ResponseEntity<List<WorkoutDto>> getAllWorkouts(@PathVariable UUID userUuid) {
        List<WorkoutDto> workouts = workoutService.getAllWorkouts(userUuid);
        return ResponseEntity.ok(workouts);
    }

    @GetMapping("/{workoutUuid}")
    public ResponseEntity<WorkoutDto> getWorkout(@PathVariable UUID userUuid, @PathVariable UUID workoutUuid) {
        WorkoutDto workout = workoutService.getWorkout(userUuid, workoutUuid);
        return ResponseEntity.ok(workout);
    }

    @PatchMapping("/{workoutUuid}")
    public ResponseEntity<WorkoutDto> updateWorkout(@PathVariable UUID userUuid, @PathVariable UUID workoutUuid, @RequestBody WorkoutDto workoutDto) {
        WorkoutDto updatedWorkout = workoutService.updateWorkout(userUuid, workoutUuid, workoutDto);
        return ResponseEntity.ok(updatedWorkout);
    }

    @DeleteMapping("/{workoutUuid}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable UUID userUuid, @PathVariable UUID workoutUuid) {
        workoutService.deleteWorkout(userUuid, workoutUuid);
        return ResponseEntity.ok().build();
    }
}
