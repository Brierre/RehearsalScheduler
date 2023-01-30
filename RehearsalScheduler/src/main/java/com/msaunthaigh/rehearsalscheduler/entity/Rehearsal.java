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
public class Rehearsal {
	private int rehearsalIdPK;
	private Scene sceneId;
	private String dayOfWeek;
	private Date rehearsalDate;
	private Time rehearsalTime;
}
