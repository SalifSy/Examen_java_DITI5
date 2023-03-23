package com.groupeisi.controller;

import com.groupeisi.entity.User;
import com.groupeisi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    // handler method to handle list users and return mode and view
    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    @GetMapping("/users/new")
    public String createUserForm(Model model) {

        // create users object to hold student form data
        User user = new User();
        model.addAttribute("user", user);
        return "create_user";

    }
    @PostMapping("/users")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit_user";
    }
    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable Long id,
                                   @ModelAttribute("user") User user,
                                   Model model) {
        // get student from database by id

        User existingUser = userService.getUserById(id);
        existingUser.setId(id);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setAge(user.getAge());
        existingUser.setAdresse(user.getAdresse());
        existingUser.setEmail(user.getEmail());
        existingUser.setTelephone(user.getTelephone());
        existingUser.setSpecialiste(user.getSpecialiste());
        existingUser.setNiveauEtude(user.getNiveauEtude());
        existingUser.setExperienceProfessionnelle(user.getExperienceProfessionnelle());


        userService.updateUser(existingUser);
        return "redirect:/users";

    }
}
