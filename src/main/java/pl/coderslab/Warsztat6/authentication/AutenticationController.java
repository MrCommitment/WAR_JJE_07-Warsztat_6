package pl.coderslab.Warsztat6.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.Warsztat6.ViewMode;
import pl.coderslab.Warsztat6.entity.User;

import javax.persistence.GeneratedValue;
import javax.persistence.PostLoad;
import javax.servlet.http.HttpSession;
import javax.swing.text.View;

@Controller
@RequestMapping("/autentication")
public class AutenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("viewMode", new ViewMode());
        return "authentication/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute ViewMode viewMode, HttpSession httpSession) {
        if("register".equals(viewMode.getAction())) {
            return "redirect:/register/add";
        }
        if("login".equals(viewMode.getAction())) {
            if (authenticationService.givenEmailExistInDatabase(viewMode.getEmail())) {
                User user = authenticationService.authenticate(viewMode.getEmail(), viewMode.getPassword());
                if(user != null) {
                    httpSession.setAttribute("loggedUser", user.getId());
                    return "redirect:/";
                } else {
                    return "authentication/login";
                }
            } else {
                return "authentication/login";
            }
        }
        return "authentication/login";
    }

}
