package com.msaunthaigh.rehearsalscheduler.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msaunthaigh.rehearsalscheduler.dao.CastMemberDao;
import com.msaunthaigh.rehearsalscheduler.entity.CastMember;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultCastMemberService implements CastMemberService {
	@Autowired
	private CastMemberDao castMemberDao;
	
	@Transactional
	@Override
	public List<CastMember> fetchCastMember(Integer castMemberPK, String firstName, String lastName) {
		log.info("fetchCastMember has been called for castMemberPK={}, firstName={}, lastName={}", castMemberPK, firstName, lastName);
		
		return castMemberDao.fetchCastMember(castMemberPK, firstName, lastName);
	}

	
	//intended for use with fetchCastByMusical, possibly fetchCastByScene
//	@Override
//	public List<CastMember> fetchCastMember(Integer castMemberPK, String firstName, String lastName, String characterName) {
//		log.info("fetchCastMember has been called for castMemberPK={}, firstName={}, lastName={}, characterName={}", castMemberPK, firstName, lastName, characterName);
//		
//		return castMemberDao.fetchCastMember(castMemberPK, firstName, lastName, characterName);
//	}
	
	
	@Override
	public Optional<CastMember> newCastMember(String firstName, String lastName, String phoneNumber,
			Boolean tapPerformer, Boolean costumeComplete) {
		log.info("newCastMember has been called for new cast member firstName={}, lastName={}", firstName, lastName);
		return castMemberDao.newCastMember(firstName, lastName, phoneNumber, tapPerformer, costumeComplete);
	}

	@Override
	public Optional<CastMember> updateCastMember(String firstName, String lastName, String newFirstName, String newLastName, 
			String phoneNumber, Boolean tapPerformer, Boolean costumeComplete) {
		log.info("updateCastMember has been called for cast member firstName={}, lastName={}. Updated information: newFirstName={}, newLastName={}", 
				firstName, lastName, newFirstName, newLastName);
		return castMemberDao.updateCastMember(firstName, lastName, newFirstName, newLastName, phoneNumber, 
				tapPerformer, costumeComplete);
	}

	@Override
	public Optional<CastMember> deleteCastMember(String firstName, String lastName) {
		log.info("deleteCastMember has been called for cast member firstName={}, lastName={}", firstName, lastName);
		return castMemberDao.deleteCastMember(firstName, lastName);
	}

}