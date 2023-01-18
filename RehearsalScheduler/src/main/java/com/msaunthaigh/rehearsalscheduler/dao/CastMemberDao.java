package com.msaunthaigh.rehearsalscheduler.dao;

import java.util.List;
import java.util.Optional;

import com.msaunthaigh.rehearsalscheduler.entity.CastMember;

public interface CastMemberDao {
	
	/**
	 * 
	 * @param castMemberPK
	 * @param firstName
	 * @param lastName
	 * @return
	 */

	List<CastMember> fetchCastMember(Integer castMemberPK, String firstName, String lastName);
	
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