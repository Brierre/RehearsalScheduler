package com.msaunthaigh.rehearsalscheduler.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Optional<ScenePart> enterScenePartInfo(Integer sceneNumber, Integer partNumber, String musicalName) {
		log.info("DAO: sceneNumber={}, partNumber={}, musicalName={}", sceneNumber, partNumber, musicalName);
		
		// @formatter:off
		String sql = ""
				+ "INSERT INTO scene_part ("
				+ "scene_number, part_number, musical_name) "
				+ "VALUES ("
				+ ":scene_number, :part_number, :musical_name)";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("scene_number", sceneNumber);
		params.put("part_number", partNumber);
		params.put("musical_name", musicalName);
		
		jdbcTemplate.update(sql, params);
			return Optional.ofNullable(ScenePart.builder()
				// @formatter:off
				.sceneNumber(sceneNumber)
				.partNumber(partNumber)
				.musicalName(musicalName)
				.build());
				// @formatter:on
			}

}