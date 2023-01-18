package com.msaunthaigh.rehearsalscheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Part {
	private Integer partId;
	private Integer castId;
	private String characterName;
	private String characterGroup;
	private String musicalName;
	private String firstName;
	private String lastName;
	private Integer sceneId;
}