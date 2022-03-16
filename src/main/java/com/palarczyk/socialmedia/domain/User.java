package com.palarczyk.socialmedia.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@SecondaryTables({
        @SecondaryTable(name="authorities")
})
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @NotNull
    private String username;
    private String firstName;
    private String lastName;
    @NotNull
    private String password;
    @NotNull
    private boolean enabled;
    @NotNull
    @Column(table="authorities")
    private String authority;

    public User() {

    }

    public User(Long id, String username, String firstName, String lastName,
                String password, boolean enabled, String authority) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.enabled = enabled;
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
