package com.msaunthaigh.rehearsalscheduler.dao;

import java.util.List;
import java.util.Optional;

import com.msaunthaigh.rehearsalscheduler.entity.ScenePart;

public interface ScenePartDao {
/**
 * 
 * @param sceneId
 * @return
 */
	List<ScenePart> fetchPartsByScene(Integer sceneIdFK, Integer partIdFK, String firstName, String lastName, String characterName, String musicalName);

	public Optional<ScenePart> populateFKFromCastmember(Integer sceneIdFK, Integer partIdfk, Integer castId);


}