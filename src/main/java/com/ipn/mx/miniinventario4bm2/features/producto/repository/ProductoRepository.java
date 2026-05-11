package com.ipn.mx.miniinventario4bm2.features.producto.repository;

import com.ipn.mx.miniinventario4bm2.core.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
