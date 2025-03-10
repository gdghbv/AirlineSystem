package com.example.airline_ticket_system_idea.pojo;

/**
 * 统一响应结果封装类
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//统一响应结果
@NoArgsConstructor
@AllArgsConstructor
@Data//lombok生效

public class Result<T> {
    private Integer code;//业务状态码  0-成功  1-失败
    private String msg;//提示信息
    private T data;//响应数据

    //快速返回操作成功响应结果(带响应数据)
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }

    //快速返回操作成功响应结果
    public static Result success() {
        return new Result(0, "操作成功", null);
    }

    public static Result error(String message) {
        return new Result(1, message, null);
    }
//    public static <E> Result<E> error(E data) {
//        return new Result<>(1, "操作失败", data);
//    }
}
