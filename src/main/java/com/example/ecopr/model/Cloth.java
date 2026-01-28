package com.example.ecopr.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity 
@Table(name = "cloth")
public class Cloth {

    @Id
    @Column(name = "cloth_id")
    private Long clothId;

    @Column(name = "cloth", nullable = false)
    private String cloth;

    @OneToMany(mappedBy = "cloth", cascade = CascadeType.ALL, orphanRemoval = true)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Set<Relations> relations = new HashSet<>();

    public Cloth() {
        // Default constructor
    }

    public Cloth(String cloth) {
        this.cloth = cloth;
    }

    // Getters and setters for attributes
    public Long getClothId() {
        return clothId;
    }

    public void setClothId(Long clothId) {
        this.clothId = clothId;
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
        return "Cloth{ clothId=" + clothId + ", cloth=" + cloth + " }";
    }
}
