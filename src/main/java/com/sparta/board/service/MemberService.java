package com.sparta.board.service;

import com.sparta.board.dto.response.SignUpResponseDto;
import com.sparta.board.entity.Member;
import com.sparta.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	public SignUpResponseDto signUp(String username, String password, Integer age) {

		Member member = new Member(username, password, age);

		Member savedMember = memberRepository.save(member);

		return new SignUpResponseDto(
				savedMember.getId(),
				savedMember.getUsername(),
				savedMember.getAge()
		);
	}
}
