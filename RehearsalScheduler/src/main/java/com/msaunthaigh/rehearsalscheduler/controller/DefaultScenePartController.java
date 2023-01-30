package com.msaunthaigh.rehearsalscheduler.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msaunthaigh.rehearsalscheduler.entity.CastMember;
import com.msaunthaigh.rehearsalscheduler.entity.ScenePart;
import com.msaunthaigh.rehearsalscheduler.service.ScenePartService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultScenePartController implements ScenePartController {
	@Autowired
	private ScenePartService scenePartService;
	
	//POST/CREATE operation, create an entry in scene_part
	@Override
	public Optional<ScenePart> enterScenePartInfo(Integer sceneNumber, Integer partNumber, String musicalName) {
		log.info("sceneNumber={}, partNumber={}, musicalName={}", sceneNumber, partNumber, musicalName);
		return scenePartService.enterScenePartInfo(sceneNumber, partNumber, musicalName);
	}
}



