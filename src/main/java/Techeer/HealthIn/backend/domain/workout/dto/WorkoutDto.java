package Techeer.HealthIn.backend.domain.workout.dto;

import Techeer.HealthIn.backend.domain.user.entity.User;
import Techeer.HealthIn.backend.domain.workout.domain.entity.Workout;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutDto {
    @NotNull
    private String exercise;

    @NotNull
    private String description;

    @NotNull
    private String target;

    @NotNull
    private int minute;

    @NotNull
    private LocalDateTime datetime;

    @NotNull
    private float weight;

    @NotNull
    private int sets;

    public Workout toEntity(User user) {
        return Workout.builder()
                .user(user)
                .exercise(this.exercise)
                .description(this.description)
                .target(this.target)
                .minute(this.minute)
                .datetime(this.datetime)
                .weight(this.weight)
                .sets(this.sets)
                .build();
    }

    public static WorkoutDto fromEntity(Workout workout) {
        return WorkoutDto.builder()
                .exercise(workout.getExercise())
                .description(workout.getDescription())
                .target(workout.getTarget())
                .minute(workout.getMinute())
                .datetime(workout.getDatetime())
                .weight(workout.getWeight())
                .sets(workout.getSets())
                .build();
    }

}



