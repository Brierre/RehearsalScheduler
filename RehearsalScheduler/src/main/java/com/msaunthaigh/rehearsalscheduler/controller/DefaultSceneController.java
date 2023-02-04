package com.msaunthaigh.rehearsalscheduler.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.msaunthaigh.rehearsalscheduler.entity.Scene;
import com.msaunthaigh.rehearsalscheduler.service.SceneService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultSceneController implements SceneController {
	@Autowired
	private SceneService sceneService;
	
	//GET operation, read/retrieve scenes
	@Override
	public List<Scene> fetchScenesByMusical(String musicalName) {
		log.info("musicalName={}", musicalName);
		return sceneService.fetchScenesByMusical(musicalName);
	}
	
	@Override
	public List<Scene> fetchScenesByCastmemberInfo(Integer castmemberId, String firstName, String lastName) {
		log.info("castmemberId={}, firstName={}, lastName={}", castmemberId, firstName, lastName);
		return sceneService.fetchScenesByCastmemberInfo(castmemberId, firstName, lastName);
	}
	
	@Override
	public List<Scene> fetchScenesByPart(String characterName, String musicalName) {
		log.info("characterName={}, musicalName={}", characterName, musicalName);
		return sceneService.fetchScenesByPart(characterName, musicalName);
	}
	
	
	//POST operation, add scene
	@Override
	public Optional<Scene> addNewScene(String musicalName, Integer sceneNumber, String sceneName, String songTitle, Integer songId, String act, String location, 
			Integer pageBegin, Integer pageEnd) {
		log.info("Added scene: musicalName={}, sceneNumber={}, sceneName={}, songTitle={}, songId={}, act={}, location={}, pageBegin={}, pageEnd={}", 
				musicalName, sceneNumber, sceneName, songTitle, songId, act, location, pageBegin, pageEnd);
		return sceneService.addNewScene(musicalName, sceneNumber, sceneName, songTitle, songId, act, location, pageBegin, pageEnd);
	}
	
	//PUT operation, update scene
	@Override
	public Optional<Scene> updateScene(String musicalName, Integer sceneNumber, String sceneName, String songTitle, Integer songId,
			String act, String location, Integer pageBegin, Integer pageEnd) {
		log.info("updateScene has been called for musicalName={}, sceneNumber={}, sceneName={}, songTitle={}", musicalName, sceneName, songTitle, songId, act, location, pageBegin, pageEnd);
		return sceneService.updateScene(musicalName, sceneNumber, sceneName, songTitle, songId, act, location, pageBegin, pageEnd);
	}
}
