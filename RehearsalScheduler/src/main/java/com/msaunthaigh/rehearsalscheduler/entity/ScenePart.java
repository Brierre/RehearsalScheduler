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
	private Integer scenePartPK;
	private Integer sceneNumber;
	private Integer partNumber;
	private String musicalName;
	
}
