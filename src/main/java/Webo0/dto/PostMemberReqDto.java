package Webo0.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostMemberReqDto {

    String name;
    String nickname;
    String email;
    String password;
}
