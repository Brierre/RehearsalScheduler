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

import com.msaunthaigh.rehearsalscheduler.entity.Part;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultPartDao implements PartDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	//GET retrieve parts
	@Override
	public List<Part> fetchPartsByMusical(String musicalName) {
		log.info("DAO: musicalName={}", musicalName);
		
		// @formatter:off
		String sql = ""
				+ "SELECT part.part_number, part.musical_name, part.castmember_id, part.character_name, part.character_group, castmember.first_name, castmember.last_name "
				+ "FROM part "
				
				+ "JOIN castmember "
				+ "ON part.castmember_id = castmember.castmember_id "
				
				+ "WHERE part.musical_name = :musical_name "
				+ "AND (part.castmember_id = castmember.castmember_id OR part.castmember_id IS NULL)";
		
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("musical_name", musicalName);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			@Override
			public Part mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return Part.builder()
						.partNumber(rs.getInt("part_number"))
						.castmemberId(rs.getInt("castmember_id"))
						.characterName(rs.getString("character_name"))
						.characterGroup(rs.getString("character_group"))
						.musicalName(rs.getString("musical_name"))
						.firstName(rs.getString("first_name"))
						.lastName(rs.getString("last_name"))
						.build();
				
				// @formatter:on
			}
		});
	}
	
	@Override
	public List<Part> fetchPartsByScene(String musicalName, Integer sceneNumber) {
		log.info("DAO: musicalName={}, sceneNumber={}", musicalName, sceneNumber);
		// @formatter:off
		String sql = ""
				+ "SELECT DISTINCT part.part_number, part.musical_name, part.castmember_id, part.character_name, part.character_group, castmember.first_name, castmember.last_name, scene_part.scene_number "
				+ "FROM part "
				
				+ "JOIN scene_part "
				+ "ON part.part_number = scene_part.part_number "
				
				+ "JOIN castmember "
				+ "ON part.castmember_id = castmember.castmember_id "
				
				+ "WHERE part.musical_name = :musical_name AND scene_part.scene_number = :scene_number";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("musical_name", musicalName);
		params.put("scene_number", sceneNumber);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			@Override
			public Part mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return Part.builder()
						.partNumber(rs.getInt("part_number"))
						.castmemberId(rs.getInt("castmember_id"))
						.characterName(rs.getString("character_name"))
						.characterGroup(rs.getString("character_group"))
						.musicalName(rs.getString("musical_name"))
						.firstName(rs.getString("first_name"))
						.lastName(rs.getString("last_name"))
						.sceneNumber(rs.getInt("scene_number"))
						.build();
				
				// @formatter:on
			}
		});
	}
	
	@Override
	public List<Part> fetchPartsByCastmemberInfo(Integer castmemberId, String firstName, String lastName) {
		log.info("DAO: castmemberId={}, firstName={}, lastName={}", castmemberId, firstName, lastName);
		// @formatter:off
		String sql = ""
				+ "SELECT part.part_number, part.musical_name, part.castmember_id, part.character_name, part.character_group, castmember.first_name, castmember.last_name "
				+ "FROM part "
				
				+ "INNER JOIN castmember "
				+ "ON part.castmember_id = castmember.castmember_id "
				+ "OR part.castmember_id IS NULL "
				
				+ "WHERE (castmember.first_name = :first_name AND castmember.last_name = :last_name) "
				+ "OR castmember.castmember_id = :castmember_id";
		
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("castmember_id", castmemberId);
		params.put("first_name", firstName);
		params.put("last_name", lastName);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			@Override
			public Part mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return Part.builder()
						.partNumber(rs.getInt("part_number"))
						.castmemberId(rs.getInt("castmember_id"))
						.musicalName(rs.getString("musical_name"))
						.characterName(rs.getString("character_name"))
						.characterGroup(rs.getString("character_group"))
						.firstName(rs.getString("first_name"))
						.lastName(rs.getString("last_name"))
						.build();
				
				// @formatter:on
			}
		});
	}
	
	@Override
	public Optional<Part> linkCastmemberToPart(String musicalName, String characterName, String firstName, String lastName) {
		log.info("DAO: musicalName={}, characterName={} assigned to: firstName={}, lastName={}", musicalName, characterName, firstName, lastName);
		
		// @formatter:off
		String sql = ""
				+ "UPDATE part "
				+ "SET castmember_id = ("
				+ "SELECT castmember_id "
				+ "FROM castmember "
				+ "WHERE first_name = :first_name AND last_name = :last_name) "
				+ "WHERE musical_name = :musical_name AND character_name = :character_name";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("musical_name", musicalName);
		params.put("character_name", characterName);
		params.put("first_name", firstName);
		params.put("last_name", lastName);

		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Part.builder()
			// @formatter:off
			.musicalName(musicalName)
			.characterName(characterName)
			.firstName(firstName)
			.lastName(lastName)
			.build());
			// @formatter:on
	    
		  }

	}

	


			


	
	
