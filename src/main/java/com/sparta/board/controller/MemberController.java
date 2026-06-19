package com.sparta.board.controller;

import com.sparta.board.dto.request.SignUpRequestDto;
import com.sparta.board.dto.response.MemberResponseDto;
import com.sparta.board.dto.response.SignUpResponseDto;
import com.sparta.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/signup")
	public ResponseEntity<SignUpResponseDto> signUp(
			@RequestBody SignUpRequestDto requestDto
			) {
		SignUpResponseDto signUpResponseDto = memberService.signUp(
				requestDto.getUsername(),
				requestDto.getPassword(),
				requestDto.getAge()
		);

		return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id) {

		MemberResponseDto memberResponseDto = memberService.findById(id);

		return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
	}

}
