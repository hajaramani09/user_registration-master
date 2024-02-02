package codingtechniques.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "responsable")

public class Responsable implements Serializable {

    public Responsable() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id; // clé primaire

    @NotNull(message = "L'email est un champ obligatoire")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Le mot de pass est un champ obligatoire")
    @Column(name = "pwd")
    private String pwd;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Responsable(int id, String email, String pwd) {
        this.id = id;
        this.email = email;
        this.pwd = pwd;
    }

   

}
