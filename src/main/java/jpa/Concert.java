package jpa;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int prix;
    private LocalDate date;
    private String lieu;
    private int capacity;
    @OneToOne
    @JoinColumn(name = "artiste_id")
    private Artiste artiste;

    @OneToMany(mappedBy = "concert",cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "organisateur_id")  // Clé étrangère en DB
    private Organisateur organisateur;
    public Concert() {
    }


    public Concert(int prix, LocalDate date, String lieu, int capacity) {
        this.prix = prix;
        this.date = date;
        this.lieu = lieu;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "id=" + id +
                ", prix=" + prix +
                ", date=" + date +
                ", lieu='" + lieu + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    }
