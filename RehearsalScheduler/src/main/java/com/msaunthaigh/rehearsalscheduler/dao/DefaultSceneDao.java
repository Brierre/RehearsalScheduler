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
import com.msaunthaigh.rehearsalscheduler.entity.Scene;
import com.msaunthaigh.rehearsalscheduler.entity.ScenePart;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultSceneDao implements SceneDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	//GET retrieve scenes
	@Override
	public List<Scene> fetchScenes(String musicalName, Integer sceneNumber, String sceneName, String songTitle, String firstName, String lastName, String characterName) {
		
		//scenePart.populateFKFromCastmember(); //fill in that castIdFK from null to a value
		
		log.info("DAO: musicalName={}, sceneNumber={}, sceneName={}, songTitle={}, firstName={}, lastName={}, characterName={}",
				musicalName, sceneNumber, sceneName, songTitle, firstName, lastName, characterName);
		
		// @formatter:off
		String sql = ""
				+ "SELECT scene.scene_id, scene.musical_name, scene.scene_number, scene.scene_name, scene.song_title, castmember.first_name, castmember.last_name, part.character_name "
				+ "FROM scene "
				
				+ "JOIN scene_part "
				+ "ON scene_part.scene_id_fk = scene.scene_id "
				
				+ "JOIN part "
				+ "ON part.part_id = scene_part.part_id_fk "
				
				+ "JOIN castmember "
				+ "ON part.castmember_id = castmember.castmember_id "

				+ "WHERE (scene.musical_name = :musical_name "
				+ "OR scene.scene_number = :scene_number "
				+ "OR scene.scene_name = :scene_name "
				+ "OR scene.song_title = :song_title "
				+ "OR part.character_name = :character_name "
				+ "OR (castmember.first_name = :first_name AND castmember.last_name = :last_name))";
		
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("musical_name", musicalName);
		params.put("scene_number", sceneNumber);
		params.put("scene_name", sceneName);
		params.put("song_title", songTitle);
		params.put("first_name", firstName);
		params.put("last_name", lastName);
		params.put("character_name", characterName);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			@Override
			public Scene mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return Scene.builder()
					.musicalName(rs.getString("musical_name"))
					.sceneNumber(rs.getInt("scene_number"))
					.sceneName(rs.getString("scene_name"))
					.songTitle(rs.getString("song_title"))
					.firstName(rs.getString("first_name"))
					.lastName(rs.getString("last_name"))
					.characterName(rs.getString("character_name"))
					.build();
				// @formatter:on
			}
		});
	}

	//POST create a new scene
	@Override
	public Optional<Scene> addNewScene(String musicalName,  Integer sceneNumber, String sceneName, String songTitle, Integer songId, String act,
		String location, Integer pageBegin, Integer pageEnd)  {
		log.info("DAO: musicalName={}, sceneNumber={}, sceneName={}, songTitle={}, songId={}, act={}, location={}, pageBegin={}, pageEnd={}", musicalName, sceneNumber, sceneName, songTitle, songId, act, location, pageBegin, pageEnd);
	
		// @formatter:off
		String sql = ""
				+ "INSERT INTO scene ("
				+ "musical_name, scene_number, scene_name, song_title, song_id, act, location, script_page_begin, script_page_end"
				+ ") VALUES ("
				+ ":musical_name, :scene_number, :scene_name, :song_title, :song_id, :act, :location, :script_page_begin, :script_page_end)";
		// @formatter:on
	
		Map<String, Object> params = new HashMap<>();
		params.put("musical_name", musicalName);
		params.put("scene_number", sceneNumber);
		params.put("scene_name", sceneName);
		params.put("song_title", songTitle);
		params.put("song_id", songId);
		params.put("act", act);
		params.put("location", location);
		params.put("script_page_begin", pageBegin);
		params.put("script_page_end", pageEnd);
	
		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Scene.builder()
			// @formatter:off
			.musicalName(musicalName)
			.sceneNumber(sceneNumber)
			.sceneName(sceneName)
			.songTitle(songTitle)
			.songId(songId)
			.act(act)
			.location(location)
			.pageBegin(pageBegin)
			.pageEnd(pageEnd)
			.build());
			// @formatter:on
		}

	//PUT update a scene's information
	@Override
	public Optional<Scene> updateScene(String musicalName,  Integer sceneNumber, String sceneName, String songTitle, Integer songId, String act, String location, 
		Integer pageBegin, Integer pageEnd) {
		log.info("DAO: musicalName={}, sceneNumber={}, sceneName={}, songTitle={}, songId={}, act={}, location={}, pageBegin={}, pageEnd={} updating...", 
			musicalName, sceneNumber, sceneName, songTitle, songId, act, location, pageBegin, pageEnd);
	
		// @formatter:off
		String sql = ""
				+ "UPDATE scene "
				+ "SET musical_name = :musical_name, scene_number = :sceneNumber, scene_name = :scene_name,  song_title = :song_title, song_id = :song_id, "
				+ "act = :act, location = :location, script_page_begin = :script_page_begin, script_page_end = :script_page_end "
				+ "WHERE (musical_name = :musical_name AND scene_number = :scene_number)";
		// @formatter:on
	
		Map<String, Object> params = new HashMap<>();
		params.put("musical_name", musicalName);
		params.put("scene_number", sceneNumber);
		params.put("scene_name", sceneName);
		params.put("song_title", songTitle);
		params.put("song_id", songId);
		params.put("act", act);
		params.put("location", location);
		params.put("script_page_begin", pageBegin);
		params.put("script_page_end", pageEnd);
	
		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Scene.builder()
			// @formatter:off
			.musicalName(musicalName)
			.sceneNumber(sceneNumber)
			.sceneName(sceneName)
			.songTitle(songTitle)
			.songId(songId)
			.act(act)
			.location(location)
			.pageBegin(pageBegin)
			.pageEnd(pageEnd)
			.build());
		// @formatter:on
	}
}