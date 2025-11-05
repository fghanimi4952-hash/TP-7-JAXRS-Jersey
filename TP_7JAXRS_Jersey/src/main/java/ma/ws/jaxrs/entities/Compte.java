package ma.ws.jaxrs.entities;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Date;

@Entity
@XmlRootElement
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private double solde;
    
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    
    @Enumerated(EnumType.ORDINAL)
    private TypeCompte type;

    // Constructeurs
    public Compte() {
    }

    public Compte(Long id, double solde, Date dateCreation, TypeCompte type) {
        this.id = id;
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.type = type;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public double getSolde() {
        return solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public TypeCompte getType() {
        return type;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setType(TypeCompte type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", solde=" + solde +
                ", dateCreation=" + dateCreation +
                ", type=" + type +
                '}';
    }
}

