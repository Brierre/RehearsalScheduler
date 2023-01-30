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
	
	//GET/READ operation, read/retrieve cast members
	@Transactional
	@Override
	public List<CastMember> fetchCastMember(Integer castmemberId, String firstName, String lastName) {
		log.info("castmemberId={}, firstName={}, lastName={}", castmemberId, firstName, lastName);
		return castMemberDao.fetchCastMember(castmemberId, firstName, lastName);
	}
	
	@Override
	public List<CastMember> fetchCastMemberByMusical(String musicalName) {
		log.info("musicalName={}", musicalName);
		return castMemberDao.fetchCastMemberByMusical(musicalName);
	}
	
	@Override
	public List<CastMember> fetchCastMemberByPart(String characterName) {
		log.info("characterName={}", characterName);
		return castMemberDao.fetchCastMemberByPart(characterName);
	}
	
	//POST/CREATE operation, create new cast member
	@Override
	public Optional<CastMember> newCastMember(String firstName, String lastName, String phoneNumber,
			Boolean tapPerformer, Boolean costumeComplete) {
		log.info("newCastMember has been called for new cast member firstName={}, lastName={}", firstName, lastName);
		return castMemberDao.newCastMember(firstName, lastName, phoneNumber, tapPerformer, costumeComplete);
	}

	//PUT/UPDATE operation, update cast member information
	@Override
	public Optional<CastMember> updateCastMember(String firstName, String lastName, String newFirstName, String newLastName, 
			String phoneNumber, Boolean tapPerformer, Boolean costumeComplete) {
		log.info("updateCastMember has been called for cast member firstName={}, lastName={}. Updated information: newFirstName={}, newLastName={}", 
				firstName, lastName, newFirstName, newLastName);
		return castMemberDao.updateCastMember(firstName, lastName, newFirstName, newLastName, phoneNumber, 
				tapPerformer, costumeComplete);
	}

	//DELETE operation, delete a cast member
	@Override
	public Optional<CastMember> deleteCastMember(String firstName, String lastName, String phoneNumber) {
		log.info("deleteCastMember has been called for cast member firstName={}, lastName={}, phoneNumber={}", firstName, lastName, phoneNumber);
		return castMemberDao.deleteCastMember(firstName, lastName, phoneNumber);
	}

}
