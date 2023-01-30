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
	public List<Part> fetchPartsByMusical(String musicalName) {
		log.info("fetchPart has been called: musicalName={}", musicalName);
		
		return partDao.fetchPartsByMusical(musicalName);
	}
	
	@Override
	public List<Part> fetchPartsByScene(String musicalName, Integer sceneNumber) {
		log.info("fetchPart has been called: musicalName={}, sceneNumber={}", musicalName, sceneNumber);
		
		return partDao.fetchPartsByScene(musicalName, sceneNumber);
	}
	
	@Override
	public List<Part> fetchPartsByCastmemberInfo(Integer castmemberId, String firstName, String lastName) {
		log.info("fetchPart has been called: partNumber={}, castmemberId={}, firstName={}, lastName={}", castmemberId, firstName, lastName);
		
		return partDao.fetchPartsByCastmemberInfo(castmemberId, firstName, lastName);
	}
	
	@Override
	public Optional<Part> linkCastmemberToPart(String musicalName, String characterName, String firstName, String lastName) {
		log.info("linkCastmemberToPart has been called: musicalName={}, characterName={}, firstName={}, lastName={}", musicalName, characterName, firstName, lastName);
		
		return partDao.linkCastmemberToPart(musicalName, characterName, firstName, lastName);
	}

}
