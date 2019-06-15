package pl.coderslab.Warsztat6.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MainController {


    @GetMapping("/")
    public String home(HttpSession httpSession){
        if (httpSession.getAttribute("loggedUser")== null) {
            return "redirect:/authentication/login";

        }


        return "home";
    }
}
