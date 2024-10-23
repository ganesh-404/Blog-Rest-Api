package mu.fint.pht.blog.management.response;

import lombok.Data;

import java.util.Date;

/**
 * @author ganesh.heerah
 */
@Data
public class BlogResponse {
    /**
     * Title of the blog post.
     */
    private String title;

    /**
     * Main content/body of the blog post.
     */
    private String content;

    /**
     * Author of the blog post.
     */
    private String author;

    /**
     * Timestamp when the blog post was created.
     */
    private Date createdAt;

    /**
     * Timestamp when the blog post was last updated.
     */
    private Date updatedAt;

    /**
     * Category of the blog (e.g., tech, lifestyle).
     */
    private String category;

    /**
     * Status of the blog (e.g., published, draft).
     */
    private String status;

}
