package Webo0.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Member {
    // member_id
    private Long id;
    // member_name
    private String name;
    private String nickname;

    private String email;
    private String password;

    // default 값 존재 (DB저장 시 할당)
    private int status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Member(String name, String nickname, String email) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
    }

    private Member(String name, String nickname, String email, String password) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public static Member createMember(String name, String nickname, String email, String password) {
        return new Member(name, nickname, email, password);
    }

    public static Member loadMember(String name, String nickname, String email) {
        return new Member(name, nickname, email);
    }
}
