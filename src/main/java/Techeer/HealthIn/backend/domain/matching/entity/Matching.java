package Techeer.HealthIn.backend.domain.matching.entity;

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
@Table(name = "matching")
@SQLDelete(sql = "UPDATE matching SET is_activated = false WHERE id=?")
public class Matching extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "requester_id")
    private User requester;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @Column(name = "uuid", columnDefinition = "BINARY(16)")
    private UUID uuid;

    @Enumerated(EnumType.STRING)
    private MatchingStatus status;

    @Builder
    public Matching(User requester, User receiver, MatchingStatus status) {
        this.requester = requester;
        this.receiver = receiver;
        this.status = status;

        super.isActivated = true;
        this.uuid = UUID.randomUUID();
    }

}
