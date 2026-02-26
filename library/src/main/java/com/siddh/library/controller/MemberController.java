package com.siddh.library.controller;

import com.siddh.library.dto.BookDTO;
import com.siddh.library.dto.MemberDTO;
import com.siddh.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/create")
    public ResponseEntity<MemberDTO> createMember(@RequestBody MemberDTO memberDTO){
        MemberDTO savedMember=memberService.addMember(memberDTO);

        return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<List<MemberDTO>> getMember(){
        List<MemberDTO> allMembers = memberService.getAllMembers();

        return ResponseEntity.ok(allMembers);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Integer id){
        memberService.removeMemberById(id);
        return ResponseEntity.ok("Member Deleted");
    }
}
