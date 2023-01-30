package com.msaunthaigh.rehearsalscheduler.entity;

//not needed at this time, except to preserve some database foreign key references and future ideas

import java.sql.Time;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conflict {
	private int conflictIdPK;
	private CastMember castMember;
	private String dayOfWeek;
	private Date conflictDate;
	private Time conflictTime;
	private String conflictName;
	private Boolean conflictApproved;
}
