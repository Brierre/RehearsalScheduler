package com.msaunthaigh.rehearsalscheduler.service;


import java.util.List;
import java.util.Optional;

import com.msaunthaigh.rehearsalscheduler.entity.Part;

public interface PartService {

	/**
	 * 
	 * @param musicalName
	 * @return
	 */
	
	List<Part> fetchPartsByMusical(String musicalName);
	
	/**
	 * 
	 * @param musicalName
	 * @param sceneNumber
	 * @return
	 */
	
	List<Part> fetchPartsByScene(String musicalName, Integer sceneNumber);
	
	/**
	 * 
	 * @param castmemberId
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	
	List<Part> fetchPartsByCastmemberInfo(Integer castmemberId, String firstName, String lastName);
	
	/**
	 * 
	 * @param musicalName
	 * @param characterName
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	
	Optional<Part> linkCastmemberToPart(String musicalName, String characterName, String firstName, String lastName);

}
