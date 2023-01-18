package com.msaunthaigh.rehearsalscheduler.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

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
	
	// @formatter:off
	@Operation(
			summary = "Return parts linked with a scene.",
			description = "Links all parts associated with a selected scene and returns a list",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "Returns a list of parts for the specified scene",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = ScenePart.class))),
					@ApiResponse(
							responseCode = "400",
							description = "Invalid Request Parameters",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = ScenePart.class))),
					@ApiResponse(
							responseCode = "404",
							description = "Parts were not found for the specified scene.",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = ScenePart.class))),
					@ApiResponse(
							responseCode = "500",
							description = "An unplanned error has occurred.",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = ScenePart.class)))
			},
			parameters = {
					@Parameter(
							name = "sceneIdFK",
							required = false,
							description = "Requested scene number"),
					@Parameter(
							name = "partIdFK",
							required = false,
							description = "Associated part"),
					@Parameter(
							name = "firstName",
							required = false,
							description = "Cast member first name (must also select a musical)"),
					@Parameter(
							name = "lastName",
							required = false,
							description = "Cast member last name (must also select a musical)"),
					@Parameter(
							name = "characterName",
							required = false,
							description = "Name of character (must also select a musical)"),
					@Parameter(
							name = "musicalName",
							required = false,
							description = "Name of musical (must also select a cast member's first, last, or character name)")
			}
		)	
	//@ formatter:on
								
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<ScenePart> fetchPartsByScene(
		@RequestParam(required = false)
		Integer sceneIdFK,
		@RequestParam(required = false)
		Integer partIdFK,
		@RequestParam(required = false)
		String firstName,
		@RequestParam(required = false)
		String lastName,
		@RequestParam(required = false)
		String characterName,
		@RequestParam(required = false)
		String musicalName);	
	

	//UPDATE operation
	@Operation(
		summary = "Update scene_part table",
		description = "Updates cast_id in join table",
		responses = {
			@ApiResponse(
				responseCode = "200",
					description = "Cast ID information was updated successfully.",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = ScenePart.class))),
			@ApiResponse(
				responseCode = "400",
				description = "Invalid request parameters",
				content = @Content(
					mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404",
				description = "Unable to update table with the information given",
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
				name = "sceneIdFK",
				allowEmptyValue = false,
				required = false,
				description = "Scene ID"),
			@Parameter(
				name = "partIdFK",
				allowEmptyValue = false,
				required = false,
				description = "Part ID"),
			@Parameter(
				name = "castIdFK",
				allowEmptyValue = false,
				required = false,
				description = "Cast member ID")
		}
	)
		
	//PUT--update
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	Optional<ScenePart> populateFKFromCastmember(
		@RequestParam(required = false)
		Integer sceneIdFK,
		@RequestParam(required = false)
		Integer partIdFK,
		@RequestParam(required = false)
		Integer castId);
	// @formatter:off

}