package Techeer.HealthIn.backend.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    // user
    CREATE_USER_SUCCESS(200, "U001", "사용자 추가 성공")
    ;
    private int status;
    private final String code;
    private final String message;
}
