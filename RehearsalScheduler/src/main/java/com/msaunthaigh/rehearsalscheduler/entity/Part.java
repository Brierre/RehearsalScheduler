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
	private Integer partNumber;
	private String musicalName;
	private Integer castmemberId;
	private String characterName;
	private String characterGroup;
	private String firstName;
	private String lastName;
	private Integer sceneNumber;
	
}
