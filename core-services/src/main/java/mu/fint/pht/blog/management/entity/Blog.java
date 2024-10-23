package mu.fint.pht.blog.management.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


/**
 * Entity class representing a blog post.
 */
@Entity
@Data
public class Blog {

    /**
     * Unique identifier for each blog post.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    /**
     * Timestamp when the blog post was last updated.
     */
    @Temporal(TemporalType.TIMESTAMP)
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