package com.msaunthaigh.rehearsalscheduler.service;

import java.util.Optional;

import com.msaunthaigh.rehearsalscheduler.entity.ScenePart;

public interface ScenePartService {
	/**
	 * 
	 * @param sceneNumber
	 * @param partNumber
	 * @param musicalName
	 * @return
	 */
	
	Optional<ScenePart> enterScenePartInfo(Integer sceneNumber, Integer partNumber, String musicalName);
	
}
