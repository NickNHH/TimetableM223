package ch.zli.nictus.timeTable.controller;

import ch.zli.nictus.timeTable.dto.UserDTO;
import ch.zli.nictus.timeTable.model.User;
import ch.zli.nictus.timeTable.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllEntries() {
        List<User> subjects = userService.findAll();
        List<UserDTO> dtoList = new ArrayList<>();
        for(User user : subjects){
            dtoList.add(UserDTO.toDTO(user));
        }
        return dtoList;
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createSubject(@Valid @RequestBody User user) {
        return UserDTO.toDTO(userService.createUser(user));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEntry(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateEntry(@Valid @RequestBody User user, @PathVariable Long id) {
        return userService.updateUser(user, id);
    }
}
