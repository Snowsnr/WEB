package com.ipn.mx.miniinventario4bm2.features.archivo.service;

import com.ipn.mx.miniinventario4bm2.core.entidades.Archivo;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public interface ArchivoService {
    Archivo guardarArchivoEnBaseDeDatos(MultipartFile archivo)
            throws IOException;
    Optional<Archivo> descargarArchivo(Long id) throws FileNotFoundException;
}
