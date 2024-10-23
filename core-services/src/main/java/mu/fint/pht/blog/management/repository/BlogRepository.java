package mu.fint.pht.blog.management.repository;

import mu.fint.pht.blog.management.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository for {@link Blog}
 *
 * @author ganesh.heerah
 */
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Optional<Blog> findById(Long id);
}
