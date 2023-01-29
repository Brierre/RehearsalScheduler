package com.msaunthaigh.rehearsalscheduler.dao;

import java.util.List;
import java.util.Optional;

import com.msaunthaigh.rehearsalscheduler.entity.CastMember;

public interface CastMemberDao {
/**
 * 
 * @param castmemberId
 * @param firstName
 * @param lastName
 * @return
 */

	List<CastMember> fetchCastMember(Integer castmemberId, String firstName, String lastName);
	
	/**
	 * 
	 * @param musicalName
	 * @return
	 */
	
	List<CastMember> fetchCastMemberByMusical(String musicalName);
	
	/**
	 * 
	 * @param characterName
	 * @return
	 */
	
	List<CastMember> fetchCastMemberByPart(String characterName);
	
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
	 * @param phoneNumber
	 * @return
	 */
	
	Optional<CastMember> deleteCastMember(String firstName, String lastName, String phoneNumber);

}
