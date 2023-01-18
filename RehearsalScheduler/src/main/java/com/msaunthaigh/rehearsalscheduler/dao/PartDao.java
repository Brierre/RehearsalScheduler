package com.msaunthaigh.rehearsalscheduler.dao;

import java.util.List;
import java.util.Optional;

import com.msaunthaigh.rehearsalscheduler.entity.Part;

public interface PartDao {
/**
 * 
 * @param partId
 * @param castId
 * @param characterName
 * @param characterGroup
 * @return
 */
	
	List<Part> fetchParts(Integer partId, Integer castId, String characterName, String characterGroup, 
			String musicalName, String firstName, String lastName, Integer sceneId);
	
}
