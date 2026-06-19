package com.sparta.board.board.controller;

import com.sparta.board.board.dto.request.CreateBoardRequestDto;
import com.sparta.board.board.dto.response.BoardResponseDto;
import com.sparta.board.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	@PostMapping
	public ResponseEntity<BoardResponseDto> save(@RequestBody CreateBoardRequestDto requestDto) {

		BoardResponseDto boardResponseDto =
				boardService.save(
						requestDto.getTitle(),
						requestDto.getContents(),
						requestDto.getUsername()
				);

		return new ResponseEntity<>(boardResponseDto, HttpStatus.CREATED);
	}

}
