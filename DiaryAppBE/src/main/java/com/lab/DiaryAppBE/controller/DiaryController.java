package com.lab.DiaryAppBE.controller;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.DiaryAppBE.dto.DiaryDTO;
import com.lab.DiaryAppBE.entity.Diary;
import com.lab.DiaryAppBE.exception.ResourceNotFoundException;
import com.lab.DiaryAppBE.repository.DiaryRepository;
import com.lab.DiaryAppBE.service.DiaryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@CrossOrigin("*")		// CORS 셋팅 
@RestController			// REST API 통신
@RequestMapping ("/api/diary")		// @RequestMapping 하위 요청에 상속됨
@RequiredArgsConstructor
public class DiaryController {
	
	private final DiaryRepository diaryRepository;
	private final DiaryService diaryService;
	
	@GetMapping
	public List<Diary> getAllDiary() {
		System.out.println("getAllDiary 호출됨");
		return diaryService.getDiaryList();
	}
	
	@PostMapping
	public Diary createDiary(@RequestBody DiaryDTO diaryDTO) {
		System.out.println(diaryDTO);
		return diaryService.createDiary(diaryDTO);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Diary> getDiaryById(@PathVariable int id) {
		Diary diary = diaryRepository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("존재하지 않는 id : " + id));
		return ResponseEntity.ok(diary);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Diary> updateDiary(@PathVariable int id, @RequestBody Diary diaryDetails) {
		Diary updateDiary = diaryRepository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("존재하지 않는 id : " + id));
		
		updateDiary.setDate(diaryDetails.getDate());
		updateDiary.setContent(diaryDetails.getContent());
		updateDiary.setEmotionId(diaryDetails.getEmotionId());
		
		diaryRepository.save(updateDiary);
		
		return ResponseEntity.ok(updateDiary);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteDiary(@PathVariable int id) {
		
		Diary diary = diaryRepository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("존재하지 않는 id : " + id));
		
		diaryRepository.delete(diary);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
