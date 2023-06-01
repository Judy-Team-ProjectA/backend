package Techeer.HealthIn.backend.domain.group.entity;

import Techeer.HealthIn.backend.domain.user.entity.User;
import Techeer.HealthIn.backend.global.domain.BaseEntity;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "calendar")
public class GroupCalendar extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_id", nullable = true)
    private Group group_id;

    @Column(name = "uuid", columnDefinition="BINARY(16)")
    private UUID uuid;

    @Column(name = "title", length = 255)
    private String title;

    @Lob
    @Column(name = "describe",columnDefinition="TEXT")
    private String describe;

    @Column(name= "date")
    private Date date;

    @Column(name= "start_time")
    private LocalDateTime start_time;

    @Column(name= "end_time")
    private LocalDateTime end_time;

    @Column(name = "gym", length = 255)
    private String gym;

    @Builder
    public GroupCalendar(User user_id, Group group_id, String title, String describe, Date date, LocalDateTime start_time, LocalDateTime end_time, String gym){
        this.user_id = user_id;
        this.group_id = group_id;
        this.title = title;
        this.describe = describe;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;

        super.isActivated = true;
        this.uuid = UUID.randomUUID();
    }
}
