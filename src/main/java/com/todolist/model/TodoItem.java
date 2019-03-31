package com.todolist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

//Lombok will generate getter, setter, equals, hashcode, can equal
// By default lombnok generates hashCode and Equals for all fields to
// avoid that we can add another annotation EqualsAndHashCode with field add in paramerter
// We can also generate EqualsAndHashCode for multiple fields using paranthesis
// @EqualsAndHashCode(of = {"id", "details"})
@Data
@EqualsAndHashCode(of = "id")
public class TodoItem {

	//== fields
	private int id;
	private String title;
	private String details;
	private LocalDate deadline;

	// == constructor
	public TodoItem (String title, String details, LocalDate deadline) {
		this.title = title;
		this.details = details;
		this.deadline = deadline;
	}
}
