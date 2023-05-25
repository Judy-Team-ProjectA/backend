package Techeer.HealthIn.backend.domain.workout.entity;

import Techeer.HealthIn.backend.domain.user.entity.User;
import Techeer.HealthIn.backend.global.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.time.LocalDate;
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
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @Column(name = "uuid", columnDefinition = "BINARY(16)")
    private UUID uuid;

    @Column(name = "exercise")
    private String exercise;

    @Column(name = "description")
    private String description;

    @Column(name = "target")
    private String target;

    @Column(name = "minute", length = 11)
    private Integer minute;
    @Column(name= "date")
    private LocalDate date;

    @Column(name = "weight")
    private Float weight;

    @Column(name = "set", length = 11)
    private Integer set;

    @Builder
    public Workout(User user, String exercise, String description, String target, Integer minute, LocalDate date, Float weight, Integer set) {
        this.user = user;
        this.exercise = exercise;
        this.description = description;
        this.target = target;
        this.minute = minute;
        this.date = date;
        this.weight = weight;
        this.set = set;

        super.isActivated = true;
        this.uuid = UUID.randomUUID();
    }
}
