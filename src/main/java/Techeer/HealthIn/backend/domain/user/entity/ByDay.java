package Techeer.HealthIn.backend.domain.user.entity;

import Techeer.HealthIn.backend.domain.user.entity.type.Day;
import Techeer.HealthIn.backend.global.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "by_day")
@SQLDelete(sql = "UPDATE by_day SET is_activated = false WHERE id=?")
public class ByDay extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private Day day;

    @Column(name = "target")
    private String target;

    @Builder
    public ByDay(User user, Day day, String target) {
        this.user = user;
        this.day = day;
        this.target = target;

        super.isActivated = true;
    }
}
