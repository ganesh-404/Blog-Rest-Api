package mu.fint.pht.blog.management.service.impl;

import mu.fint.pht.blog.management.entity.Blog;
import mu.fint.pht.blog.management.mapper.BlogMapper;
import mu.fint.pht.blog.management.repository.BlogRepository;
import mu.fint.pht.blog.management.request.BlogRequest;
import mu.fint.pht.blog.management.response.BlogResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Testcontainers
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BlogServiceImplTest {

    @Container
    public static MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0.26")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private BlogServiceImpl blogService;

    @BeforeAll
    public static void setUp() {
        System.setProperty("DB_URL", mysqlContainer.getJdbcUrl());
        System.setProperty("DB_USERNAME", mysqlContainer.getUsername());
        System.setProperty("DB_PASSWORD", mysqlContainer.getPassword());
    }

    @Test
    public void testFindAllBlog() {
        List<BlogResponse> blogs = blogService.findAllBlog();
        assertNotNull(blogs);
    }

    @Test
    public void testSaveBlog() {
        // Get the initial count of the Fees table
        int initialCount = blogRepository.findAll().size();
        BlogRequest request = new BlogRequest();
        // Set properties for request
        blogService.saveBlog(request);
        Assertions.assertEquals(initialCount + 1, blogRepository.findAll().size());
    }

    @Test
    public void testUpdateBlog() {
        BlogRequest request = new BlogRequest();
        request.setCategory("test2");
        blogService.updateBlog(request);
        Blog updatedBlog = blogRepository.findById(request.getId()).get();
        Assertions.assertEquals("test2", updatedBlog.getCategory());
    }


    @Test
    public void testDeleteBlog() {
        Long blogId = 1L;
        blogService.deleteBlog(blogId);
        Assertions.assertFalse(blogRepository.findById(blogId).isPresent(), "Blog should be deleted");
    }

}