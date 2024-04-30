package com.example.golfmember.dto;

import com.example.golfmember.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private String memberId;
    private String memberName;
    private String phone;
    private String address;
    private String grade;

    public static MemberDto fromMemberEntity(Member member){
        return new MemberDto(member.getMemberId(), member.getMemberName(),
                member.getPhone(), member.getAddress(), member.getGrade());
    }

    public static Member fromMemberDto(MemberDto memberDto){
        Member member = new Member();
        member.setMemberId(memberDto.getMemberId());
        member.setMemberName(memberDto.getMemberName());
        member.setPhone(memberDto.getPhone());
        member.setAddress(memberDto.getAddress());
        member.setGrade(memberDto.getGrade());
        return member;
    }
}
