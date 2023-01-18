package com.msaunthaigh.rehearsalscheduler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msaunthaigh.rehearsalscheduler.dao.PartDao;
import com.msaunthaigh.rehearsalscheduler.entity.Part;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPartService implements PartService {
	@Autowired
	private PartDao partDao;
	
	@Transactional
	@Override
	public List<Part> fetchParts(Integer partId, Integer castId, String characterName, String characterGroup, 
			String musicalName, String firstName, String lastName, Integer sceneId) {
		log.info("fetchPart has been called: partId={}, castId={}, characterName={}, characterGroup={}, "
				+ "musicalName={}, firstName={}, lastName={}, sceneId={}", partId, castId, characterName, characterGroup,
				musicalName, firstName, lastName, sceneId);
		
		return partDao.fetchParts(partId, castId, characterName, characterGroup, musicalName, firstName, lastName, sceneId);
	}
	

}