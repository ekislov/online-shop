package com.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "user")
@Table(name = "usr", schema = "public")
public class User {
    private int id;
    private String email;
    private String password;
    private String first_name;
    private String second_name;
    private Date birthday;
    private Set<Order> orders;

    public User() {
    }

    public User(String email, String password, String first_name, String second_name, Date birthday) {
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.second_name = second_name;
        this.birthday = birthday;
    }

    public void clone (User m_user) {
        this.email = m_user.email;
        this.password = m_user.password;
        this.first_name = m_user.first_name;
        this.second_name = m_user.second_name;
        this.birthday = m_user.birthday;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "first_name")
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Column(name = "second_name")
    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
