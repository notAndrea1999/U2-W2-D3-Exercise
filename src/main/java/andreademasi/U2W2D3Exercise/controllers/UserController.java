package andreademasi.U2W2D3Exercise.controllers;


import andreademasi.U2W2D3Exercise.entities.User;
import andreademasi.U2W2D3Exercise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class UserController {
    @Autowired
    private UserService userService;

    //GET authors
    @GetMapping
    List<User> getAllAuthors() {
        return userService.getAllAuthors();
    }

    //POST crea un nuovo autore
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    User save(@RequestBody User user) {
        return userService.save(user);
    }

    //GET author by id
    @GetMapping("/{id}")
    User findAuthorById(@PathVariable long id) {
        return userService.findAuthorById(id);
    }

    //PUT modifica dello specifico autore
    @PutMapping("/{id}")
    User findByIdAndUpdate(@PathVariable long id, @RequestBody User user) {
        return userService.findByIdAndUpdate(id, user);
    }

    //DELETE dell'author
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void findByIdAndDelete(@PathVariable long id) {
        userService.findByIdAndDelete(id);
    }
}
