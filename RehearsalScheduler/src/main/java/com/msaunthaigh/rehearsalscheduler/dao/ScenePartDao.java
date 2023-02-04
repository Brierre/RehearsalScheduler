package com.msaunthaigh.rehearsalscheduler.dao;

import java.util.Optional;

import com.msaunthaigh.rehearsalscheduler.entity.ScenePart;

public interface ScenePartDao {
	
	/**
	 * 
	 * @param sceneNumber
	 * @param partNumber
	 * @param musicalName
	 * @return
	 */
	
	Optional<ScenePart> enterScenePartInfo(Integer sceneNumber, Integer partNumber, String musicalName);

}
