package com.msaunthaigh.rehearsalscheduler.service;

import java.util.List;
import java.util.Optional;

import com.msaunthaigh.rehearsalscheduler.entity.CastMember;

public interface CastMemberService {
	
/**
 * 
 * @param castMemberPK
 * @param firstName
 * @param lastName
 * @return
 */
List<CastMember> fetchCastMember(Integer castMemberPK, String firstName, String lastName);


	//intended for use with fetchCastByMusical, possibly fetchCastByScene
//List<CastMember> fetchCastMember(Integer castMemberPK, String firstName, String lastName, String characterName);


/**
 * 
 * @param firstName
 * @param lastName
 * @param characterName
 * @param phoneNumber
 * @param tapPerformer
 * @param costumeComplete
 * @return
 */
Optional<CastMember> newCastMember(String firstName, String lastName, String phoneNumber,
	Boolean tapPerformer, Boolean costumeComplete);

/**
 * 
 * @param firstName
 * @param lastName
 * @param newFirstName
 * @param newLastName
 * @param phoneNumber
 * @param tapPerformer
 * @param costumeComplete
 * @return
 */
Optional<CastMember> updateCastMember(String firstName, String lastName, String newFirstName, String newLastName,
		String phoneNumber, Boolean tapPerformer, Boolean costumeComplete);
	
/**
 * 
 * @param firstName
 * @param lastName
 * @return
 */
Optional<CastMember> deleteCastMember(String firstName, String lastName);

	
}