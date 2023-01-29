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

import com.msaunthaigh.rehearsalscheduler.entity.Part;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/part")

@OpenAPIDefinition(info = @Info(title = "RehearsalScheduler"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server")})

public interface PartController {

//GET retrieves part information
//fetchPartByMusical()
	//@formatter:off
	@Operation(
		summary = "Returns a list of parts by musical",
		description = "Returns a list of parts from a selected musical",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "A list of parts is returned.",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = Part.class))),
			@ApiResponse(
				responseCode = "400",
				description = "Invalid request parameters",
				content = @Content(
					mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404",
				description = "No parts were found using the supplied information.",
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
				description = "Musical Name")
		}
	)

	@GetMapping(value = "/parts-by-musical")
	@ResponseStatus(code = HttpStatus.OK)
	List<Part> fetchPartsByMusical(
		@RequestParam(required = true)
		String musicalName);
	// @formatter:on
	
//GET retrieves part information
//fetchPartByScene()
	//@formatter:off
	@Operation(
			summary = "Returns a list of parts by scene",
			description = "Returns a list of parts who appear in a scene, given a scene number",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "A list of parts is returned.",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = Part.class))),
				@ApiResponse(
					responseCode = "400",
					description = "Invalid request parameters",
					content = @Content(
						mediaType = "application/json")),
				@ApiResponse(
					responseCode = "404",
					description = "No parts were found using the supplied information.",
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
					description = "Musical-Must also specify a Scene Number"),
				@Parameter(
					name = "sceneNumber",
					allowEmptyValue = false,
					required = true,
					description = "Scene Number-Use with a Musical Name")
			}
		)

		@GetMapping(value = "/parts-by-scene")
		@ResponseStatus(code = HttpStatus.OK)
		List<Part> fetchPartsByScene(
			@RequestParam(required = true)
			String musicalName,
			@RequestParam(required = true)
			Integer sceneNumber);
	// @formatter:on
	
//GET retrieves part information
//fetchPartByCastmemberInfo()
	//@formatter:off
	@Operation(
			summary = "Returns a list of parts",
			description = "Returns a list of parts when given castmember's information",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "A list of parts is returned.",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = Part.class))),
				@ApiResponse(
					responseCode = "400",
					description = "Invalid request parameters",
					content = @Content(
						mediaType = "application/json")),
				@ApiResponse(
					responseCode = "404",
					description = "No parts were found using the supplied information.",
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
					description = "Cast Member ID"),
				@Parameter(
					name = "firstName",
					allowEmptyValue = false,
					required = false,
					description = "First Name-Must also specify a Last Name"),
				@Parameter(
					name = "lastName",
					allowEmptyValue = false,
					required = false,
					description = "Last Name-Must also specify a First Name")
			}
		)

		@GetMapping(value = "/parts-by-castmember-info")
		@ResponseStatus(code = HttpStatus.OK)
		List<Part> fetchPartsByCastmemberInfo(
			@RequestParam(required = false)
			Integer castmemberId,
			@RequestParam(required = false)
			String firstName,
			@RequestParam(required = false)
			String lastName);
	// @formatter:on
	
	//PUT updates a part with cast member information
	//linkCastmemberToPart()
	// @formatter:off
	@Operation(
		summary = "Update part",
		description = "Updates a part record with castmember information",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "Part record updated successfully with castmember information",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = Part.class))),
			@ApiResponse(
					responseCode = "400",
					description = "Invalid request parameters",
					content = @Content(
							mediaType = "application/json")),
			@ApiResponse(
					responseCode = "404",
					description = "Unable to update part with the information given",
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
						description = "Musical Name"),
				@Parameter(
						name = "characterName",
						allowEmptyValue = false,
						required = true,
						description = "Character Name"),
				@Parameter(
						name = "firstName",
						allowEmptyValue = false,
						required = true,
						description = "Cast Member's First Name"),
				@Parameter(
						name = "lastName",
						allowEmptyValue = false,
						required = true,
						description = "Cast Member's Last Name")
		}
	)
		@PutMapping
		@ResponseStatus(code = HttpStatus.OK)
		Optional<Part> linkCastmemberToPart(
				@RequestParam(required = true)
				String musicalName,
				@RequestParam(required = true)
				String characterName,
				@RequestParam(required = true)
				String firstName,
				@RequestParam(required = true)
				String lastName);
				// @formatter:on
		}
