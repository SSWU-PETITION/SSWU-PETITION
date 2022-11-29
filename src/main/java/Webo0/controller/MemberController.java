package Webo0.controller;

import Webo0.domain.Member;
import Webo0.dto.*;
import Webo0.repository.MemberRepository;
import Webo0.service.MemberService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @PostMapping("/new")
    @ApiOperation(value = "회원가입", notes = "회원가입 API")
    public PostMemberResDto postMember(@RequestBody PostMemberReqDto postMemberReqDto) {
        Member newMember = Member.createMember(
                postMemberReqDto.getName(),
                postMemberReqDto.getNickname(),
                postMemberReqDto.getEmail(),
                postMemberReqDto.getPassword()
        );

        memberService.save(newMember);

        return new PostMemberResDto(newMember.getMember_name(), newMember.getEmail());
    }

    @GetMapping("/{memberId}")
    @ApiOperation(value = "회원 조회", notes = "회원 id로 회원 조회 API")
    public GetMemberResDto getMember(@PathVariable("memberId") Long memberId) {
        Member findMember = memberService.findOne(memberId);

        return new GetMemberResDto(findMember.getMember_name(), findMember.getNickname(), findMember.getEmail());
    }

    @GetMapping("")
    @ApiOperation(value = "전체 회원 조회", notes = "전체 회원 조회 API")
    public List<GetMemberResDto> getAllMembers() {
        List<Member> findMembers = memberService.findAll();
        System.out.println("49행@@@@@@@@@@@@@@@@@");
        List<GetMemberResDto> getMemberResDtos = new ArrayList<>();
        for (Member findMember : findMembers) {
            getMemberResDtos.add(new GetMemberResDto(findMember.getMember_name(), findMember.getNickname(),
                    findMember.getEmail()));
        }

        return getMemberResDtos;
    }

    @PatchMapping("/{memberId}/nickname")
    @ApiOperation(value = "회원 닉네임 수정", notes = "회원 닉네임 수정 API")
    public PatchMemberNicknameResDto patchNickname(@PathVariable("memberId") Long memberId,
                                                   @RequestBody PatchMemberNicknameReqDto pathMemberNicknameReqDto) {
        String newNickname = pathMemberNicknameReqDto.getNewNickname();
        Long idOfModifiedMember = memberService.modifyNickname(memberId, newNickname);

        Member modifiedMember = memberService.findOne(idOfModifiedMember);
        return new PatchMemberNicknameResDto(modifiedMember.getMember_name(), modifiedMember.getNickname(), modifiedMember.getEmail());
    }
}
