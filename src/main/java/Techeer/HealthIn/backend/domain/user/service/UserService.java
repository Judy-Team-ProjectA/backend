package Techeer.HealthIn.backend.domain.user.service;

import Techeer.HealthIn.backend.domain.user.dto.UserCreateRequest;
import Techeer.HealthIn.backend.domain.user.entity.User;
import Techeer.HealthIn.backend.domain.user.mapper.UserMapper;
import Techeer.HealthIn.backend.domain.user.repository.UserRepository;
import Techeer.HealthIn.backend.global.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public User createUser(UserCreateRequest userCreateRequest) {
        User user = userMapper.mapUserCreateRequestToUser(userCreateRequest);
        userRepository.save(user);
        return user;
    }

    public User readOneUser(UUID userUuid) {
        return userRepository.findUserByUuid(userUuid);
    }
}
