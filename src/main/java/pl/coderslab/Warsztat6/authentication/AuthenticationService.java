package pl.coderslab.Warsztat6.authentication;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.Warsztat6.entity.User;
import pl.coderslab.Warsztat6.repository.UserRepository;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;


    public boolean givenEmailExistInDatabase(String email) {
        User user = userRepository.findByEmail(email);
        if(user != null) {
            return true;
        }
        return false;
    }

    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        boolean equalPassword = BCrypt.checkpw(password, user.getPassword());
        if (equalPassword) {
            return user;
        }
        return null;
    }

}
