package com.msaunthaigh.rehearsalscheduler.service;


import java.util.List;
import java.util.Optional;

import com.msaunthaigh.rehearsalscheduler.entity.Part;

public interface PartService {

	List<Part> fetchPartsByMusical(String musicalName);
	
	List<Part> fetchPartsByScene(String musicalName, Integer sceneNumber);
	
	List<Part> fetchPartsByCastmemberInfo(Integer castmemberId, String firstName, String lastName);
	
	Optional<Part> linkCastmemberToPart(String musicalName, String characterName, String firstName, String lastName);

}
