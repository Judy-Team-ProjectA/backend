package Techeer.HealthIn.backend.domain.user.mapper;

import Techeer.HealthIn.backend.domain.user.dto.UserCreateRequest;
import Techeer.HealthIn.backend.domain.user.entity.User;
import Techeer.HealthIn.backend.domain.user.entity.type.Address;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
                .gym(userCreateRequest.getUserGym())
                .address(new Address(userCreateRequest.getUserCity(), userCreateRequest.getUserDistrict()))
                .time(LocalDateTime.now())
                .build();


    }
}
