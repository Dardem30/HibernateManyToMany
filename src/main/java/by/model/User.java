package by.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by УВД on 20.06.2017.
 */
@Entity
@Table(name="user")
public class User {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
   @Column(name = "username")
    private String username;
   @Column(name = "password")
    private String password;
   @ManyToMany
   @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id"),
   inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + getRoles().toString() +
                '}';
    }
}
