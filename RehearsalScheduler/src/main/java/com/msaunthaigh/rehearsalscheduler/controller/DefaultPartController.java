package com.msaunthaigh.rehearsalscheduler.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.msaunthaigh.rehearsalscheduler.entity.CastMember;
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
	public List<Part> fetchPartsByMusical(String musicalName) {
		log.info("musicalName={}", musicalName);
		return partService.fetchPartsByMusical(musicalName);
	}
	
	@Override
	public List<Part> fetchPartsByScene(String musicalName, Integer sceneNumber) {
		log.info("musicalName={}, sceneNumber={}", musicalName, sceneNumber);
		return partService.fetchPartsByScene(musicalName, sceneNumber);
	}
	
	@Override
	public List<Part> fetchPartsByCastmemberInfo(Integer castmemberId, String firstName, String lastName) {
		log.info("castmemberId={}, firstName={}, lastName={}", castmemberId, firstName, lastName);
		return partService.fetchPartsByCastmemberInfo(castmemberId, firstName, lastName);
	}
	
	@Override
	public Optional<Part> linkCastmemberToPart(String musicalName, String characterName, String firstName, String lastName) {
		log.info("musicalName={}, characterName={}, firstName={}, lastName={}", musicalName, characterName, firstName, lastName);
		return partService.linkCastmemberToPart(musicalName, characterName, firstName, lastName);
	}
	
}

