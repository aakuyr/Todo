package app.todo;

import app.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import app.service.TaskService;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    public Task createTask(@RequestBody @NonNull Task task) {
        return taskService.addTaskToList(task);
    }

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.GET)
    public Task getTaskById(@PathVariable("id") int id) {
        return taskService.getTaskyId(id);
    }

    @RequestMapping(value = "/todos/{id}/done", method = RequestMethod.PUT)
    public Task markTaskDone(@PathVariable("id") int id) {
        Task task = taskService.getTaskyId(id);
        task.setDone(true);
        return task;
    }

    @RequestMapping(value = "/todos/{id}/done", method = RequestMethod.DELETE)
    public Task markTaskUndone(@PathVariable("id") int id) {
        Task task = taskService.getTaskyId(id);
        task.setDone(false);
        return task;
    }
}
