package com.msaunthaigh.rehearsalscheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScenePart {
	private Integer sceneIdFK;
	private Integer partIdFK;
	private Integer castId;
	private String firstName;
	private String lastName;
	private String characterName;
	private String musicalName;
	
}