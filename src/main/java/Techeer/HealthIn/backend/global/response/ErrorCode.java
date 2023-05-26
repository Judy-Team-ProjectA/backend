package Techeer.HealthIn.backend.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // user
    USER_NOT_FOUND(400, "U001", "유저를 찾기 실패"),
    USER_EVENT_DUPLICATION(400, "U002", "중복된 유저")
    ;

    private final int status;
    private final String code;
    private final String message;
}
