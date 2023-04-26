package cv.opencv5.models.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {


    private String username;
    private String password;
    private List<UserRoleEntity> roles = new ArrayList<>();


    public UserEntity() {
    }



        @Column(nullable = false, unique = true, length = 10)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;
    }


//    @Override
//    public String toString() {
//        return "UserEntity{" +
//                "id=" + this.getId() +
//                ", roles=" + roles +
//                '}';
//    }

}
