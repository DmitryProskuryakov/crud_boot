package ru.dmitry.crud_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.crud_boot.model.User;
import ru.dmitry.crud_boot.service.UserService;
import ru.dmitry.crud_boot.service.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/get-all")
    public String getAllUsers(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("user", userServiceImpl.findOne(id));
            return "views/showone";
        } else {
            model.addAttribute("users", userServiceImpl.findAll());
            return "views/showusers";
        }
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "id", required = false) Integer id) {
        userServiceImpl.delete(id);
        return "redirect:/users/get-all";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "views/new";
    }

    @PostMapping()
    public String addNewUser(@ModelAttribute("user") User user) {
        userServiceImpl.save(user);
        return "redirect:/users/get-all";
    }

    @GetMapping("/change")
    public String changeUser(@ModelAttribute("user") User user) {
        return "views/change";
    }

    @PatchMapping()
    public String editUser(@ModelAttribute("user") User user, @RequestParam(value = "id", required = false) Integer id) {
        userServiceImpl.update(id, user);
        return "redirect:/users/get-all";
    }
}
