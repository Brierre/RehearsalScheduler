package com.msaunthaigh.rehearsalscheduler.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.msaunthaigh.rehearsalscheduler.entity.CastMember;
import com.msaunthaigh.rehearsalscheduler.entity.ScenePart;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/scene_part")

@OpenAPIDefinition(info = @Info(title = "Scenes and Parts"),
servers = {@Server(url = "http://localhost:8080", description = "Local server")})
public interface ScenePartController {	

//POST creates a new cast member in database
//newCastMember()
	// @formatter:off
	@Operation(
		summary = "Add scene-part",
		description = "Creates a new entry to connect a scene to a part",
		responses = {
			@ApiResponse(
				responseCode = "201",
				description = "New cast member created",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = CastMember.class))),
			@ApiResponse(
				responseCode = "400",
				description = "Invalid request parameters",
				content = @Content(
					mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404",
				description = "Unable to create new cast member with the information given",
				content = @Content(
					mediaType = "application/json")),
			@ApiResponse(
				responseCode = "500",
				description = "An unplanned error has occurred.",
				content = @Content(
					mediaType = "application/json"))
		},
			
		parameters = {
			@Parameter(
				name = "sceneNumber",
				allowEmptyValue = false,
				required = true,
				description = "Scene Number"),
			@Parameter(
				name = "partNumber",
				allowEmptyValue = false,
				required = true,
				description = "Part Number"),
			@Parameter(
				name = "musicalName",
				allowEmptyValue = false,
				required = true,
				description = "Musical Name")
		}
	)
		
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Optional<ScenePart> enterScenePartInfo(
		@RequestParam(required = true)
		Integer sceneNumber,
		@RequestParam(required = true)
		Integer partNumber,
		@RequestParam(required = true)
		String musicalName);
		// @formatter:on	
}


