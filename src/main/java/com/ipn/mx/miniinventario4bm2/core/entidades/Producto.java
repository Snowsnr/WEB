package com.ipn.mx.miniinventario4bm2.core.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Producto")

public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto", nullable = false)
    private Long idProducto;

    @Column(name = "nombreProducto", length = 100, nullable = false)
    private String nombreProducto;

    @Column(name = "descripcionProducto", length = 100, nullable = false)
    private String descripcionProducto;

    @Column(name = "precioProducto", nullable = false)
    private double precioProducto;

    @Column(name = "existencia", nullable = false)
    private int existencia;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_At", nullable = true)
    private LocalDate createAt;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategoria")
    private Categoria idCategoria;

}
