package com.msaunthaigh.rehearsalscheduler.dao;

import java.util.List;
import java.util.Optional;

import com.msaunthaigh.rehearsalscheduler.entity.Scene;

public interface SceneDao {
	/**
	 * 
	 * @param musicalName
	 * @param sceneName
	 * @param songTitle
	 * @return
	 */
	List<Scene> fetchScenesByMusical(String musicalName);
	
	List<Scene> fetchScenesByCastmemberInfo(Integer castmemberId, String firstName, String lastName);
	
	List<Scene> fetchScenesByPart(String characterName);
	
	Optional<Scene> addNewScene(String musicalName, Integer sceneNumber, String sceneName, String songTitle, Integer songId, String act, String location, 
		Integer pageBegin, Integer pageEnd);

	Optional<Scene> updateScene(String musicalName, Integer sceneNumber, String sceneName, String songTitle, Integer songId, String act,
		String location, Integer pageBegin, Integer pageEnd);

}
