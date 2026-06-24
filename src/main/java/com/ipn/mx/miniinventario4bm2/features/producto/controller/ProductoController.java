package com.ipn.mx.miniinventario4bm2.features.producto.controller;

import com.ipn.mx.miniinventario4bm2.core.entidades.Producto;
import com.ipn.mx.miniinventario4bm2.features.mail.service.EmailService;
import com.ipn.mx.miniinventario4bm2.features.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @Autowired
    private EmailService emailService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> findAll() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")//documentacion dice /{id}/buscar, el id entre el endpoint y la accion
    @ResponseStatus(HttpStatus.OK)
    public Producto findById(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto create(@RequestBody Producto producto){
        return productoService.save(producto);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable Long id,
                           @RequestBody Producto producto){
        Producto p = productoService.findById(id);
        //hacer validaciones para null
        p.setNombreProducto(producto.getNombreProducto());
        p.setDescripcionProducto(producto.getDescripcionProducto());
        p.setExistencia(producto.getExistencia());
        p.setPrecioProducto(producto.getPrecioProducto());
        p.setCreateAt(producto.getCreateAt());
        p.setIdCategoria(producto.getIdCategoria());
        return productoService.save(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        productoService.deleteById(id);
    }
}
