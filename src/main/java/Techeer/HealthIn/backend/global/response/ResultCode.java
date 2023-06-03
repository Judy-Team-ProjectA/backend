package Techeer.HealthIn.backend.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    // user
    USER_CREATE_SUCCESS(200, "U001", "사용자 추가 성공"),
    USER_READ_ALL_SUCCESS(200, "U002", "모든 사용자 조회 성공"),
    USER_READ_ONE_SUCCESS(200, "U003", "특정 사용자 조회 성공"),
    USER_UPDATE_SUCCESS(200, "U004", "사용자 정보 수정 성공"),
    USER_DELETE_SUCCESS(200, "U005", "사용자 정보 삭제 성공"),
    USER_MATCHING_SUCCESS(200, "U006", "특정 유저와 매칭된 유저 정보 조회")
    ;
    private int status;
    private final String code;
    private final String message;
}
