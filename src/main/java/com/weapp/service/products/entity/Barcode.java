package com.weapp.service.products.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Barcode")
@Table(name = "barcode", schema = "myschema")
@Data
public class Barcode implements Serializable {

    private static final long serialVersionUID = 6204582344429199389L;

    @Id
    @Column(name = "barcode")
    private String id;

    @Column(name = "idtipoart")
    private String productTypeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODART", referencedColumnName = "id")
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Products products;

}
