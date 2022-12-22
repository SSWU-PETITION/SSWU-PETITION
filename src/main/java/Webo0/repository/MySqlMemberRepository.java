package Webo0.repository;

import Webo0.domain.Member;
import java.util.List;

public class MySqlMemberRepository implements MemberRepository{

    @Override
    public Member selectOne(Long memberId) {
        return null;
    }

    @Override
    public List<Member> selectAll() {
        return null;
    }

    @Override
    public void insertOne(Member newMember) {

    }

    @Override
    public Long updateNickname(Long memberId, String newNickname) {
        return null;
    }

    @Override
    public Long selectMemberId(String email, String password) {
        return null;
    }

}
