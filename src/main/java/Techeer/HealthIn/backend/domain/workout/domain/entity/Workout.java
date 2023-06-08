package Techeer.HealthIn.backend.domain.workout.domain.entity;

import Techeer.HealthIn.backend.domain.user.entity.User;
import Techeer.HealthIn.backend.domain.workout.dto.WorkoutDto;
import Techeer.HealthIn.backend.global.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "Workout")
@SQLDelete(sql = "UPDATE workout SET is_activated = false WHERE id=?")
public class Workout extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;


    @Column(name = "workoutUuid", columnDefinition = "BINARY(16)")
    private UUID workoutUuid;

    @Column(name = "exercise")
    private String exercise;

    @Column(name = "description")
    private String description;

    @Column(name = "target")
    private String target;

    @Column(name = "minute")
    private int minute;
    @Column(name= "datetime")
    private LocalDateTime datetime;

    @Column(name = "weight")
    private float weight;

    @Column(name = "sets", length = 11)
    private int sets;

    @Builder
    public Workout(User user, String exercise, String description, String target, int minute, LocalDateTime datetime, float weight, int sets) {
        this.user = user;
        this.exercise = exercise;
        this.description = description;
        this.target = target;
        this.minute = minute;
        this.datetime = datetime;
        this.weight = weight;
        this.sets = sets;

        super.isActivated = true;
        this.workoutUuid = UUID.randomUUID();
    }

    public void update(WorkoutDto workoutDto) {
        this.exercise = workoutDto.getExercise();
        this.description = workoutDto.getDescription();
        this.target = workoutDto.getTarget();
        this.minute = workoutDto.getMinute();
        this.datetime = workoutDto.getDatetime();
        this.weight = workoutDto.getWeight();
        this.sets = workoutDto.getSets();
    }

}
