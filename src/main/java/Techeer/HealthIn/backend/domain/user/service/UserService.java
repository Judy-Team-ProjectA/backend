package Techeer.HealthIn.backend.domain.user.service;

import Techeer.HealthIn.backend.domain.user.dto.UserCreateRequest;
import Techeer.HealthIn.backend.domain.user.entity.User;
import Techeer.HealthIn.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User userCreate(UserCreateRequest userCreateRequest) {
        User user = userCreateRequest.
    }
}
