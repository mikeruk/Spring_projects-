package cv.opencv5.models.entities;

import cv.opencv5.models.enums.UserRoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity {


    private UserRoleEnum role;

    public UserRoleEntity() {
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public UserRoleEnum getRole() {
        return role;
    }

    public UserRoleEntity setRole(UserRoleEnum role) {
        this.role = role;
        return this;
    }




}
