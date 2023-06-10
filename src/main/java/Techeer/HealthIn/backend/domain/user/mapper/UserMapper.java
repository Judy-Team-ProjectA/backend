package Techeer.HealthIn.backend.domain.user.mapper;

import Techeer.HealthIn.backend.domain.user.dto.UserCreateRequest;
import Techeer.HealthIn.backend.domain.user.entity.User;
import Techeer.HealthIn.backend.domain.user.entity.type.Address;
import Techeer.HealthIn.backend.global.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserMapper {
    private final S3Service s3Service;

    public User mapUserCreateRequestToUser(UserCreateRequest userCreateRequest){

        return User.builder()
                .email(userCreateRequest.getUserEmail())
                .password(userCreateRequest.getUserPassword())
                .photo(s3Service.uploadFile(userCreateRequest.getUserPhoto()))
                .name(userCreateRequest.getUserName())
                .gender(userCreateRequest.getUserGender())
                .age(userCreateRequest.getUserAge())
                .career(userCreateRequest.getUserCareer())
                .sbd(userCreateRequest.getUserSbd())
                .gym(userCreateRequest.getUserGym())
                .gymAddress(new Address(userCreateRequest.getUserGymCity(), userCreateRequest.getUserGymDistrict()))
                .address(new Address(userCreateRequest.getUserCity(), userCreateRequest.getUserDistrict()))
                .gymTime(userCreateRequest.getUserGymTime())
                .build();


    }
}
