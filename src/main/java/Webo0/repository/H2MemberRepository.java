package Webo0.repository;

import Webo0.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class H2MemberRepository implements MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public H2MemberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member selectOne(Long memberId) {
        String selectOneQuery = "select * from member where member_id = ?";

        return this.jdbcTemplate.queryForObject(selectOneQuery,
                (rs, rowNum) -> Member.loadMember(
                        rs.getString("member_name"),
                        rs.getString("nickname"),
                        rs.getString("email")),
                memberId);
    }

    @Override
    public List<Member> selectAll() {
        String selectAllQuery = "select * from member";

        return this.jdbcTemplate.query(selectAllQuery,
                (rs, rowNum) -> Member.loadMember(
                        rs.getString("member_name"),
                        rs.getString("nickname"),
                        rs.getString("email")));
    }

    @Override
    public void insertOne(Member newMember) {
        String insertOneQuery = "insert into member (member_name, nickname, email, password) values (?,?,?,?);";

        this.jdbcTemplate.update(insertOneQuery, new Object[] {newMember.getName(), newMember.getNickname(),
                newMember.getEmail(), newMember.getPassword()});
    }

    @Override
    public Long updateNickname(Long memberId, String newNickname) {
        String updateNicknameQuery = "update member set nickname = ? where member.member_id = ?";
        this.jdbcTemplate.update(updateNicknameQuery, new Object[]{newNickname, memberId});

        return memberId;
    }
}
