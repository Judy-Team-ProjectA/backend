package Techeer.HealthIn.backend.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // user
    USER_NOT_FOUND(400, "U001", "유저를 찾기 실패"),
    USER_EVENT_DUPLICATION(400, "U002", "중복된 유저"),
    FILE_UPLOAD_ERROR(400,"F001" ,"파일 업로드 실패" ),
    FILE_VALID_ERROR(400, "F002", "파일 인증 에러" ),
    FILE_FORMAT_ERROR(400, "F003", "파일 형식 에러");

    private final int status;
    private final String code;
    private final String message;
}
