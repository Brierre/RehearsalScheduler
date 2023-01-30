package com.msaunthaigh.rehearsalscheduler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msaunthaigh.rehearsalscheduler.dao.ScenePartDao;
import com.msaunthaigh.rehearsalscheduler.entity.CastMember;
import com.msaunthaigh.rehearsalscheduler.entity.ScenePart;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultScenePartService implements ScenePartService {
	@Autowired
	private ScenePartDao scenePartDao;
	
	@Transactional
	@Override
	public Optional<ScenePart> enterScenePartInfo(Integer sceneNumber, Integer partNumber, String musicalName) {
		log.info("enterScenePartInfo has been called for sceneNumber={}, partNumber={}, musicalName={}", sceneNumber, partNumber, musicalName);
		return scenePartDao.enterScenePartInfo(sceneNumber, partNumber, musicalName);
	}

}
