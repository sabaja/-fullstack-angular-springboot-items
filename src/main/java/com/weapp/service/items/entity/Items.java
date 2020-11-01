package com.weapp.service.items.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "Items")
@Table(name = "articoli", schema = "myschema")
@Data
public class Items implements Serializable {
    private static final long serialVersionUID = 353670367213236166L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "descrizione")
    private String description;

    @Column(name = "um")
    private Character um;

    @Column(name = "codstat")
    private String codstat;

    @Column(name = "pzcart")
    private Short pzcart;

    @Column(name = "pesonetto")
    private Double netWeight;

    @Column(name = "idstatoart", columnDefinition = "CHAR")
    private Character stateItemId;

    @Column(name = "datacreazione")
    private LocalDate creationDate;

    @OneToMany(mappedBy = "items", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Set<Barcode> barcodes;

    @OneToOne(mappedBy = "items", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Ingredients ingredients;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "idiva", insertable = false, updatable = false)
    private Iva iva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private FamilyAssortment familyAssortment;
}
