package project.system.VGS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.system.VGS.models.User;
import project.system.VGS.services.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String user(User user, Model model) {
        model.addAttribute("userList", userService.findAllUsers());
        return "userManagement";
    }

    @PostMapping("/user")
    public String addUser(@ModelAttribute User user, Model model) {
        userService.addUser(user);
        model.addAttribute("userList", userService.findAllUsers());
        return "userManagement";
    }

    @PostMapping("/user/delete")
    public String deleteUser(@RequestParam("cpfDelete") String cpfDelete, User user, Model model) {
        userService.deleteUser(cpfDelete);
        model.addAttribute("userList", userService.findAllUsers());
        return "userManagement";
    }
}
