package com.msaunthaigh.rehearsalscheduler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msaunthaigh.rehearsalscheduler.dao.ScenePartDao;
import com.msaunthaigh.rehearsalscheduler.entity.ScenePart;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultScenePartService implements ScenePartService {
	@Autowired
	private ScenePartDao scenePartDao;
	
	@Transactional
	@Override
	public List<ScenePart> fetchPartsByScene(Integer sceneIdFK, Integer partIdFK, String firstName, String lastName, String characterName, String musicalName) {
		log.info("matchPartsToScene has been called for sceneIdFK={}, partIdFK={}", sceneIdFK, partIdFK);
		return scenePartDao.fetchPartsByScene(sceneIdFK, partIdFK, firstName, lastName, characterName, musicalName);
	}

	@Override
	public Optional<ScenePart> populateFKFromCastmember(Integer sceneIdFK, Integer partIdFK, Integer castId) {
		log.info("populateFKFromCastmember has been called for sceneIdFK={}", sceneIdFK, partIdFK, castId);
		return scenePartDao.populateFKFromCastmember(sceneIdFK, partIdFK, castId);
	}

}
