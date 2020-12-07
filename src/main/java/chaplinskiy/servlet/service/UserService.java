package chaplinskiy.servlet.service;

import chaplinskiy.servlet.model.Role;
import chaplinskiy.servlet.model.User;
import chaplinskiy.servlet.repository.UserRepository;
import chaplinskiy.servlet.repository.hibernate.UserRepositoryHibernate;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepositoryHibernate();
    }

    public List<User> getAllUser() {
        return userRepository.getAll();
    }

    public User getUserBuId(Long id) {
        return userRepository.getById(id);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void createUser(User user) {
        user.setRole(Role.USER);
        userRepository.create(user);
    }

    public void updateUser(User userUpdate) {
        userRepository.update(userUpdate);
    }
}
