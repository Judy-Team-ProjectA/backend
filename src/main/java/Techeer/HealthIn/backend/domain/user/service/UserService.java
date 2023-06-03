package Techeer.HealthIn.backend.domain.user.service;

import Techeer.HealthIn.backend.domain.user.dto.UserCreateRequest;
import Techeer.HealthIn.backend.domain.user.entity.User;
import Techeer.HealthIn.backend.domain.user.mapper.UserMapper;
import Techeer.HealthIn.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User userCreate(UserCreateRequest userCreateRequest) {
        User user = userMapper.mapUserCreateRequestToUser(userCreateRequest);
        userRepository.save(user);
        return user;
    }
}
