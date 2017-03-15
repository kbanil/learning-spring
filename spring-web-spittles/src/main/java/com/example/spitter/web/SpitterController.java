package com.example.spitter.web;

import com.example.spitter.Spitter;
import com.example.spitter.data.SpitterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by anil on 3/13/17.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {
    private SpitterRepository spitterRepository;

    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String processRegistrationForm(@Valid Spitter spitter, BindingResult errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        Logger logger = Logger.getLogger(this.getClass().getName());
        logger.log(Level.INFO, spitter.getPassword());
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUserName();
    }

    @RequestMapping(value="/{userName}", method = RequestMethod.GET)
    public String showUserProfile(@PathVariable("userName") String userName, Model model) {
        Spitter spitter = spitterRepository.findUser(userName);
        model.addAttribute(spitter);
        return "showUser";
    }
}
