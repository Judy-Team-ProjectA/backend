package Techeer.HealthIn.backend.domain.workout.domain.repository;

import Techeer.HealthIn.backend.domain.user.entity.User;
import Techeer.HealthIn.backend.domain.workout.domain.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkoutRepository extends JpaRepository<Workout, UUID> {
    List<Workout> findByUserAndIsActivatedTrue(User user);
    Optional<Workout> findByUserUuidAndWorkoutUuidAndIsActivatedTrue(UUID userUuid, UUID workoutUuid);
}
