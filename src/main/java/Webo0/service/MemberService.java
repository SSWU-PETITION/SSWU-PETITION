package Webo0.service;

import Webo0.domain.Member;
import java.util.List;

public interface MemberService {
    Member save(Member member);

    Member findOne(Long memberId);

    Long isValid(String email,String password);

    List<Member> findAll();

    Long modifyNickname(Long memberId, String newNickname);

}
