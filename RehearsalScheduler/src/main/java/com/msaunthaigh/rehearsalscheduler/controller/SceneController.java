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
import com.msaunthaigh.rehearsalscheduler.entity.Scene;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Scene")
@OpenAPIDefinition(info = @Info(title = "Rehearsal Scheduler"), servers = {
	@Server(url = "http://localhost:8080", description = "Local server")})

public interface SceneController {

	// @formatter:off
	//GET retrieves scene information
	@Operation(
		summary = "Returns a list of scenes",
		description = "Returns a list of scenes given a piece of data (musical name, character, cast member)",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "A list of scenes is returned.",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = Scene.class))),
			@ApiResponse(
				responseCode = "400",
				description = "Invalid request parameters",
				content = @Content(
					mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404",
				description = "No scenes were found using the supplied criteria.",
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
				name = "musicalName",
				allowEmptyValue = false,
				required = false,
				description = "Name of musical"),
			@Parameter(
				name = "sceneNumber",
				allowEmptyValue = false,
				required = false,
				description = "Scene Number"),
			@Parameter(
				name = "sceneName",
				allowEmptyValue = false,
				required = false,
				description = "Name of scene"),
			@Parameter(
				name = "songTitle",
				allowEmptyValue = false,
				required = false,
				description = "Song title"),
			@Parameter(
				name = "firstName",
				allowEmptyValue = false,
				required = false,
				description = "Cast member first name (must also specify last name)"),
			@Parameter(
				name = "lastName",
				allowEmptyValue = false,
				required = false,
				description = "Cast member last name (must also specify first name)"),
			@Parameter(
				name = "characterName",
				allowEmptyValue = false,
				required = false,
				description = "Name of character")})
	//GET retrieves scene information
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<Scene> fetchScenes(
		@RequestParam(required = false)
		String musicalName,
		@RequestParam(required = false)
		Integer sceneNumber,
		@RequestParam(required = false)
		String sceneName,
		@RequestParam(required = false)
		String songTitle,
		@RequestParam(required = false)
		String firstName,
		@RequestParam(required = false)
		String lastName,
		@RequestParam(required = false)
		String characterName);

	//POST adds a new scene
	@Operation(
			summary = "Adds a scene",
			description = "Creates a new scene",
			responses = {
				@ApiResponse(
					responseCode = "200",
						description = "New scene created",
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
					description = "Unable to create new scene with the information given",
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
					name = "musicalName",
					allowEmptyValue = false,
					required = true,
					description = "Name of Musical"),
				@Parameter(
					name = "sceneNumber",
					allowEmptyValue = false,
					required = true,
					description = "Scene Number"),
				@Parameter(
					name = "sceneName",
					allowEmptyValue = true,
					required = false,
					description = "Name of Scene"),
				@Parameter(
					name = "songTitle",
					allowEmptyValue = true,
					required = false,
					description = "Name of Song"),
				@Parameter(
					name = "songId",
					allowEmptyValue = true,
					required = false,
					description = "Song Number"),
				@Parameter(
					name = "act",
					allowEmptyValue = true,
					required = false,
					description = "Act (I or II)"),
				@Parameter(
					name = "location",
					allowEmptyValue = true,
					required = false,
					description = "Scene Location (e.g. 'at the restaurant'"),
				@Parameter(
					name = "pageBegin",
					allowEmptyValue = true,
					required = false,
					description = "Page Scene Begins"),
				@Parameter(
					name = "pageEnd",
					allowEmptyValue = true,
					required = false,
					description = "Page Scene Ends")
			}
		)
	//POST adds a new scene
		@PostMapping
		@ResponseStatus(code = HttpStatus.CREATED)
		Optional<Scene> addNewScene(
			@RequestParam(required = true)
			String musicalName,
			@RequestParam(required = true)
			Integer sceneNumber,
			@RequestParam(required = false)
			String sceneName,
			@RequestParam(required = false)
			String songTitle,
			@RequestParam(required = false)
			Integer songId,
			@RequestParam(required = false)
			String act,
			@RequestParam(required = false)
			String location,
			@RequestParam(required = false)
			Integer pageBegin,
			@RequestParam(required = false)
			Integer pageEnd);
		// @formatter:off

	//PUT updates scene information
	@Operation(
		summary = "Update scene",
		description = "Updates scene information",
		responses = {
			@ApiResponse(
				responseCode = "200",
					description = "Scene information was updated successfully.",
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
				description = "Unable to update scene with the information given",
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
				name = "musicalName",
				allowEmptyValue = false,
				required = true,
				description = "Name of Musical"),
			@Parameter(
				name = "sceneNumber",
				allowEmptyValue = false,
				required = true,
				description = "Scene Number"),
			@Parameter(
				name = "sceneName",
				allowEmptyValue = false,
				required = false,
				description = "Scene Name"),
			@Parameter(
				name = "songTitle",
				allowEmptyValue = false,
				required = false,
				description = "Name of Song"),
			@Parameter(
				name = "songId",
				allowEmptyValue = false,
				required = false,
				description = "Song Number"),
			@Parameter(
				name = "act",
				allowEmptyValue = false,
				required = false,
				description = "Act (I or II)"),
			@Parameter(
				name = "location",
				allowEmptyValue = false,
				required = false,
				description = "Scene Location"),
			@Parameter(
				name = "pageBegin",
				allowEmptyValue = false,
				required = false,
				description = "Starts on Page?"),
			@Parameter(
				name = "pageEnd",
				allowEmptyValue = false,
				required = false,
				description = "Ends on Page?")
		}
	)
		
	//PUT updates scene information
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	Optional<Scene> updateScene(
		@RequestParam(required = true)
		String musicalName,
		@RequestParam(required = true)
		Integer sceneNumber,
		@RequestParam(required = false)
		String sceneName,
		@RequestParam(required = false)
		String songTitle,
		@RequestParam(required = false)
		Integer songId,
		@RequestParam(required = false)
		String act,
		@RequestParam(required = false)
		String location,
		@RequestParam(required = false)
		Integer pageBegin,
		@RequestParam(required = false)
		Integer pageEnd);
	// @formatter:off
}