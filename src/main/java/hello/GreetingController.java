package hello;

import hello.services.GreeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class GreetingController {

    @Autowired
    GreeterService greeter;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("message", greeter.greet(name));
        return "greeting";
    }
}