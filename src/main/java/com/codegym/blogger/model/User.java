package com.codegym.blogger.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String name;
    public String email;
    public String password;
    public int age;
    public String job;
    public String avatar;
    @OneToMany(mappedBy = "creator")
    private List<Category> categories;

    @OneToMany(mappedBy = "commentator")
    private List<Comment> comments;

    @OneToMany(mappedBy = "creator")
    private List<Post> posts;

    public User(){
    }

    public User(String name, String email, String password, int age, String job, String avatar, List<Category> categories, List<Comment> comments, List<Post> posts) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.job = job;
        this.avatar = avatar;
        this.categories = categories;
        this.comments = comments;
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
