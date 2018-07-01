package com.codegym.blogger.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Lob
    private String content;
    @ManyToOne
    @JoinColumn(name = "commentator_id")
    private User commentator;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment() {
    }

    public Comment(String content, User commentator) {
        this.content = content;
        this.commentator = commentator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getCommentator() {
        return commentator;
    }

    public void setCommentator(User commentator) {
        this.commentator = commentator;
    }
}
