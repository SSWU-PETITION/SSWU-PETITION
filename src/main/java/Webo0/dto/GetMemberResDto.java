package Webo0.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetMemberResDto {
    private String name;
    private String nickname;
    private String email;
}
