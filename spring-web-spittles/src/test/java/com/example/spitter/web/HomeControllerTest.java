package com.example.spitter.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by anil on 3/12/17.
 */

public class HomeControllerTest {
    @Test
    public void testHomeController() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller)
                .build();
        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));
    }
}
