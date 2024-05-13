package myfirstwebapp.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("harshit");
		model.addAttribute("todos", todos);
		
		return "listTodos";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		String username = (String)model.get("name");
		Todo deafultTodo = new Todo(0, username, "default", LocalDate.now().plusYears(1), false);
		System.out.println(deafultTodo);
		model.put("deafultTodo", deafultTodo);
		
		return "add-todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo newTodo) {
		System.out.println(newTodo);
		todoService.addTodo(newTodo.getUsername(), newTodo.getDescription(), newTodo.getTargetDate(), false);
		
		return "redirect:list-todos";
	}
}
