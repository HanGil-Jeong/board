package com.sparta.board.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Board extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(columnDefinition = "longtext")
	private String contents;

}
