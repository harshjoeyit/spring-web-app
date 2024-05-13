package myfirstwebapp.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	
	static {
		todos.add(
				new Todo(
						1, 
						"harshit", 
						"Learn AWS", 
						LocalDate.now().plusYears(1), 
						false)
				);
		todos.add(
				new Todo(
						2, 
						"harshit", 
						"Walk the dog", 
						LocalDate.now().plusDays(2), 
						false)
				);
		todos.add(
				new Todo(
						3, 
						"harshit", 
						"Go shopping", 
						LocalDate.now().plusMonths(2), 
						false)
				);
	}
	
	public List<Todo> findByUsername(String username) {
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		int id = todos.size();
		todos.add(
				new Todo(
						id,
						username,
						description,
						targetDate,
						done
					)
				);
	}
}
