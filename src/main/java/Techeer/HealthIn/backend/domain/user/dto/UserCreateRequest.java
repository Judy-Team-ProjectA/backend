package Techeer.HealthIn.backend.domain.user.dto;

import Techeer.HealthIn.backend.domain.user.entity.User;
import Techeer.HealthIn.backend.domain.user.entity.User.Gender;
import Techeer.HealthIn.backend.domain.user.entity.type.Address;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserCreateRequest {
    private MultipartFile userImage;

    private String userEmail;
    private String userPassword;
    private String userName;
    private String userPhoto;
    private Gender userGender;
    private Integer userAge;
    private Integer userCareer;
    private Long userSbd;
    private String userGym;
    private Address userAddress;


}
