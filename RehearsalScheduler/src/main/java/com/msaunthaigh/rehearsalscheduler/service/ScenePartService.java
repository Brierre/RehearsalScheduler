package com.msaunthaigh.rehearsalscheduler.service;

import java.util.List;
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
	
	
	//not needed after database refactor, saved in case I want to go back to the old format
//	Optional<ScenePart> populateFK(Integer sceneNumber);
}
