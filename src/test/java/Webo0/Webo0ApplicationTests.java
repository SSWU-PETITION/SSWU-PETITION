package Webo0;

import Webo0.domain.Member;
import Webo0.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Webo0ApplicationTests {
	private final MemberRepository memberRepository;

	// 의존성 주입
	@Autowired
	Webo0ApplicationTests(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Test
	void 회원가입() {
		// 멤버 저장
		Member.createMember("name", "nickname", "email", "password");
		System.out.println("create Member!!!!!!!!!!");
	}

}
