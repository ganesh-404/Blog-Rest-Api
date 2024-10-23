package mu.fint.pht.blog.management;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.fint.pht.blog.management.request.BlogRequest;
import mu.fint.pht.blog.management.response.BlogResponse;
import mu.fint.pht.blog.management.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling blog-related REST API requests.
 *
 * @author ganesh.heerah
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    /**
     * Endpoint to save a new blog post.
     *
     * @param request the blog request containing blog details
     */
    @PostMapping
    public void saveBlog(@RequestBody BlogRequest request) {
        log.debug("Received request to save blog: {}", request);
        blogService.saveBlog(request);
    }

    /**
     * Endpoint to update an existing blog post.
     *
     * @param id      the ID of the blog post to update
     * @param request the updated blog details
     */
    @PutMapping("/{id}")
    public void updateBlog(@PathVariable Long id, @RequestBody BlogRequest request) {
        log.debug("Received request to update blog {}", request);
        blogService.updateBlog(request);
    }

    /**
     * Endpoint to delete a blog post.
     *
     * @param id the ID of the blog post to delete
     */
    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable Long id) {
        log.debug("Received request to delete blog with id {}", id);
        blogService.deleteBlog(id);
    }

    /**
     * Endpoint to retrieve all blog posts.
     *
     * @return a list of blog responses
     */
    @GetMapping
    public List<BlogResponse> findAllBlogs() {
        log.debug("Received request to retrieve all blogs");
        return blogService.findAllBlog();
    }
}