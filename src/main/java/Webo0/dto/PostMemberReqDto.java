package Webo0.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostMemberReqDto {
    String name;
    String nickname;
    String email;
    String password;
}
