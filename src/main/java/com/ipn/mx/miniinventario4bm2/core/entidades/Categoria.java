package com.ipn.mx.miniinventario4bm2.core.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter; import lombok.Setter; import lombok.ToString;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter @ToString(exclude = "productos")
@NoArgsConstructor
@Entity
@Table(name = "Categoria")
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //si se llaman igual se puede omitir el nombre
    @Column(name = "idCategoria", nullable = false)
    private Long idCategoria;
    @Size(min = 4, max = 50, message = "debe estar entre 4 y 50")
    @Column(length = 50, nullable = false)
    private String nombreCategoria;
    @Column(length = 100, nullable = false)
    private String descripcionCategoria;
    @Column(name = "create_At", nullable = true)
    private LocalDate createAt;

    @JsonIgnore
    @OneToMany(mappedBy = "idCategoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Producto> productos = new HashSet<>();
    @Override public boolean equals(Object o) { if (this == o) return true; if (!(o instanceof Categoria)) return false; Categoria other = (Categoria) o; return idCategoria != null && idCategoria.equals(other.idCategoria); } @Override public int hashCode() { return getClass().hashCode(); }
}
