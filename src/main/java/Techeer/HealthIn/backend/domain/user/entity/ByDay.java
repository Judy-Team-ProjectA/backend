package Techeer.HealthIn.backend.domain.user.entity;

import Techeer.HealthIn.backend.global.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "by_day")
@SQLDelete(sql = "UPDATE by_day SET is_active = false WHERE id=?")
public class ByDay extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
