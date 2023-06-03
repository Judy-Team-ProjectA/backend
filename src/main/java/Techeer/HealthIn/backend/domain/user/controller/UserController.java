package Techeer.HealthIn.backend.domain.user.controller;

import Techeer.HealthIn.backend.domain.user.dto.UserCreateRequest;
import Techeer.HealthIn.backend.domain.user.entity.User;
import Techeer.HealthIn.backend.domain.user.service.UserService;
import Techeer.HealthIn.backend.global.response.ResultCode;
import Techeer.HealthIn.backend.global.response.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResultResponse> createUser(@Valid @RequestBody UserCreateRequest userCreateRequest)
    {
        User user = userService.userCreate(userCreateRequest);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.USER_CREATE_SUCCESS, user));
    }
}