package mu.fint.pht.blog.management;

import mu.fint.pht.blog.management.service.BlogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BlogService blogService;

    @InjectMocks
    private BlogController blogController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(blogController).build();
    }

    @Test
    void testSaveBlog() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/blog")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Test Blog\",\"content\":\"Test Content\"}"))
                .andExpect(status().isOk());
    }


    @Test
    void testUpdateBlog() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/blog/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteBlog() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/blog/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testFindAllBlogs() throws Exception {
        when(blogService.findAllBlog()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/blog"))
                .andExpect(status().isOk());
    }
}