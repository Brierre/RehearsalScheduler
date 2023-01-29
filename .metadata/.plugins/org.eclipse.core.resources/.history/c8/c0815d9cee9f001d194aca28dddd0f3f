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
	public List<Scene> fetchScenesByMusical(String musicalName) {
		log.info("fetchScenesByMusical has been called for musicalName={}", musicalName);
		
		return sceneDao.fetchScenesByMusical(musicalName);
	
	}
	
	@Override
	public List<Scene> fetchScenesByCastmemberInfo(Integer castmemberId, String firstName, String lastName) {
		log.info("fetchScenesByCastmemberInfo has been called for castmemberId={}, firstName={}, lastName={}", castmemberId, firstName, lastName);
		
		return sceneDao.fetchScenesByCastmemberInfo(castmemberId, firstName, lastName);
	
	}
	
	@Override
	public List<Scene> fetchScenesByPart(String characterName) {
		log.info("fetchScenesByPart has been called for characterName={}", characterName);
		
		return sceneDao.fetchScenesByPart(characterName);
	
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
