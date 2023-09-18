package project.system.VGS.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.system.VGS.models.User;
import project.system.VGS.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(String cpf) {
        userRepository.deleteById(cpf);
    }

    public void changeUserType(String cpf) {
        User user = findUserByCpf(cpf);
        user.setAgente(!user.isAgente());
        userRepository.save(user);
    }

    public User findUserByCpf(String cpf) {
        Optional<User> user = userRepository.findById(cpf);
        return user.orElse(null);
    }
}
