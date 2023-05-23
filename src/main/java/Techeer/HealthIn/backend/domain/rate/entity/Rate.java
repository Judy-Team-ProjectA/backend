package Techeer.HealthIn.backend.domain.rate.entity;

import Techeer.HealthIn.backend.domain.user.entity.User;
import Techeer.HealthIn.backend.global.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

import java.util.UUID;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "rate")
@SQLDelete(sql = "UPDATE rate SET is_activated = false WHERE id=?")
public class Rate extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "rater_id")
    private User rater;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "uuid", columnDefinition = "BINARY(16)")
    private UUID uuid;

    @Column(name = "rate")
    private int rate;

    @Column(name = "comment")
    private String comment;

    @Builder
    public Rate(User rater, User user, int rate, String comment) {
        this.rater = rater;
        this.user = user;
        this.rate = rate;
        this.comment = comment;

        super.isActivated = true;
        this.uuid = UUID.randomUUID();
    }
}
