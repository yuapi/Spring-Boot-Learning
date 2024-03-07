package org.yuapi.learn.service.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yuapi.learn.domain.posts.Posts;
import org.yuapi.learn.domain.posts.PostsRepository;
import org.yuapi.learn.web.dto.PostsResponseDto;
import org.yuapi.learn.web.dto.PostsSaveRequestDto;
import org.yuapi.learn.web.dto.PostsUpdateRequestDto;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
