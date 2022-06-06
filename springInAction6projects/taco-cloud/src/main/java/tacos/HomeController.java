package tacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

//@Controller
@Slf4j
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Locale locale) {
        return "home";
    }

}
