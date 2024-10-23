package mu.fint.pht.blog.management.mapper;

import mu.fint.pht.blog.management.entity.Blog;
import mu.fint.pht.blog.management.request.BlogRequest;
import mu.fint.pht.blog.management.response.BlogResponse;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper for {@link mu.fint.pht.blog.management.entity.Blog}
 *
 * @author ganesh.heerah
 */
@Mapper(componentModel = "spring")
public interface BlogMapper {

    /**
     * Map {@link Blog} to {@link BlogResponse}
     *
     * @param blog {@link Blog}
     * @return the {@link BlogResponse}
     */
    List<BlogResponse> toResponse(List<Blog> blog);


    /**
     * Map {@link BlogRequest} to {@link Blog}
     *
     * @param blogRequest {@link BlogRequest}
     * @return the {@link BlogResponse}
     */
    Blog toEntity(BlogRequest blogRequest);
}
