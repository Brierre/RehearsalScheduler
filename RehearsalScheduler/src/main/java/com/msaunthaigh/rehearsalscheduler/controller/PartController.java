package com.msaunthaigh.rehearsalscheduler.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
		@Server(url = "http://localhost:8080", description = "Local server")
})

public interface PartController {

	//@formatter:off
	
	@Operation(
		summary = "Returns a list of parts",
		description = "Returns a list of parts when given cast, scene, or musical information",
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
				name = "partId",
				allowEmptyValue = false,
				required = false,
				description = "Part ID"),
			@Parameter(
				name = "castId",
				allowEmptyValue = false,
				required = false,
				description = "Cast Member ID"),
			@Parameter(
				name = "characterName",
				allowEmptyValue = false,
				required = false,
				description = "Character"),
			@Parameter(
				name = "characterGroup",
				allowEmptyValue = false,
				required = false,
				description = "Character Group"),
			@Parameter(
				name = "musicalName",
				allowEmptyValue = false,
				required = false,
				description = "Musical"),
			@Parameter(
				name = "firstName",
				allowEmptyValue = false,
				required = false,
				description = "First Name"),
			@Parameter(
				name = "lastName",
				allowEmptyValue = false,
				required = false,
				description = "Last Name"),
			@Parameter(
				name = "sceneId",
				allowEmptyValue = false,
				required = false,
				description = "Scene ID")
		}
	)
	//GET
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<Part> fetchParts(
		@RequestParam(required = false)
		Integer partId,
		@RequestParam(required = false)
		Integer castId,
		@RequestParam(required = false)
		String characterName,
		@RequestParam(required = false)
		String characterGroup,
		@RequestParam(required = false)
		String musicalName,
		@RequestParam(required = false)
		String firstName,
		@RequestParam(required = false)
		String lastName,
		@RequestParam(required = false)
		Integer sceneId);
	
}