package com.msaunthaigh.rehearsalscheduler.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.msaunthaigh.rehearsalscheduler.entity.CastMember;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultCastMemberDao implements CastMemberDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<CastMember> fetchCastMember(Integer castmemberId, String firstName, String lastName) {
		log.info("DAO: castmemberId={}, firstName={}, lastName={}", castmemberId, firstName, lastName);
		
		// @formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM castmember "
				+ "WHERE castmember.castmember_id = :castmember_id OR (castmember.first_name = :first_name AND castmember.last_name = :last_name)";
		
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("castmember_id", castmemberId);
		params.put("first_name", firstName);
		params.put("last_name", lastName);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			@Override
			public CastMember mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return CastMember.builder()
						.castmemberId(rs.getInt("castmember_id"))
						.firstName(new String(rs.getString("first_name")))
						.lastName(new String(rs.getString("last_name")))
						.phoneNumber(new String(rs.getString("phone_number")))
						.tapPerformer(rs.getBoolean("tap_performer"))
						.costumeComplete(rs.getBoolean("costume_complete"))
						.build();
				// formatter:on
			}
		});
	}
	
	@Override
	public List<CastMember> fetchCastMemberByMusical(String musicalName) {
		log.info("DAO: musicalName={}", musicalName);
		
		// @formatter:off
		String sql = ""
				+ "SELECT castmember.castmember_id, castmember.first_name, castmember.last_name, "
				+ "castmember.phone_number, castmember.tap_performer, castmember.costume_complete, part.musical_name "
				+ "FROM castmember "
				+ "JOIN part "
				+ "ON castmember.castmember_id = part.castmember_id "
				+ "OR (part.castmember_id IS NULL) "
				+ "WHERE musical_name = :musical_name";
		
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("musical_name", musicalName);
	
		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			@Override
			public CastMember mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return CastMember.builder()
						.castmemberId(rs.getInt("castmember_id"))
						.firstName(new String(rs.getString("first_name")))
						.lastName(new String(rs.getString("last_name")))
						.musicalName(new String(rs.getString("musical_name")))
						.phoneNumber(new String(rs.getString("phone_number")))
						.tapPerformer(rs.getBoolean("tap_performer"))
						.costumeComplete(rs.getBoolean("costume_complete"))
						.build();
				// formatter:on
			}
		});
	}
	
	@Override
	public List<CastMember> fetchCastMemberByPart(String characterName) {
		log.info("DAO: characterName={}", characterName);
		
		// @formatter:off
		String sql = ""
				+ "SELECT castmember.castmember_id, castmember.first_name, castmember.last_name, castmember.phone_number, "
				+ "castmember.tap_performer, castmember.costume_complete, part.character_name, part.musical_name "
				+ "FROM castmember "
				+ "JOIN part "
				+ "ON castmember.castmember_id = part.castmember_id "
				+ "WHERE part.character_name = :character_name";
		
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("character_name", characterName);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			@Override
			public CastMember mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return CastMember.builder()
						.castmemberId(rs.getInt("castmember_id"))
						.firstName(new String(rs.getString("first_name")))
						.lastName(new String(rs.getString("last_name")))
						.phoneNumber(new String(rs.getString("phone_number")))
						.tapPerformer(rs.getBoolean("tap_performer"))
						.costumeComplete(rs.getBoolean("costume_complete"))
						.build();
				// formatter:on
			}
		});
	}
	
	@Override
	public Optional<CastMember> newCastMember(String firstName, String lastName, String phoneNumber,
			Boolean tapPerformer, Boolean costumeComplete) {
		log.info("DAO: firstName={}, lastName={}, phoneNumber={}, tapPerformer={}, costumeComplete={}", firstName, lastName, phoneNumber, tapPerformer, costumeComplete);
		
		// @formatter:off
		String sql = ""
				+ "INSERT INTO castmember ("
				+ "first_name, last_name, phone_number, tap_performer, costume_complete"
				+ ") VALUES ("
				+ ":first_name, :last_name, :phone_number, :tap_performer, :costume_complete)";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("first_name", firstName);
		params.put("last_name", lastName);
		params.put("phone_number", phoneNumber);
		params.put("tap_performer", tapPerformer);
		params.put("costume_complete", costumeComplete);
		
		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(CastMember.builder()
			// @formatter:off
			.firstName(firstName)
			.lastName(lastName)
			.phoneNumber(phoneNumber)
			.tapPerformer(tapPerformer)
			.costumeComplete(costumeComplete)
			.build());
			// @formatter:on
		}
	
	@Override
	public Optional<CastMember> updateCastMember(String firstName, String lastName, String newFirstName, String newLastName,
			String phoneNumber, Boolean tapPerformer, Boolean costumeComplete) {
		log.info("DAO: firstName={}, lastName={} updated to: newFirstName={}, newLastName={}, phoneNumber={}, tapPerformer={}, costumeComplete={}", 
				firstName, lastName, newFirstName, newLastName, phoneNumber, tapPerformer, costumeComplete);
		
		// @formatter:off
		String sql = ""
				+ "UPDATE castmember "
				+ "SET new_first_name = :new_first_name, new_last_name = :new_last_name, first_name = :new_first_name, "
				+ "last_name = :new_last_name, phone_number = :phone_number, tap_performer = :tap_performer, costume_complete = :costume_complete "
				+ "WHERE (first_name = :first_name AND "
				+ "last_name = :last_name)";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("new_first_name", newFirstName);
		params.put("new_last_name", newLastName);
		params.put("first_name", firstName);
		params.put("last_name", lastName);
		params.put("phone_number", phoneNumber);
		params.put("tap_performer", tapPerformer);
		params.put("costume_complete", costumeComplete);
		
		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(CastMember.builder()
			// @formatter:off
			.firstName(newFirstName)
			.lastName(newLastName)
			.phoneNumber(phoneNumber)
			.tapPerformer(tapPerformer)
			.costumeComplete(costumeComplete)
			.build());
			// @formatter:on
	}

	@Override
	public Optional<CastMember> deleteCastMember(String firstName, String lastName, String phoneNumber) {
		//@ formatter:off
		String sql = ""
			+ "DELETE FROM castmember "
			+ "WHERE first_name = :first_name AND "
			+ "last_name = :last_name AND "
			+ "(phone_number = :phone_number OR phone_number IS NULL)";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("first_name", firstName);
		params.put("last_name", lastName);
		params.put("phone_number", phoneNumber);
	
		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(CastMember
			// @formatter:off
			.builder()
			.firstName(firstName)
			.lastName(lastName)
			.phoneNumber(phoneNumber)
			.build());
			// @formatter:on
	}
	
}


