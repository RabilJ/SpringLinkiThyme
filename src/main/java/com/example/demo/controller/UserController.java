package com.example.demo.controller;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private UserRepository ur;

    @Autowired
    public UserController(UserRepository ur) {
        this.ur = ur;
    }

    @GetMapping("/user")
    public String jan(Model model) {
        User userJan = new User("Jan", "Kowalski");
        model.addAttribute("user", userJan);
        return "user";
    }

    @GetMapping("/list")
    public String userList(Model model) {
        model.addAttribute("userList", ur.getUsers());
        return "userList";
    }

    @GetMapping("/dodaj")
    public String showForm(Model model) {
        model.addAttribute("user", new User("Jan", "Kowalski"));
        return "userForm";
    }

    @PostMapping("/saveUser")
    public String save(User user) {
        ur.add(user);
        return "redirect:list";
    }

    @PostMapping("/find")
    public String find(@RequestParam String lastName, Model model) {
        User userByLastName = ur.findByLastName(lastName);
        if (userByLastName != null) {
            model.addAttribute("user", userByLastName);
            return "user";
        } else {
            return "notFound";
        }
    }
}
