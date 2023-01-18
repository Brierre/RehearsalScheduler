package com.msaunthaigh.rehearsalscheduler.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.msaunthaigh.rehearsalscheduler.entity.Part;
import com.msaunthaigh.rehearsalscheduler.service.PartService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultPartController implements PartController {

	@Autowired
	private PartService partService;
	
	//GET operation, read/retrieve parts
	
	@Override
	public List<Part> fetchParts(Integer partId, Integer castId, String characterName, String characterGroup, 
			String musicalName, String firstName, String lastName, Integer sceneId) {
		log.info("partId={}, castId={}, characterName={}, characterGroup={}, musicalName={}, firstName={}, lastName={}, sceneId={}", 
			partId, castId, characterName, characterGroup, musicalName, firstName, lastName, sceneId);
		return partService.fetchParts(partId, castId, characterName, characterGroup, musicalName, firstName, lastName, sceneId);
	}
	
}

