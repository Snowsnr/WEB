package com.ipn.mx.miniinventario4bm2.features.categoria.service;

import com.ipn.mx.miniinventario4bm2.core.entidades.Categoria;
import java.util.List;

public interface CategoriaService {
    public List<Categoria> findAll();
    public Categoria findById(long id);
    public Categoria save(Categoria categoria);
    public void deleteById(long id);
}
