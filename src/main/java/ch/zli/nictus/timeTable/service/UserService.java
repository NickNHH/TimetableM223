package ch.zli.nictus.timeTable.service;

import ch.zli.nictus.timeTable.model.Subject;
import ch.zli.nictus.timeTable.model.User;
import ch.zli.nictus.timeTable.repository.SubjectRepository;
import ch.zli.nictus.timeTable.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public void deleteUserById(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    public User updateUser(User user, long id) {
        User originalUser = findUserById(id).get();
        originalUser.updateUser(user);
        return userRepository.saveAndFlush(originalUser);
    }
}
