package com.alfarosoft.pwmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "User")
public class User {

    @JsonProperty("userId")
    @Id
    private Integer id;

    @JsonProperty("username")
    @Column(name = "USERNAME")
    private String username;

    @JsonProperty("password")
    @Column(name = "USERNAME")
    private String password;

    @JsonProperty("applications")
    @Column(name = "APPLICATIONS")
    private List<Application> applications;

    @JsonProperty("hint")
    @Column(name = "HINT")
    private String hint;

    public User() {}

    public User(Integer id, String username, String password, List<Application> applications, String hint) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.applications = applications;
        this.hint = hint;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(applications, user.applications) &&
                Objects.equals(hint, user.hint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, applications, hint);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", applications=" + applications +
                ", hint='" + hint + '\'' +
                '}';
    }
}
