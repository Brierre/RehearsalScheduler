package com.msaunthaigh.rehearsalscheduler.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.msaunthaigh.rehearsalscheduler.entity.ScenePart;
import com.msaunthaigh.rehearsalscheduler.service.ScenePartService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultScenePartController implements ScenePartController {
	@Autowired
	private ScenePartService scenePartService;

	@Override
	public List<ScenePart> fetchPartsByScene(Integer sceneIdFK, Integer partIdFK, String firstName, String lastName, String characterName, String musicalName) {
		log.info("fetching parts for sceneIdFK={}", sceneIdFK);
		return scenePartService.fetchPartsByScene(sceneIdFK, partIdFK, firstName, lastName, characterName, musicalName);
	}
	
	//UPDATE operation, populate cast_id column from castmember, previously null
	@Override
	public Optional<ScenePart> populateFKFromCastmember(Integer sceneIdFK, Integer partIdFK, Integer castId) {
		log.info("sceneIdFK={}, partIdFK={}, castIdFK={}", sceneIdFK, partIdFK, castId);
		return scenePartService.populateFKFromCastmember(sceneIdFK, partIdFK, castId);
		}


	
}


