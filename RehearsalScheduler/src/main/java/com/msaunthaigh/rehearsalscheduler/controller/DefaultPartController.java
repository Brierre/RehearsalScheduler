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
	//A director may need to find a list of all parts in a show. 
	//This information is included with the scene/part/scene_part data that comes with the application database.
	@Override
	public List<Part> fetchPartsByMusical(String musicalName) {
		log.info("musicalName={}", musicalName);
		return partService.fetchPartsByMusical(musicalName);
	}
	
	//Directors may search which parts are needed for a scene, such as in the event a student says "Am I in that scene we are practicing today?"
	//This will be useful in future functionality too, when the application creates a schedule.
	@Override
	public List<Part> fetchPartsByScene(String musicalName, Integer sceneNumber) {
		log.info("musicalName={}, sceneNumber={}", musicalName, sceneNumber);
		return partService.fetchPartsByScene(musicalName, sceneNumber);
	}
	
	//Directors may search who plays a specific part (e.g. Who plays Chorus Nun #3?)
	@Override
	public List<Part> fetchPartsByCastmemberInfo(Integer castmemberId, String firstName, String lastName) {
		log.info("castmemberId={}, firstName={}, lastName={}", castmemberId, firstName, lastName);
		return partService.fetchPartsByCastmemberInfo(castmemberId, firstName, lastName);
	}
	
	//PUT operation, update part with castmember information
	//This method assigns an existing cast member to a part. 
	//This will need to be done in order to run some other methods, such as fetchPartsByCastmemberInfo().
	@Override
	public Optional<Part> linkCastmemberToPart(String musicalName, String characterName, String firstName, String lastName) {
		log.info("musicalName={}, characterName={}, firstName={}, lastName={}", musicalName, characterName, firstName, lastName);
		return partService.linkCastmemberToPart(musicalName, characterName, firstName, lastName);
	}
	
}

