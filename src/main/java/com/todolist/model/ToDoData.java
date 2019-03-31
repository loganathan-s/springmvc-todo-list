package com.todolist.model;

// To simulate inMemory data. we will replace it with actual DB soon

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ToDoData {
	// == fields ==
	private static int idValue = 1;

	private final List<TodoItem> items = new ArrayList<>();

	// == constructors ==
	public ToDoData () {
		//== add dummy data using addItem
		addItemn(new TodoItem("first", "first details", LocalDate.now()));
		addItemn(new TodoItem("second", "second details", LocalDate.now()));
		addItemn(new TodoItem("thrid", "third details", LocalDate.now()));
	}

	// == public Methods

	public List<TodoItem> getItems() {
		return Collections.unmodifiableList(items);
	}

	//Lombok Annotation to check null @NonNull
	public void addItemn(@NonNull TodoItem toAdd) {

	// == Without Lombok
	 // =if(toAdd == null) {
	 //=				throw new NullPointerException("to Add is required parameter")
	 //= }
		toAdd.setId(idValue);
		items.add(toAdd);
		idValue++;
	}

	public void removeItem(int id) {
		ListIterator<TodoItem> itemListIterator = items.listIterator();
		while(itemListIterator.hasNext()) {
			TodoItem item = itemListIterator.next();
			if(item.getId() == id) {
				itemListIterator.remove();
				break;
			}
		}
	}

	public TodoItem getItem(int id) {
		for(TodoItem item: items) {
			if(item.getId() == id) {
				return item;
			}
		}
		return null;
	}

	public void updateItem(@NonNull TodoItem toUpdate) {
		ListIterator<TodoItem> itemListIterator = items.listIterator();
		while(itemListIterator.hasNext()) {
			TodoItem item = itemListIterator.next();
			if(item.equals(toUpdate)) {
				itemListIterator.set(toUpdate);
				break;
			}
		}
	}

}
