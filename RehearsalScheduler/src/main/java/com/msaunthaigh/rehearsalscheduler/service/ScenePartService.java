package com.msaunthaigh.rehearsalscheduler.service;

import java.util.List;
import java.util.Optional;

import com.msaunthaigh.rehearsalscheduler.entity.ScenePart;

public interface ScenePartService {

	List<ScenePart> fetchPartsByScene(Integer sceneIdFK, Integer partIdFK, String firstName, String lastName, String characterName, String musicalName);

	Optional<ScenePart> populateFKFromCastmember(Integer sceneIdFK, Integer partIdFK, Integer castId);

}
