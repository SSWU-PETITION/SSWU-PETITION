package Webo0.controller;

import Webo0.domain.Member;
import Webo0.dto.PostMemberReqDto;
import Webo0.dto.PostMemberResDto;
import Webo0.service.MemberService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequiredArgsConstructor //생성자 없어도 되게끔
@RequestMapping("/members")
public class HelloController {
    private final MemberService memberService;
    @GetMapping("hello") //"hello"페이지가 만들어졌을때 페이지 경로가 뭐라 뜰지
    public String hello(Model model) { //요게 view resolver인 듯
        model.addAttribute("data", "hello!!"); //html에서 원하는 {data}값에 밸류를 넣는 명령어
        return "hello"; // 여기서 hello.html(뷰리졸버) 다시 불러줌
    }
    @GetMapping("hello-mvc")//주소 mvc로 받아서z
    public String helloMvc(@RequestParam("name") String name, Model model) { //@가 name에 주소창에서 채울지 물어보는 함수인듯
        model.addAttribute("name", name); // name에다가 주소창에서 변수를 채워줘야함
        return "hello-template"; //실제 경로인 temp 틀기
    }

    @GetMapping("join")
    public String join(Model model) {
        return "join_terms"; // join_terms.html
    }
    @RequestMapping("join_meminfo")
    public String join2(Model model,PostMemberReqDto pmrd) {
        model.addAttribute("toDto", pmrd);
        return "join_form"; // join_form.html
    }
    @GetMapping("login") //url
    public String login(Model model) {
        model.addAttribute("loginInfo", new PostMemberReqDto());
        return "login"; // login.html
    }

    @PostMapping("new") // 데이터 호출 api
    @ApiOperation(value = "회원가입", notes = "회원가입 API")
    public String postMember(PostMemberReqDto postMemberReqDto) {
        Member newMember = Member.createMember(
                postMemberReqDto.getName(),
                postMemberReqDto.getNickname(),
                postMemberReqDto.getEmail(),
                postMemberReqDto.getPassword()
        );

        System.out.println(memberService.save(newMember));

        return "join_complete";
    }

    @PostMapping("isValidAccount")
    @ApiOperation(value = "로그인")
    @ResponseBody
    public String LoginApi(PostMemberReqDto pmrd) {
        try {
            return memberService.isValid(pmrd.getEmail(),pmrd.getPassword()).toString()
                    + " 당신의 식별 번호입니다.\n로그인 성공하셨습니다.";

        } catch (Exception e) {
            return  "계정 정보를 잘 확인하세요";
        }
    }

}
