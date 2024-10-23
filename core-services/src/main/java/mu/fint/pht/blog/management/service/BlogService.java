package mu.fint.pht.blog.management.service;

import mu.fint.pht.blog.management.request.BlogRequest;
import mu.fint.pht.blog.management.response.BlogResponse;

import java.util.List;

/**
 * Expose service base on operation concerning blog
 *
 * @author ganesh.heerah
 */
public interface BlogService {
    /**
     * Method to find all blog
     *
     * @return list of {@link BlogResponse}
     */
    List<BlogResponse> findAllBlog();

    /**
     * Save blog details
     *
     * @param request {@link BlogRequest the Blog request}
     */
    void saveBlog(BlogRequest request);

    /**
     * Update blog details
     *
     * @param request {@link BlogRequest the Blog request}
     */
    void updateBlog(BlogRequest request);

    /**
     * Delete blog by id
     *
     * @param BlogId {@link mu.fint.pht.blog.management.entity.Blog id of Blog}
     */
    void deleteBlog(Long BlogId);
}