package com.weapp.service.items.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

@Entity(name = "Iva")
@Table(name = "iva", schema = "myschema")
@Data
public class Iva implements Serializable {

    private static final long serialVersionUID = 6204582344429199389L;

    @Id
    @Column(name = "idiva")
    private BigInteger id;

    @Column(name = "descrizione")
    private String description;

    @Column(name = "aliquota")
    private BigInteger rate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "iva")
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Set<Items> items;

}
