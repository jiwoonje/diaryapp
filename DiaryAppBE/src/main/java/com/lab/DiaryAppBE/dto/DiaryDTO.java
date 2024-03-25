package com.lab.DiaryAppBE.dto;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiaryDTO {

	private int id;
	
	private String date;
	
	private String content;
	
	private int emotionId;
}
