package mu.fint.pht.blog.management.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.fint.pht.blog.management.mapper.BlogMapper;
import mu.fint.pht.blog.management.repository.BlogRepository;
import mu.fint.pht.blog.management.request.BlogRequest;
import mu.fint.pht.blog.management.response.BlogResponse;
import mu.fint.pht.blog.management.service.BlogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service implementation for {@link BlogService}
 *
 * @author ganesh.heerah
 */
@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    private final BlogMapper blogMapper;

    @Override
    public List<BlogResponse> findAllBlog() {
        log.debug("Find all blog");
        return blogMapper.toResponse(blogRepository.findAll());
    }

    @Transactional
    @Override
    public void saveBlog(BlogRequest request) {
        log.debug("Save blog");
        blogRepository.save(blogMapper.toEntity(request));

    }

    @Transactional
    @Override
    public void updateBlog(BlogRequest request) {
        log.debug("Update blog");
        blogRepository.findById(request.getId()).ifPresentOrElse(
                blog -> {
                    blogRepository.save(blogMapper.toEntity(request));
                },
                () -> {
                    log.error("Blog not found");
                }
        );
    }

    @Transactional
    @Override
    public void deleteBlog(Long BlogId) {
        log.debug("Delete blog");
        blogRepository.deleteById(BlogId);
    }
}
