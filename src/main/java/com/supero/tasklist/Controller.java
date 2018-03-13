package com.supero.tasklist;

/**
 * Created by christian.tusset on 12/03/2018.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {
 
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index.html");
    }
    
}
