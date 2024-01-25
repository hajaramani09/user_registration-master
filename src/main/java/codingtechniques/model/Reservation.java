package codingtechniques.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservation")
@Getter
@Setter

public class Reservation implements Serializable {

    public Reservation() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id; // clé primaire

    @Column(name = "name", nullable = false, length = 51)
    @NotNull(message = "Le nom complet est un champ obligatoire")
    private String name;

    @Column(name = "Adress", nullable = false, length = 80)
    @NotNull(message = "l'adResse est un champ obligatoire")
    private String Adress;

    @Column(name = "phone", nullable = false, length = 20)
    @NotNull(message = "le téléphone est un champ obligatoire")
    private String phone;

    @Column(name = "email")
    @NotNull(message = "l'e-mail est un champ obligatoire")
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dR")
    @NotNull(message = "La date est un champ obligatoire")
    private Date dR;

    @Column(name = "note")
    @NotNull(message = "La description est un champ obligatoire")
    private String note;

    @Enumerated(EnumType.STRING)
    @Column(name = "Service")
    @NotNull(message = "la sélection d'un service est obligatoire")
    private Service service;

    public Reservation(int id, String name, String Adress, String phone, String email, Date dR, String note,
            Service service) {
        this.id = id;
        this.name = name;
        this.Adress = Adress;
        this.phone = phone;
        this.email = email;
        this.dR = dR;
        this.note = note;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return dR;
    }

    public void setDate(Date dR) {
        this.dR = dR;
    }

    public String getnote() {
        return note;
    }

    public void setnote(String note) {
        this.note = note;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service S) {
        this.service = S;
    }

    @Override
    public String toString() {
        return "Reservation [id=" + id + ", name=" + name + ", Adress=" + Adress + ", phone=" + phone + ", email="
                + email + ", dR=" + dR + ", note=" + note + ", Service=" + service + "]";
    }

}
