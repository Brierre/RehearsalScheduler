package com.msaunthaigh.rehearsalscheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Scene {
	public static int sceneIdPK;
	private String musicalName;
	private Integer sceneNumber;
	private String sceneName;
	private String songTitle;
	private Integer songId;
	private String act;
	private String location;
	private Integer pageBegin;
	private Integer pageEnd;
	private String firstName;
	private String lastName;
	private String characterName;
}