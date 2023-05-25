package Techeer.HealthIn.backend.domain.meal.entity;


import Techeer.HealthIn.backend.domain.user.entity.User;
import Techeer.HealthIn.backend.global.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "meal")
@SQLDelete(sql = "UPDATE meal SET is_activated = false WHERE id=?")
public class Meal extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Diet 엔티티 로드할 때 User 데이터가 필요하지 않은 경우 LAZY
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "uuid", columnDefinition = "BINARY(16)")
    private UUID uuid;

    //LocalDateTime는 시간까지 LocalDate는 년월일까지만
    @Column(name= "date")
    private LocalDateTime date;

    @Column(name= "food")
    private String food;

    @Column(name = "description")
    private String description;

    @Column(name = "calories", length = 11)
    private int calories;

    @Column(name = "carbohydrates", length = 11)
    private int carbohydrates;

    @Column(name = "protein", length = 11)
    private int protein;

    @Column(name = "fat", length = 11)
    private int fat;

    @Builder
    public Meal(User user, LocalDateTime date, String food, String description, int calories, int carbohydrates, int protein, int fat) {
        this.user = user;
        this.date = date;
        this.food = food;
        this.description = description;
        this.calories = calories;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
        this.fat = fat;

        super.isActivated = true;
        this.uuid = UUID.randomUUID();
    }
}

