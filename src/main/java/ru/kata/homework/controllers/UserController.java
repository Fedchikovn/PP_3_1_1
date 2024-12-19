package ru.kata.homework.controllers;

import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.homework.models.User;
import ru.kata.homework.services.UserService;


@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAllUsers(Model model) {
        model.addAttribute("all_users", userService.showAllUsers());
        return "show_all";
    }

    @GetMapping("/user")
    public String getUserById(@RequestParam("id") int id, Model model) {

        model.addAttribute("user", userService.getUserById(id));
        return "show_by_id";
    }

    @GetMapping("/new")
    public String createNewUser(@ModelAttribute("user") User user){
        return "new_user";
    }

    @PostMapping
    public String saveNewUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/user/edit")
    public String editUser (@RequestParam("id") int id, Model model) {
        model.addAttribute("userToUpdate", userService.getUserById(id));
        return "edit_user";
    }

    @PostMapping("/user")
    public String updateUser(@ModelAttribute("userToUpdate") User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @PostMapping("/user/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}
