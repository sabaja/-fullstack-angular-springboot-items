package com.weapp.service.items.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

@Entity
@Table(name = "famassort", schema = "myschema")
@Data
public class FamilyAssortment implements Serializable {

    private static final long serialVersionUID = 6204582344429199389L;

    @Id
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "descrizione")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "familyAssortment")
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Set<Items> items;

}
