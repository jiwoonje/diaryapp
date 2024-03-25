package com.lab.DiaryAppBE.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lab.DiaryAppBE.dto.DiaryDTO;
import com.lab.DiaryAppBE.entity.Diary;
import com.lab.DiaryAppBE.repository.DiaryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiaryService {
	
	private final DiaryRepository diaryRepository;
	
	// 다이어리 리스트
	public List<Diary> getDiaryList() {
		return diaryRepository.findAll();
	}

	// 다이어리 create
	public Diary createDiary(DiaryDTO diaryDTO) {
		Diary diary = new Diary(diaryDTO);
		
		return diaryRepository.save(diary);
	}
}
