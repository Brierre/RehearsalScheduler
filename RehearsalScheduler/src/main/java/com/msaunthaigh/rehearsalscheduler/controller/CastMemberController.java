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

//GET retrieves cast information
//fetchCastMember()
	// @formatter:off
	@Operation(
		summary = "Returns a list of cast members",
		description = "Returns a list of cast members given a cast member ID or first name/last name",
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
				name = "castmemberId",
				allowEmptyValue = false,
				required = false,
				description = "Cast member ID"),
			@Parameter(
				name = "firstName",
				allowEmptyValue = false,
				required = false,
				description = "Cast member's first name (must also specify last name)"),
			@Parameter(
				name = "lastName",
				allowEmptyValue = false,
				required = false,
				description = "Cast member's last name (must also specify first name)")
		}
	)
	
	@GetMapping(value = "/castmember-by-castmember-info")
	@ResponseStatus(code = HttpStatus.OK)
	List<CastMember> fetchCastMember(
		@RequestParam(required = false)
		Integer castmemberId,
		@RequestParam(required = false)
		String firstName,
		@RequestParam(required = false)
		String lastName);
	// @formatter:on
	
//GET retrieves cast information
//fetchCastMemberByMusical()
	// @formatter:off
	@Operation(
		summary = "Returns a list of cast members",
		description = "Returns a list of cast members given a musical name",
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
				name = "musicalName",
				allowEmptyValue = false,
				required = true,
				description = "Musical Name")
		}
	)
	
	@GetMapping(value = "/castmember-by-musical")
	@ResponseStatus(code = HttpStatus.OK)
	List<CastMember> fetchCastMemberByMusical(
		@RequestParam(required = true)
		String musicalName);
	// @formatter:on
	
//GET retrieves cast information
//fetchCastMemberByPart()
	// @formatter:off
	@Operation(
		summary = "Returns a list of cast members",
		description = "Returns a list of cast members given a character name",
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
				name = "characterName",
				allowEmptyValue = false,
				required = false,
				description = "Name of Character")
		}
	)
	
	@GetMapping(value = "/castmember-by-part")
	@ResponseStatus(code = HttpStatus.OK)
	List<CastMember> fetchCastMemberByPart(
		@RequestParam(required = false)
		String characterName);
	// @formatter:on
	
//POST creates a new cast member in database
//newCastMember()
	// @formatter:off
	@Operation(
		summary = "Adds a cast member",
		description = "Creates a new cast member with required fields: first name, last name",
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
				allowEmptyValue = false,
				required = true,
				description = "Phone Number"),
			@Parameter(
				name = "tapPerformer",
				allowEmptyValue = false,
				required = true,
				description = "Member of tap troupe?"),
			@Parameter(
				name = "costumeComplete",
				allowEmptyValue = false,
				required = true,
				description = "Costume complete?")
		}
	)
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Optional<CastMember> newCastMember(
		@RequestParam(required = true)
		String firstName,
		@RequestParam(required = true)
		String lastName,
		@RequestParam(required = true)
		String phoneNumber,
		@RequestParam(required = true)
		Boolean tapPerformer,
		@RequestParam(required = true)
		Boolean costumeComplete);
	// @formatter:on
	
//PUT updates a cast member's information
//updateCastMember()
	// @formatter:off
	@Operation(
		summary = "Updates a cast member",
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
				required = true,
				description = "Phone Number"),
			@Parameter(
				name = "tapPerformer",
				allowEmptyValue = false,
				required = true,
				description = "Member of tap troupe?"),
			@Parameter(
				name = "costumeComplete",
				allowEmptyValue = false,
				required = true,
				description = "Costume complete?")
		}
	)

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
		@RequestParam(required = true)
		String phoneNumber,
		@RequestParam(required = true)
		Boolean tapPerformer,
		@RequestParam(required = true)
		Boolean costumeComplete);
	// @formatter:on
	
//DELETE-deletes a cast member from the database
//deleteCastMember()
	// @formatter:off	
	@Operation(
		summary = "Deletes a cast member",
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
				description = "Cast member's last name"),
			@Parameter(
				name = "phoneNumber",
				allowEmptyValue = true,
				required = true,
				description = "Phone Number (differentiator in the case of two cast members with the same name, xxx-xxx-xxxx) ")
		}
	)
		
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK)
	Optional<CastMember> deleteCastMember(
		@RequestParam(required = true)
		String firstName,
		@RequestParam(required = true)
		String lastName,
		@RequestParam(required = true)
		String phoneNumber);
	// @formatter:on

}
