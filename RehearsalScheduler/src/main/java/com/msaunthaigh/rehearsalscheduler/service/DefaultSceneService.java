package com.msaunthaigh.rehearsalscheduler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msaunthaigh.rehearsalscheduler.dao.SceneDao;
import com.msaunthaigh.rehearsalscheduler.entity.Scene;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultSceneService implements SceneService {
	@Autowired
	private SceneDao sceneDao;
	
	@Transactional	
	@Override
	public List<Scene> fetchScenes(String musicalName, Integer sceneNumber, String sceneName, String songTitle, String firstName, String lastName, String characterName) {
		log.info("fetchScenes has been called for musicalName={}, sceneNumber={}, sceneName={}, songTitle={}, firstName={}, lastName={}, characterName={}", 
			musicalName, sceneNumber, sceneName, songTitle, firstName, lastName, characterName);
		
		return sceneDao.fetchScenes(musicalName, sceneNumber, sceneName, songTitle, firstName, lastName, characterName);
	
	}

	@Override
	public Optional<Scene> addNewScene(String musicalName, Integer sceneNumber, String sceneName, String songTitle, Integer songId, String act,
			String location, Integer pageBegin, Integer pageEnd) {
		log.info("addNewScene has been called for musicalName={}, sceneNumber={}, sceneName={}, songTitle={}", musicalName, sceneNumber, sceneName, songTitle, songId, act, location, pageBegin, pageEnd);
		return sceneDao.addNewScene(musicalName, sceneNumber, sceneName, songTitle, songId, act, location, pageBegin, pageEnd);
	}

	@Override
	public Optional<Scene> updateScene(String musicalName, Integer sceneNumber, String sceneName, String songTitle, Integer songId,
			String act, String location, Integer pageBegin, Integer pageEnd) {
		log.info("updateScene has been called for musicalName={}, sceneNumber={}, sceneName={}, songTitle={}", musicalName, sceneNumber, sceneName, songTitle, songId, act, location, pageBegin, pageEnd);
		return sceneDao.updateScene(musicalName, sceneNumber, sceneName, songTitle, songId, act, location, pageBegin, pageEnd);
	}

}