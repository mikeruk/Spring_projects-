package cv.opencv5.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
//@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home(){

        return "home";
    }
}
