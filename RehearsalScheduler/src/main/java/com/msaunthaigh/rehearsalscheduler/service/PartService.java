package com.msaunthaigh.rehearsalscheduler.service;


import java.util.List;
import java.util.Optional;

import com.msaunthaigh.rehearsalscheduler.entity.Part;

public interface PartService {

	List<Part> fetchParts(Integer partId, Integer castId, String characterName, String characterGroup, 
			String musicalName, String firstName, String lastName, Integer sceneId);

}