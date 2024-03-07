package org.yuapi.learn.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.yuapi.learn.service.posts.PostsService;
import org.yuapi.learn.web.dto.PostsResponseDto;
import org.yuapi.learn.web.dto.PostsSaveRequestDto;
import org.yuapi.learn.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
