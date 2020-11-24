package com.alfarosoft.pwmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Application")
public class Application {

    @JsonProperty("appId")
    @Id
    private Integer id;

    @JsonProperty("appName")
    @Column(name = "APP_NAME")
    private String name;

    @JsonProperty("url")
    @Column(name = "URL")
    private String url;

    @JsonProperty("password")
    @Column(name = "PASSWORD")
    private String password;

    public Application(){}

    public Application(Integer id, String name, String url, String password) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(url, that.url) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url, password);
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

