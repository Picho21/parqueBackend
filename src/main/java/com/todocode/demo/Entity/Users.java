package com.todocode.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.todocode.demo.Enum.Rol;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String userName;
    private String password;
    
    private Rol rol;

    @OneToOne
    private Image image;

    public Users() {
    }

    public Users(String id, String userName, String password, Rol rol, Image image) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.rol = rol;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return userName;
    }

    public void setName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
