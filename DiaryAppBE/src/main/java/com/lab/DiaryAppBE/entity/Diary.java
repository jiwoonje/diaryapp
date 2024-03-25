package com.lab.DiaryAppBE.entity;

import com.lab.DiaryAppBE.dto.DiaryDTO;

import groovy.transform.builder.Builder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "diary")
public class Diary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String date;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	private int emotionId;
	
	public Diary (DiaryDTO diaryDTO) {
		this.date = diaryDTO.getDate();
		this.content = diaryDTO.getContent();
		this.emotionId = diaryDTO.getEmotionId();
	}
}
