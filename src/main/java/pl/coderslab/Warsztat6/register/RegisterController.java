package pl.coderslab.Warsztat6.register;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.Warsztat6.entity.User;
import pl.coderslab.Warsztat6.repository.UserRepository;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "register/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userRepository.save(user);
        return "redirect:/authentication/login";
    }

}