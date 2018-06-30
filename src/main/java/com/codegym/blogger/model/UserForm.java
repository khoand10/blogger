package com.codegym.blogger.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

public class UserForm {

    public Long id;

    public String name;
    public String email;
    public String password;
    private String rePassword;
    public String phone;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    public Date birthday;
    public String job;
    public MultipartFile avatar;
    public String urlAvatar;

    public UserForm(){

    }

    public UserForm(Long id, String name, String email, String password, String rePassword, String phone, Date birthday, String job, MultipartFile avatar, String urlAvatar) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.rePassword = rePassword;
        this.phone = phone;
        this.birthday = birthday;
        this.job = job;
        this.avatar = avatar;
        this.urlAvatar = urlAvatar;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public Long getId() {
        return id;
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

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}
