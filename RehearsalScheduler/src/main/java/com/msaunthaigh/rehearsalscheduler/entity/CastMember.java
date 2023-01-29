package com.msaunthaigh.rehearsalscheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CastMember {
	
	private Integer castmemberId;
	private String firstName;
	private String lastName;
	private String newFirstName;
	private String newLastName;
	private String musicalName;
	private String characterName;
	private String phoneNumber;
	private Boolean tapPerformer;
	private Boolean costumeComplete;
}
