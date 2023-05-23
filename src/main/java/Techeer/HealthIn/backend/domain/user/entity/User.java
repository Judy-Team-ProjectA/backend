package Techeer.HealthIn.backend.domain.user.entity;

import Techeer.HealthIn.backend.domain.matching.entity.Matching;
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
@SQLDelete(sql = "UPDATE user SET is_active = false WHERE id=?")
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

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "age", length = 11)
    private int age;

    @Column(name = "career", length = 11)
    private int career;

    @Column(name = "sbd", length = 11)
    private float sbd;

    @Column(name = "gym", length = 255)
    private String gym;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "time")
    private LocalDateTime time;

    public enum Gender {
        MALE, FEMALE
    }

    @Builder
    public User(String email, String password, String name, Gender gender, int age, int career, float sbd, String gym, LocalDateTime time, String address) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.career = career;
        this.sbd = sbd;
        this.gym = gym;
        this.address = address;
        this.time = time;

        super.isActivated = true;
        this.uuid = UUID.randomUUID();
    }


}
