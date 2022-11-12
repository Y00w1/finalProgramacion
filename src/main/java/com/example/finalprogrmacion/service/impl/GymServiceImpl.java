package com.example.finalprogrmacion.service.impl;

import com.example.finalprogrmacion.service.MemberService;

public class GymServiceImpl {
    private MemberService memberService;

    public GymServiceImpl(){
        this.memberService = new MemberServiceImpl();
    }

    public MemberService getMemberService(){
        return memberService;
    }
}
