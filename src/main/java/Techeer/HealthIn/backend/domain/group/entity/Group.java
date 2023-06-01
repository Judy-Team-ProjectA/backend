package Techeer.HealthIn.backend.domain.group.entity;

import Techeer.HealthIn.backend.global.domain.BaseEntity;
import lombok.*;
import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "group")
public class Group extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid", columnDefinition="BINARY(16)")
    private UUID uuid;

    @Column(name="group_name")
    private String group_name;

    @Builder
    public Group(String group_name){
        this.group_name = group_name;

        super.isActivated = true;
        this.uuid = UUID.randomUUID();
    }
}

