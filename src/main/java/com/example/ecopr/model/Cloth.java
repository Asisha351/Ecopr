package com.example.ecopr.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity 
@Table(name = "cloth")
public class Cloth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cloth_id")
    private Long cloth_id;

    @Column(name = "cloth", nullable = false)
    private String cloth;

    @OneToMany(mappedBy = "cloth", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Relations> relations = new HashSet<>();

    public Cloth() {
        // Default constructor
    }

    public Cloth(String cloth) {
        this.cloth = cloth;
    }

    // Getters and setters for attributes
    public Long getCloth_id() {
        return cloth_id;
    }

    public void setCloth_id(Long cloth_id) {
        this.cloth_id = cloth_id;
    }

    public String getCloth() {
        return cloth;
    }

    public void setCloth(String cloth) {
        this.cloth = cloth;
    }

    public Set<Relations> getRelations() {
        return relations;
    }

    public void setRelations(Set<Relations> relations) {
        this.relations = relations;
    }

    @Override
    public String toString() {
        return "Cloth{ cloth_id=" + cloth_id + ", cloth=" + cloth + " }";
    }
}
