package com.luiscm.forohub.model;

import com.luiscm.forohub.model.dto.UserRegisterDTO;
import com.luiscm.forohub.model.dto.UserUpdateDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "User")
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean active;

    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false, length = 12)
    private String telephone;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Profile profile;

    public User(UserRegisterDTO userData) {
        this.active = true;
        this.name = userData.name();
        this.email = userData.email();  
        this.password = userData.password();
        this.telephone = userData.telephone();
        this.profile = userData.profile();
    }

    public void updateData(@Valid UserUpdateDTO userData) {
        
        if (userData.name() != null) {
            this.name = userData.name();
        }
        
        if (userData.email() != null) {
            this.email = userData.email();
        }
        
        if (userData.password() != null) {
            this.password = userData.password();
        }
        
        if (userData.telephone() != null) {
            this.telephone = userData.telephone();
        }
    }

    public void deleteUser() {
        this.active = false;
    }
    
}
