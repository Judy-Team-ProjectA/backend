package Techeer.HealthIn.backend.domain.user.controller;

import Techeer.HealthIn.backend.domain.user.dto.UserCreateRequest;
import Techeer.HealthIn.backend.domain.user.entity.User;
import Techeer.HealthIn.backend.domain.user.service.UserService;
import Techeer.HealthIn.backend.global.response.ResultCode;
import Techeer.HealthIn.backend.global.response.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResultResponse> createUser(@Valid @ModelAttribute UserCreateRequest userCreateRequest)
    {
        User user = userService.createUser(userCreateRequest);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.USER_CREATE_SUCCESS, user.getUuid()));
    }

    @GetMapping("/{userUuid}")
    public ResponseEntity<ResultResponse> readOneUser(@Valid @PathVariable UUID userUuid) {
        User user = userService.readOneUser(userUuid);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.USER_READ_ONE_SUCCESS, user));
    }

    @DeleteMapping("/{userUuid}")
    public ResponseEntity<ResultResponse> deleteOneUser(@Valid @PathVariable UUID userUuid) {
        userService.deleteOneUser(userUuid);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.USER_DELETE_SUCCESS, ""));
    }



}
