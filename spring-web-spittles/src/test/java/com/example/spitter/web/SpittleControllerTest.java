package com.example.spitter.web;

import com.example.spitter.Spittle;
import com.example.spitter.data.SpittleRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by anil on 3/12/17.
 */
public class SpittleControllerTest {

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        final int count = 20;
        List<Spittle> spittleList = createSpittleList(count);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(Long.MAX_VALUE, count)).thenReturn(spittleList);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        mockMvc.perform(get("/spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(spittleList.toArray())))
                .andExpect(view().name("spittles"));
    }

    @Test
    public void shouldShowPagedSpittles() throws Exception {
        final int count = 50;
        final long max = 239800;
        List<Spittle> expectedSpittleList = createSpittleList(count);

        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(max, count)).thenReturn(expectedSpittleList);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();

        mockMvc.perform(get("/spittles?max=" + max + "&count=" + count))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittleList.toArray())));
    }

    @Test
    public void testShowSpittles() throws Exception {
        Long spittleId = 123L;
        Spittle expectedSpittle = createSpittle(spittleId);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findOne(spittleId)).thenReturn(expectedSpittle);

        SpittleController controller = new SpittleController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller)
                            .build();

        mockMvc.perform(get("/spittles/" + spittleId))
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle));
    }

    private Spittle createSpittle(long spittleId) {
        return new Spittle("Test Spittle", new Date());
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> list = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            list.add(new Spittle("Spittle: " + i, new Date()));
        }
        return list;
    }
}
