package com.sparta.board.board.service;

import com.sparta.board.board.dto.response.BoardResponseDto;
import com.sparta.board.board.dto.response.BoardWithAgeResponseDto;
import com.sparta.board.board.entity.Board;
import com.sparta.board.board.repository.BoardRepository;
import com.sparta.board.member.entity.Member;
import com.sparta.board.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final MemberRepository memberRepository;
	private final BoardRepository boardRepository;

	public BoardResponseDto save(String title, String contents, String username) {

		Member findMember = memberRepository.findMemberByUsernameOrElseThrow(username);

		Board board = new Board(title, contents);
		board.setMember(findMember);

		boardRepository.save(board);

		return new BoardResponseDto(board.getId(), board.getTitle(), board.getContents());
	}

	public List<BoardResponseDto> findAll() {
		return boardRepository.findAll()
				.stream()
				.map(BoardResponseDto::toDto)
				.toList();
	}

	public BoardWithAgeResponseDto findById(Long id) {
		Board findBoard = boardRepository.findByIdOrElseThrow(id);
		Member writer = findBoard.getMember();

		return new BoardWithAgeResponseDto(findBoard.getTitle(), findBoard.getContents(), writer.getAge());
	}

	public void delete(Long id) {

		Board findBoard = boardRepository.findByIdOrElseThrow(id);

		boardRepository.delete(findBoard);
	}

}
