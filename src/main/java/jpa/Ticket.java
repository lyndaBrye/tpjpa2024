package jpa;

import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double prix;
    @ManyToOne
    @JoinColumn(name = "concert_id")
    private Concert concert;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Ticket() {
    }


    public Ticket(double prix) {
        this.prix = prix;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", prix=" + prix +
                '}';
    }
}
