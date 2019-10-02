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

    /**
     * Get a list of all created users
     *
     * @return a list of all user objects
     */
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

    /**
     * Creates a new user
     *
     * @param user the data of the user you want to create
     * @return the newly created user
     */
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createSubject(@Valid @RequestBody User user) {
        return UserDTO.toDTO(userService.createUser(user));
    }

    /**
     * Deletes a user
     *
     * @param id the id of the user you want to delete
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEntry(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    /**
     * Updates the data of a user
     *
     * @param user the updated data of a user object you want to have
     * @param id the id of the user you want to update
     * @return the updated user
     */
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateEntry(@Valid @RequestBody User user, @PathVariable Long id) {
        return userService.updateUser(user, id);
    }
}
