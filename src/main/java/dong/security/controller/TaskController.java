package dong.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dong.security.entity.Task;
import dong.security.repository.TaskRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/tasks")
@Api(value = "Security Test API")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;
	
	@PostMapping(value = "/add")
	@ApiOperation(value = "Add Task")
	public void addTask(
			@RequestHeader(name = "domain", required = true) String domain, 
			@RequestHeader(name = "organization", required = true) String organization, 
			@RequestHeader(name = "role", required = true) String role, 
			@RequestBody Task task) {

		System.out.println("\n\n\n domain is " + domain);
		
		taskRepository.save(task);
	}

	@GetMapping(value = "/findAll")
	@ApiOperation(value = "Find all Task")
	public List<Task> getTasks() {
		
		return taskRepository.findAll();
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "edit Task")
	public void editTask(@PathVariable long id, @RequestBody Task task) {
		Optional<Task> existingTask = taskRepository.findById(id);
		if (existingTask.isPresent()) {
			Task updateTask = existingTask.get();
			updateTask.setDescription(task.getDescription());
			taskRepository.save(updateTask);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete Task")
	public void deleteTask(@PathVariable long id) {
		taskRepository.deleteById(id);
	}
	
}
