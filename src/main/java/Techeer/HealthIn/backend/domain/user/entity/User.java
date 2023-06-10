package Techeer.HealthIn.backend.domain.user.entity;

import Techeer.HealthIn.backend.domain.meal.entity.Meal;
import Techeer.HealthIn.backend.domain.user.entity.type.Address;
import Techeer.HealthIn.backend.domain.user.entity.type.GymTime;
import Techeer.HealthIn.backend.domain.workout.entity.Workout;
import Techeer.HealthIn.backend.global.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
@SQLDelete(sql = "UPDATE user SET is_activated = false WHERE id=?")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid", columnDefinition = "BINARY(16)")
    private UUID uuid;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "password", length = 45)
    private String password;

    @Column(name = "photo")
    private String photo;
    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "age", length = 11)
    private Integer age;


    @Embedded
    @AttributeOverride(name="city", column = @Column(name = "city"))
    @AttributeOverride(name="district", column = @Column(name = "district"))
    private Address address;


    @Column(name = "career", length = 11)
    private Integer career;

    @Column(name = "sbd", length = 11)
    private float sbd;

    @Embedded
    @AttributeOverride(name="city", column = @Column(name = "gym_city"))
    @AttributeOverride(name="district", column = @Column(name = "gym_district"))
    private Address gymAddress;

    @Column(name = "gym", length = 255)
    private String gym;

    @Enumerated(EnumType.STRING)
    @Column(name = "gym_time")
    private GymTime gymTime;


    @OneToMany(mappedBy = "user")
    private List<ByDay> byDays = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Meal> diets = new ArrayList<>();

//    @OneToMany(mappedBy = "user")
//    private List<Workout> works = new ArrayList<>();
    public enum Gender {
        MALE, FEMALE
    }

    @Builder
    public User(String email,
                String password,
                String photo,
                String name,
                Gender gender,
                Integer age,
                Integer career,
                float sbd,
                String gym,
                GymTime gymTime,
                Address gymAddress,
                Address address) {
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.career = career;
        this.sbd = sbd;

        this.gym = gym;
        this.gymAddress = gymAddress;
        this.address = address;
        this.gymTime = gymTime;

        super.isActivated = true;
        this.uuid = UUID.randomUUID();
    }


}
