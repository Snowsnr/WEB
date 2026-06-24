package com.ipn.mx.miniinventario4bm2.features.categoria.service.impl;

import com.ipn.mx.miniinventario4bm2.core.entidades.Categoria;
import com.ipn.mx.miniinventario4bm2.features.categoria.repository.CategoriaDAO;
import com.ipn.mx.miniinventario4bm2.features.categoria.service.CategoriaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaDAO categoriaRepositorty;

    @Transactional

    @Override
    public List<Categoria> findAll() {
        return categoriaRepositorty.findAll();
    }

    @Transactional
    @Override
    public Categoria findById(long id) {
        return categoriaRepositorty.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Categoria save(Categoria categoria) {
        if(categoria.getIdCategoria() <= 0){
            categoria.setIdCategoria(null);
        }

        return categoriaRepositorty.save(categoria);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        categoriaRepositorty.deleteById(id);
    }
}
