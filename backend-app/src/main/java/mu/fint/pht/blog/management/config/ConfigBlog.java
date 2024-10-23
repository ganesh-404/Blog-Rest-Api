package mu.fint.pht.blog.management.config;

import mu.fint.pht.blog.management.entity.Blog;
import mu.fint.pht.blog.management.mapper.BlogMapper;
import mu.fint.pht.blog.management.repository.BlogRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Configuration class for assessment backend
 *
 * @author ganesh
 */
@ComponentScan(basePackageClasses = {
        BlogMapper.class})
@EnableJpaRepositories(basePackageClasses = {BlogRepository.class})
@EntityScan(basePackageClasses = {Blog.class})
@ComponentScan(basePackages = "mu.fint.pht.blog.management.mapper")
public class ConfigBlog {
}
