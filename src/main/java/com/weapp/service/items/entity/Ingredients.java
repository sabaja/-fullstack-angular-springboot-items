package com.weapp.service.items.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Ingredients")
@Table(name = "ingredienti", schema = "myschema")
@Data
public class Ingredients implements Serializable {

    private static final long serialVersionUID = -8360042136106614179L;

    @Id
    @Column(name = "CODART")
    private String id;

    @Column(name = "INFO")
    private String info;

    @OneToOne
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private Items items;

}
