package com.siddh.library.service;

import com.siddh.library.dto.MemberDTO;
import com.siddh.library.entity.Book;
import com.siddh.library.entity.Member;
import com.siddh.library.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    MemberRepo memberRepo;

    public MemberDTO addMember(MemberDTO memberDTO){
        if(memberDTO.getName()==null){
            throw new RuntimeException("Member name is required");
        }

        Member member=mapToEntity(memberDTO);

        memberRepo.save(member);

        return mapToDTO(member);
    }

    public List<MemberDTO> getAllMembers(){
        List<Member> members=memberRepo.findAll();
        return members.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public void removeMemberById(Integer id){
        Member existingMember=memberRepo.findById(id).orElseThrow(()->new RuntimeException("Member not found with given id"));

        memberRepo.deleteById(id);
    }

    private MemberDTO mapToDTO(Member member) {
        MemberDTO dto = new MemberDTO();
        dto.setMemberId(member.getMemberId());
        dto.setName(member.getName());
        return dto;
    }

    private Member mapToEntity(MemberDTO memberDTO){
        Member member=new Member();

        member.setMemberId(member.getMemberId());
        member.setName(member.getName());
        return member;
    }
}
