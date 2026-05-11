package com.ipn.mx.miniinventario4bm2;

import com.ipn.mx.miniinventario4bm2.core.entidades.Categoria;
import com.ipn.mx.miniinventario4bm2.features.categoria.repository.CategoriaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniInventario4Bm2Application implements CommandLineRunner {

    @Autowired
    private CategoriaDAO dao;

    @Override
    public void run(String... args) throws Exception {
        /*
        IO.println("Categoria");
        Categoria categoria = new Categoria();
        //categoria.setIdCategoria(1L);
        categoria.setNombreCategoria("Deportes");
        categoria.setDescripcionCategoria("Artículos relacionados con deportes");

        dao.save(categoria);

        IO.println(dao.findById(1L).orElse(null));
        IO.println(dao.findAll());

        //dao.deleteById(categoria.getIdCategoria());

         */
        System.out.println("Estoy trabajando");

    }

    public static void main(String[] args) {
        SpringApplication.run(MiniInventario4Bm2Application.class, args);
    }
}
