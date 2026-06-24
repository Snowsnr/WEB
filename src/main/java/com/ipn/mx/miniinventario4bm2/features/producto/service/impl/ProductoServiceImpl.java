package com.ipn.mx.miniinventario4bm2.features.producto.service.impl;

import com.ipn.mx.miniinventario4bm2.core.entidades.Producto;
import com.ipn.mx.miniinventario4bm2.features.producto.repository.ProductoRepository;
import com.ipn.mx.miniinventario4bm2.features.producto.service.ProductoService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
//@RequiredArgsConstructor //para quitar el @Autowired
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        if(producto.getIdProducto() <= 0){
            producto.setIdProducto(null);
        }

        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}
