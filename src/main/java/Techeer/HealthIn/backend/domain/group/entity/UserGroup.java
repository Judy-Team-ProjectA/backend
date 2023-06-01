package Techeer.HealthIn.backend.domain.group.entity;

import Techeer.HealthIn.backend.global.domain.BaseEntity;
import Techeer.HealthIn.backend.domain.user.entity.User;
import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "usergroup")
public class UserGroup extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="user_id")
    private User user_id;

    @OneToOne(fetch = FetchType.LAZY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="group_id")
    private Group group_id;

    @Builder
    public UserGroup(User user_id, Group group_id){
        this.user_id = user_id;
        this.group_id = group_id;

        super.isActivated = true;
    }
}