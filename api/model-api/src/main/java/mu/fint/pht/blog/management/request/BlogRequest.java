package mu.fint.pht.blog.management.request;

import lombok.Data;

import java.util.Date;

/**
 * Data Transfer Object (DTO) for creating or updating a blog post.
 */
@Data
public class BlogRequest {

    private Long id;
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