package com.msaunthaigh.rehearsalscheduler.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.ResultSetExtractor;
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
	
	@Override
	public List<Part> fetchParts(Integer partId, Integer castId, String characterName, 
			String characterGroup, String musicalName, String firstName, String lastName, Integer sceneId) {
		log.info("DAO: partId={}, castId={}, characterName={}, characterGroup={}, musicalName={}, firstName={}, lastName={}, sceneId={}",
				partId, castId, characterName, characterGroup, musicalName, firstName, lastName, sceneId);
		// @formatter:off
		String sql = ""
				+ "SELECT part.part_id, part.castmember_id, part.character_name, part.character_group, "
				+ "part.musical_name, castmember.first_name, castmember.last_name, scene.scene_id "
				+ "FROM part "
				
				+ "JOIN scene_part "
				+ "ON part.part_id = scene_part.part_id_fk "
				
				+ "JOIN castmember "
				+ "ON part.castmember_id = castmember.castmember_id "
				
				+ "JOIN scene "
				+ "ON (SELECT MIN(scene.scene_id) = scene_part.scene_id_fk "
				
				+ "WHERE part.musical_name = :musical_name "
				+ "OR part.part_id = :part_id "
				+ "OR scene.scene_id = :scene_id "
				+ "OR ((castmember.first_name = :first_name AND castmember.last_name = :last_name) OR (castmember.castmember_id = :castmember_id))";
		
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("part_id", partId);
		params.put("castmember_id", castId);
		params.put("character_name", characterName);
		params.put("character_group", characterGroup);
		params.put("musical_name", musicalName);
		params.put("first_name", firstName);
		params.put("last_name", lastName);
		params.put("scene_id", sceneId);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			@Override
			public Part mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return Part.builder()
						.partId(rs.getInt("part_id"))
						.castId(rs.getInt("castmember_id"))
						.characterName(rs.getString("character_name"))
						.characterGroup(rs.getString("character_group"))
						.musicalName(rs.getString("musical_name"))
						.firstName(rs.getString("first_name"))
						.lastName(rs.getString("last_name"))
						.sceneId(rs.getInt("scene_id"))
						.build();
				
				// @formatter:on
			}
		});
	}
	
}
	


			


	
	