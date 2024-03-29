package com.msaunthaigh.rehearsalscheduler.service;

import java.util.List;
import java.util.Optional;

import com.msaunthaigh.rehearsalscheduler.entity.Scene;

public interface SceneService {
	
	/**
	 * 
	 * @param musicalName
	 * @return
	 */
	
	List<Scene> fetchScenesByMusical(String musicalName);
	
	/**
	 * 
	 * @param castmemberId
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	
	List<Scene> fetchScenesByCastmemberInfo(Integer castmemberId, String firstName, String lastName);
	
	/**
	 * 
	 * @param characterName
	 * @param musicalName
	 * @return
	 */
	
	List<Scene> fetchScenesByPart(String characterName, String musicalName);
	
	/**
	 * 
	 * @param musicalName
	 * @param sceneNumber
	 * @param sceneName
	 * @param songTitle
	 * @param songId
	 * @param act
	 * @param location
	 * @param pageBegin
	 * @param pageEnd
	 * @return
	 */

	Optional<Scene> addNewScene(String musicalName, Integer sceneNumber,String sceneName, String songTitle, Integer songId, String act,
		String location, Integer pageBegin, Integer pageEnd);
	
	/**
	 * 
	 * @param musicalName
	 * @param sceneNumber
	 * @param sceneName
	 * @param songTitle
	 * @param songId
	 * @param act
	 * @param location
	 * @param pageBegin
	 * @param pageEnd
	 * @return
	 */

	Optional<Scene> updateScene(String musicalName, Integer sceneNumber,String sceneName, String songTitle, Integer songId, String act,
		String location, Integer pageBegin, Integer pageEnd);
}
