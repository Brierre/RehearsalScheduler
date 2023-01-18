package com.msaunthaigh.rehearsalscheduler.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.msaunthaigh.rehearsalscheduler.entity.CastMember;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
//@RequestMapping("/")
@RequestMapping("/CastMember")
@OpenAPIDefinition(info = @Info(title = "RehearsalScheduler"), servers = {
	@Server(url = "http://localhost:8080", description = "Local server")})

public interface CastMemberController {
	//This section assumes we are working with only one set of musical data (e.g. 'Nunsense' scenes, parts, and cast members)
	//Future implementation: fetchInfoByMusical(), a method that takes a musical name and returns fetchCastByMusical, fetchSceneByMusical, 
	//	and fetchPartByMusical

	//GET retrieves cast information
	// @formatter:off
	@Operation(
		summary = "Returns a list of cast members",
		description = "Returns a list of cast members given a cast member ID, first name/last name, or character name",
		responses = {
			@ApiResponse(
				responseCode = "200",
					description = "A list of cast members is returned.",
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
				description = "No cast members were found using the supplied criteria.",
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
				name = "castMemberPK",
				allowEmptyValue = true,
				required = false,
				description = "Cast member ID"),
			@Parameter(
				name = "firstName",
				allowEmptyValue = true,
				required = false,
				description = "Cast member's first name"),
			@Parameter(
				name = "lastName",
				allowEmptyValue = true,
				required = false,
				description = "Cast member's last name")
		}
	)
	
	//GET retrieves cast information
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<CastMember> fetchCastMember(
		@RequestParam(required = false)
		Integer castMemberPK,
		@RequestParam(required = false)
		String firstName,
		@RequestParam(required = false)
		String lastName);
	// @formatter:on
	
//POST creates a new cast member in database
	@Operation(
		summary = "Adds a cast member",
		description = "Creates a new cast member with required fields: first name, last name, character name",
		responses = {
			@ApiResponse(
				responseCode = "200",
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
				name = "firstName",
				allowEmptyValue = false,
				required = true,
				description = "Cast member's first name"),
			@Parameter(
				name = "lastName",
				allowEmptyValue = false,
				required = true,
				description = "Cast member's last name"),
			@Parameter(
				name = "phoneNumber",
				allowEmptyValue = true,
				required = false,
				description = "Phone Number"),
			@Parameter(
				name = "tapPerformer",
				allowEmptyValue = true,
				required = false,
				description = "Member of tap troupe?"),
			@Parameter(
				name = "costume complete",
				allowEmptyValue = true,
				required = false,
				description = "Costume complete?")
		}
	)
	
	//POST creates a new cast member in database
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Optional<CastMember> newCastMember(
		@RequestParam(required = true)
		String firstName,
		@RequestParam(required = true)
		String lastName,
		@RequestParam(required = false)
		String phoneNumber,
		@RequestParam(required = false)
		Boolean tapPerformer,
		@RequestParam(required = false)
		Boolean costumeComplete);
	// @formatter:off
	
	//PUT updates a cast member's information
	@Operation(
		summary = "Update cast member",
		description = "Updates a cast member's information",
		responses = {
			@ApiResponse(
				responseCode = "200",
					description = "Cast member information was updated successfully.",
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
				description = "Unable to update cast member with the information given",
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
				name = "firstName",
				allowEmptyValue = false,
				required = true,
				description = "Cast member's first name"),
			@Parameter(
				name = "lastName",
				allowEmptyValue = false,
				required = true,
				description = "Cast member's last name"),
			@Parameter(
				name = "newFirstName",
				allowEmptyValue = false,
				required = true,
				description = "Cast member's updated first name"),
			@Parameter(
				name = "newLastName",
				allowEmptyValue = false,
				required = true,
				description = "Cast member's updated last name"),
			@Parameter(
				name = "phoneNumber",
				allowEmptyValue = false,
				required = false,
				description = "Phone Number"),
			@Parameter(
				name = "tapPerformer",
				allowEmptyValue = false,
				required = false,
				description = "Member of tap troupe?"),
			@Parameter(
				name = "costumeComplete",
				allowEmptyValue = false,
				required = false,
				description = "Costume complete?")
		}
	)
		
	//PUT updates a cast member's information
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	Optional<CastMember> updateCastMember(
		@RequestParam(required = true)
		String firstName,
		@RequestParam(required = true)
		String lastName,
		@RequestParam(required = true)
		String newFirstName,
		@RequestParam(required = true)
		String newLastName,
		@RequestParam(required = false)
		String phoneNumber,
		@RequestParam(required = false)
		Boolean tapPerformer,
		@RequestParam(required = false)
		Boolean costumeComplete);
	// @formatter:off
		
	//DELETE-deletes a cast member from the database
	@Operation(
		summary = "Delete cast member",
		description = "Deletes a cast member from the cast list",
		responses = {
			@ApiResponse(
				responseCode = "200",
					description = "Cast member information was deleted successfully.",
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
				description = "Unable to delete cast member with the information given",
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
				name = "firstName",
				allowEmptyValue = false,
				required = true,
				description = "Cast member's first name"),
			@Parameter(
				name = "lastName",
				allowEmptyValue = false,
				required = true,
				description = "Cast member's last name")
		}
	)
		
	//DELETE-deletes a cast member from the database
	//Future implementation: add a check to be sure you're deleting the correct cast member (e.g. two cast members have the same name)
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK)
	Optional<CastMember> deleteCastMember(
		@RequestParam(required = true)
		String firstName,
		@RequestParam(required = true)
		String lastName);
	// @formatter:off
}