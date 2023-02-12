package com.msaunthaigh.rehearsalscheduler.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.msaunthaigh.rehearsalscheduler.entity.CastMember;
import com.msaunthaigh.rehearsalscheduler.service.CastMemberService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCastMemberController implements CastMemberController {
	@Autowired
	private CastMemberService castMemberService;
	
	//GET/READ operation, read/retrieve cast members
	//Directors may retrieve information about cast members as needed after the cast members have been entered.
	@Override
	public List<CastMember> fetchCastMember(Integer castmemberId, String firstName, String lastName) {
		log.info("castmemberId={}, firstName={}, lastName={}", castmemberId, firstName, lastName);
		return castMemberService.fetchCastMember(castmemberId, firstName, lastName);
	}
	
	//Directors may want to search for all cast members who are in a particular musical. 
	//This should be done after cast members have been assigned a part in a musical using the update part operation.
	@Override
	public List<CastMember> fetchCastMemberByMusical(String musicalName) {
		log.info("musicalName={}", musicalName);
		return castMemberService.fetchCastMemberByMusical(musicalName);
	}
	
	//Directors may want to search for which cast member is assigned to a certain part.
	//This should be done after cast members have been assigned a part in a musical using the update part operation.
	@Override
	public List<CastMember> fetchCastMemberByPart(String characterName) {
		log.info("characterName={}", characterName);
		return castMemberService.fetchCastMemberByPart(characterName);
	}
	
	
	//CREATE operation, create a new cast member
	//Directors may create cast members at anytime after database is connected. This will not affect any other information at the time of creation.
	@Override	
	public Optional<CastMember> newCastMember(String firstName, String lastName, String phoneNumber, Boolean tapPerformer, 
			Boolean costumeComplete) {
		log.info("firstName={}, lastName={}, phoneNumber={}, tapPerformer={}, costumeComplete={}", firstName, lastName, phoneNumber, tapPerformer, costumeComplete);
		return castMemberService.newCastMember(firstName, lastName, phoneNumber, tapPerformer, costumeComplete);
	}
	
	
	//UPDATE operation, change cast member information
	//Update cast information may only be performed on an existing cast member.  Duh.
	@Override
	public Optional<CastMember> updateCastMember(String firstName, String lastName, String newFirstName, String newLastName, 
			String phoneNumber, Boolean tapPerformer, Boolean costumeComplete) {
		log.info("newFirstName={}, newLastName={}, phoneNumber={}, tapPerformer={}, costumeComplete={}", 
			newFirstName, newLastName, phoneNumber, tapPerformer, costumeComplete);
		return castMemberService.updateCastMember (firstName, lastName, newFirstName, newLastName,
			 phoneNumber, tapPerformer, costumeComplete);
	}
	
	
	//DELETE operation, delete a cast member from the list
	//A director may delete a cast member as needed.
	@Override
	public Optional<CastMember> deleteCastMember(String firstName, String lastName, String phoneNumber) {
		log.info("firstName={}, lastName={}, phoneNumber={}", firstName, lastName, phoneNumber);
		return castMemberService.deleteCastMember(firstName, lastName, phoneNumber);
	}
	
	
}
