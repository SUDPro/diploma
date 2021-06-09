package ru.itis.taskdistribution.controllers;

import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.taskdistribution.models.TaskNew;
import ru.itis.taskdistribution.models.Worker;
import ru.itis.taskdistribution.repositories.TaskRepository;
import ru.itis.taskdistribution.repositories.UserRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class AdminController {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping("/admin/tasks")
    public String getAdminPanelTasks(ModelMap modelMap) {
        List<TaskNew> tasks = taskRepository.findAll();
        tasks.sort((task1, task2) ->  task2.dateTime.compareTo(task1.dateTime));
        modelMap.addAttribute("tasks", tasks);
        return "adminPanel";
    }

    @GetMapping("/admin/users")
    public String getAdminPanelUsers(ModelMap modelMap) {

        return "adminUsers";
    }

    @GetMapping("/admin/first/users")
    public String firstUsers(ModelMap modelMap){
        Set<String> napravlenies = userRepository.findAll().stream().map(Worker::getDolznost).collect(Collectors.toSet());
        Set<String> otdels = userRepository.findAll().stream().map(Worker::getTeam).collect(Collectors.toSet());
        modelMap.addAttribute("workers", userRepository.findAll());
        modelMap.addAttribute("napravlenies", napravlenies);
        modelMap.addAttribute("otdels", otdels);
        return "usersFirst";
    }
    @GetMapping("/admin/settings")
    public String getAdminPanelSettings() {
        return "adminSettings";
    }

    @GetMapping("/admin/logout")
    public String logout() {
        return "redirect:/admin";
    }

    @GetMapping("/admin/first")
    public String firstStart() {
        return "firstStart";
    }
}
