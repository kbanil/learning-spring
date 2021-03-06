package com.example.spitter.web;

import com.example.spitter.Spittle;
import com.example.spitter.data.SpittleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by anil on 3/12/17.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository repository;

    public SpittleController(SpittleRepository repository) {
        this.repository = repository;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model) {
//        model.addAttribute(repository.findSpittles(Long.MAX_VALUE, 20));
//        return "spittles";
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = Long.MAX_VALUE + "") long max,
                                  @RequestParam(value = "count", defaultValue = "20") int count) {
        return repository.findSpittles(max, count);
    }

    @RequestMapping(value="/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
        Spittle spittle = repository.findOne(spittleId);
        model.addAttribute(spittle);
        return "spittle";
    }
}
