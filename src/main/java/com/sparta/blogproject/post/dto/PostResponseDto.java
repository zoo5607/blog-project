package com.sparta.blogproject.post.dto;

import com.sparta.blogproject.comment.dto.CommentResponseDto;
import com.sparta.blogproject.comment.entity.Comment;
import com.sparta.blogproject.like.repository.PostLikeRepository;
import com.sparta.blogproject.post.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostResponseDto {
    private String username;
    private String contents;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private int like;
    private List<CommentResponseDto> comments;

    public PostResponseDto(Post post) {
        this.username = post.getUser().getUsername();
        this.contents = post.getContents();
        this.title = post.getTitle();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.like = post.getPostLikeList().size();
        this.comments = post.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }
}
