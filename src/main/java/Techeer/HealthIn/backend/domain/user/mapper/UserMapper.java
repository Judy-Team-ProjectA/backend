package Techeer.HealthIn.backend.domain.user.mapper;

import Techeer.HealthIn.backend.domain.user.dto.UserCreateRequest;
import Techeer.HealthIn.backend.domain.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User mapUserCreateRequestToUser(UserCreateRequest userCreateRequest){
        return User.builder()
                .email(userCreateRequest.getUserEmail())
                .password(userCreateRequest.getUserPassword())
                .name(userCreateRequest.getUserName())
                .gender(userCreateRequest.getUserGender())
                .age(userCreateRequest.getUserAge())
                .career(userCreateRequest.getUserCareer())
                .sbd(userCreateRequest.getUserSbd())


    }
}
