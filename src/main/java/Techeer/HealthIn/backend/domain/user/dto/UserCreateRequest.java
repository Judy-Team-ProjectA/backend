package Techeer.HealthIn.backend.domain.user.dto;

import Techeer.HealthIn.backend.domain.user.entity.User;
import Techeer.HealthIn.backend.domain.user.entity.User.Gender;
import Techeer.HealthIn.backend.domain.user.entity.type.Address;
import Techeer.HealthIn.backend.domain.user.entity.type.GymTime;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserCreateRequest {

    private MultipartFile userPhoto;

    private String userEmail;
    private String userPassword;
    private String userName;
    private Gender userGender;
    private Integer userAge;
    private Integer userCareer;
    private float userSbd;
    private GymTime userGymTime;

    private String userGym;
    private String userGymCity;
    private String userGymDistrict;

    private String userCity;
    private String userDistrict;

}
