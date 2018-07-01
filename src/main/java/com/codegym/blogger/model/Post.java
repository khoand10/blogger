package com.codegym.blogger.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private String content;
    private LocalDate created;
    private String feature;
    private int likes;
    @Lob
    private String teaser;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @ManyToOne
    private User creator;

    public Post() {
    }

    public Post(String content, LocalDate created, String feature, int likes, String teaser, List<Comment> comments, User creator) {
        this.content = content;
        this.created = created;
        this.feature = feature;
        this.likes = likes;
        this.teaser = teaser;
        this.comments = comments;
        this.creator = creator;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
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

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
