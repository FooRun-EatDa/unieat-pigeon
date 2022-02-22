package com.foorun.unieat.pigeon.domain.common;

import com.foorun.unieat.pigeon.constant.ResponseCode;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Builder
public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;

    public static <T> ApiResponse<T> valueOf(T data) {
        return of(ResponseCode.CODE_200, data);
    }

    public static <T> ApiResponse<T> success() {
        return of(ResponseCode.CODE_200, null);
    }

    public static <T> ApiResponse<T> of(ResponseCode responseCode) {
        return of(responseCode, null);
    }

    public static <T> ApiResponse<T>  of(ResponseCode responseCode, T data) {
        return new ApiResponse<>(responseCode.getCode(), responseCode.getMessage(), data);
    }

    public static ApiResponse<Void> error(ResponseCode responseCode) {
        return of(responseCode);
    }
}
