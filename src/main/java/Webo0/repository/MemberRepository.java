package Webo0.repository;

import Webo0.domain.Member;
import java.util.List;

public interface MemberRepository {
    Member selectOne(Long memberId);
    List<Member> selectAll();

    void insertOne(Member newMember);

    Long updateNickname(Long memberId, String newNickname);

}
