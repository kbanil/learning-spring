package com.example.spitter.web;

import com.example.spitter.Spitter;
import com.example.spitter.data.SpitterRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.view.InternalResourceView;



import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by anil on 3/13/17.
 */
public class SpitterControllerTest {

    @Test
    public void shouldShowRegistrationForm() throws Exception {
        SpitterRepository spitterRepository = mock(SpitterRepository.class);
        SpitterController spitterController = new SpitterController(spitterRepository);
        MockMvc mockMvc = standaloneSetup(spitterController)
                .setSingleView(new InternalResourceView("/WEB-INF/views/regiterForm.jsp"))
                .build();
        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldShowUserProfile() throws Exception {
        Spitter expectedSpitter = new Spitter(24L, "Jack", "Bauer", "jbauer", "pass123");
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        when(mockRepository.findUser("jbauer")).thenReturn(expectedSpitter);

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .build();
        mockMvc.perform(get("/spitter/jbauer"))
                .andExpect(view().name("showUser"))
                .andExpect(model().attributeExists("spitter"))
                .andExpect(model().attribute("spitter", expectedSpitter));
        verify(mockRepository, atLeastOnce()).findUser("jbauer");
    }

    @Test
    public void shouldProcessRegistrationForm() throws Exception {
        Spitter unsaved = new Spitter("Jack", "Bauer", "jbauer", "pass123");
        Spitter saved = new Spitter(24L, "Jack", "Bauer", "jbauer", "pass123");
        SpitterRepository spitterRepository = mock(SpitterRepository.class);
        when(spitterRepository.save(unsaved)).thenReturn(saved);
        SpitterController spitterController = new SpitterController(spitterRepository);

        MockMvc mockMvc = standaloneSetup(spitterController)
                .build();
        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("userName", "jbauer")
                .param("password", "pass123"))
                .andExpect(redirectedUrl("/spitter/jbauer"));
        verify(spitterRepository, atLeastOnce()).save(unsaved);
    }

    @Test
    public void testInvalidSpitter() throws Exception {
        Spitter invalidSpitter = new Spitter("Jack", "Bauer", "jbauer", "pass");
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        SpitterController controller = new SpitterController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller)
//                .setValidator(validator)
                .build();

        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("userName", "jbauer")
                .param("password", "pass"))
                .andExpect(view().name("registerForm"));
    }
}
