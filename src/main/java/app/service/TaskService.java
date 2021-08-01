package app.service;

import app.model.Task;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TaskService {

    private List<Task> taskList;

    public Task addTaskToList(Task task){
        if (null == taskList) {
            taskList = new ArrayList<>();
        }
        int id = new Random().nextInt();
        task.setId(id);
        taskList.add(task);

        return task;
    }

    public List<Task> getAllTasks() {
        return taskList;
    }

    public Task getTaskyId(int id) {
        return taskList.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
