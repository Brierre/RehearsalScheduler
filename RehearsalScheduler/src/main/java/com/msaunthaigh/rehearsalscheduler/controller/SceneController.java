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
		@Server(url = "http://localhost:8080", description = "Local server") })

public interface SceneController {

//GET retrieves scene information
//fetchScenesByMusical()
	// @formatter:off
	@Operation(
		summary = "Returns a list of scenes",
		description = "Returns a list of scenes when given a musical name",
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
				description = "Name of Musical")
			}
		)
	
	@GetMapping(value = "/scenes-by-musical")
	@ResponseStatus(code = HttpStatus.OK)
	List<Scene> fetchScenesByMusical(
		@RequestParam(required = false)
		String musicalName);
	// @formatter:on

//GET retrieves scene information
//fetchScenesByCastmemberInfo()
	// @formatter:off
	@Operation(
		summary = "Returns a list of scenes",
		description = "Returns a list of scenes when given a castmember ID or a castmember first/last name)",
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
				name = "castmemberId",
				allowEmptyValue = false,
				required = false,
				description = "Cast member ID"),
			@Parameter(
				name = "firstName",
				allowEmptyValue = false,
				required = false,
				description = "Cast member first name (must also specify last name)"),
			@Parameter(
				name = "lastName",
				allowEmptyValue = false,
				required = false,
				description = "Cast member last name (must also specify first name)")
			}
		)

	@GetMapping(value = "/scenes-by-castmember-info")
	@ResponseStatus(code = HttpStatus.OK)
	List<Scene> fetchScenesByCastmemberInfo(
		@RequestParam(required = false)
		Integer castmemberId,
		@RequestParam(required = false)
		String firstName,
		@RequestParam(required = false)
		String lastName);
	// @formatter:on

//GET retrieves scene information
//fetchScenesByPart()
	// @formatter:off
	@Operation(
		summary = "Returns a list of scenes",
		description = "Returns a list of scenes when given a character name",
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
				name = "characterName",
				allowEmptyValue = false,
				required = true,
				description = "Name of character"),
			@Parameter(
				name = "musicalName",
				allowEmptyValue = false,
				required = true,
				description = "Name of Musical")
		}
	)
	
	@GetMapping(value = "/scenes-by-part")
	@ResponseStatus(code = HttpStatus.OK)
	List<Scene> fetchScenesByPart(
		@RequestParam(required = true)
		String characterName,
		@RequestParam(required = true)
		String musicalName);
	// @formatter:on

//POST adds a new scene
//addNewScene()
	// @formatter:off
	@Operation(
		summary = "Adds a scene",
		description = "Creates a new scene",
		responses = {
			@ApiResponse(
				responseCode = "201",
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
				allowEmptyValue = false,
				required = false,
				description = "Name of Scene"),
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
				required = true,
				description = "Act (I or II)"),
			@Parameter(
				name = "location",
				allowEmptyValue = false,
				required = false,
				description = "Scene Location (e.g. 'at the restaurant'"),
			@Parameter(
				name = "pageBegin",
				allowEmptyValue = false,
				required = false,
				description = "Page Scene Begins"),
			@Parameter(
				name = "pageEnd",
				allowEmptyValue = false,
				required = false,
				description = "Page Scene Ends")
		}
	)
	
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
		@RequestParam(required = true)
		String act,
		@RequestParam(required = false)
		String location,
		@RequestParam(required = false)
		Integer pageBegin,
		@RequestParam(required = false)
		Integer pageEnd);
	// @formatter:on

//PUT updates scene information
//updateScene()
	// @formatter:off
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
				required = true,
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
		@RequestParam(required = true)
		String act,
		@RequestParam(required = false)
		String location,
		@RequestParam(required = false)
		Integer pageBegin,
		@RequestParam(required = false)
		Integer pageEnd);
	// @formatter:on
}