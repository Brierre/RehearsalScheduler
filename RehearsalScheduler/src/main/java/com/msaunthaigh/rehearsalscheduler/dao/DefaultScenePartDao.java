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

import com.msaunthaigh.rehearsalscheduler.entity.ScenePart;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultScenePartDao implements ScenePartDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<ScenePart> fetchPartsByScene(Integer sceneIdFK, Integer partIdFK, String firstName, String lastName, String characterName, String musicalName) {
		log.info("DAO: fetching parts for sceneIdFK={}", sceneIdFK);
		
		// @formatter:off
		String sql = ""
				+ "SELECT scene_id_fk, part_id_fk, scene.scene_name, scene.song_title, part.character_name, castmember.first_name, "
				+ "castmember.last_name, scene.musical_name "
				+ "FROM scene_part "
				+ "JOIN scene "
				+ "ON scene.scene_id = scene_part.scene_id_fk "
				+ "JOIN part "
				+ "ON part.part_id = scene_part.part_id_fk "
				+ "JOIN castmember "
				+ "ON castmember.character_name = part.character_name "
				+ "WHERE scene.scene_id = :scene_id_fk OR part.part_id = :part_id_fk OR ((castmember.first_name = :first_name OR "
				+ "castmember.last_name = :last_name OR castmember.character_name = :character_name) AND scene.musical_name = :musical_name)";
		
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("scene_id_fk", sceneIdFK);
		params.put("part_id_fk", partIdFK);
		params.put("first_name", firstName);
		params.put("last_name", lastName);
		params.put("character_name", characterName);
		params.put("musical_name", musicalName);

		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			@Override
			public ScenePart mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return ScenePart.builder()
					.sceneIdFK(rs.getInt("scene_id_fk"))
					.partIdFK(rs.getInt("part_id_fk"))
					.firstName(rs.getString("first_name"))
					.lastName(rs.getString("last_name"))
					.characterName(rs.getString("character_name"))
					.musicalName(rs.getString("musical_name"))
					.build();
				// @formatter:on
			}
		});
	}
	
	public Optional<ScenePart> populateFKFromCastmember(Integer sceneIdFK, Integer partIdFK, Integer castId) {
		log.info("DAO: sceneIdFK={}, partIdfk={}, castId={}", sceneIdFK, partIdFK, castId);
		
		// @formatter:off
		String sql = ""
				+ "UPDATE scene_part "
				+ "SET cast_id_fk = :cast_id_fk "
				+ "WHERE scene_id_fk = :scene_id_fk AND part_id_fk = :part_id_fk";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("scene_id_fk", sceneIdFK);
		params.put("part_id_fk", partIdFK);
		params.put("cast_id_fk", castId);
		
		jdbcTemplate.update(sql, params);
		// @formatter:off
		return Optional.ofNullable(ScenePart
			.builder()
			.sceneIdFK(sceneIdFK)
			.partIdFK(partIdFK)
			.castId(castId)
			.build());
		// @formatter:on
	}

}