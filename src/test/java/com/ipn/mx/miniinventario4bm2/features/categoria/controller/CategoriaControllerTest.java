package com.ipn.mx.miniinventario4bm2.features.categoria.controller;

import com.ipn.mx.miniinventario4bm2.core.entidades.Categoria;
import com.ipn.mx.miniinventario4bm2.features.categoria.service.CategoriaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CategoriaControllerTest {

    private MockMvc mockMvc;
    private CategoriaService categoriaService;

    @BeforeEach
    void setUp() {
        CategoriaController controller = new CategoriaController();
        categoriaService = Mockito.mock(CategoriaService.class);
        ReflectionTestUtils.setField(controller, "categoriaService", categoriaService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void createShouldAcceptPathWithoutTrailingSlash() throws Exception {
        when(categoriaService.save(any(Categoria.class))).thenAnswer(invocation -> invocation.getArgument(0));

        mockMvc.perform(post("/v1/categorias/categoria")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"nombreCategoria\":\"Deportes\"," +
                                "\"descripcionCategoria\":\"Articulos relacionados con deportes\"," +
                                "\"createAt\":\"2026-04-29\"" +
                                "}"))
                .andExpect(status().isCreated());

        verify(categoriaService).save(any(Categoria.class));
    }

    @Test
    void createShouldAcceptPathWithTrailingSlash() throws Exception {
        when(categoriaService.save(any(Categoria.class))).thenAnswer(invocation -> invocation.getArgument(0));

        mockMvc.perform(post("/v1/categorias/categoria/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"nombreCategoria\":\"Deportes\"," +
                                "\"descripcionCategoria\":\"Articulos relacionados con deportes\"," +
                                "\"createAt\":\"2026-04-29\"" +
                                "}"))
                .andExpect(status().isCreated());

        verify(categoriaService).save(any(Categoria.class));
    }

    @Test
    void updateShouldModifyExistingCategoryInsteadOfCreatingANewOne() throws Exception {
        Categoria existing = new Categoria();
        existing.setIdCategoria(2L);
        existing.setNombreCategoria("Deportes");
        existing.setDescripcionCategoria("Articulos deportivos");

        when(categoriaService.findById(2L)).thenReturn(existing);
        when(categoriaService.save(any(Categoria.class))).thenAnswer(invocation -> invocation.getArgument(0));

        mockMvc.perform(put("/v1/categorias/categoria/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"nombreCategoria\":\"Deporteees\"," +
                                "\"descripcionCategoria\":\"Articulos de entretenimiento\"," +
                                "\"createAt\":\"2026-03-29\"" +
                                "}"))
                .andExpect(status().isOk());

        verify(categoriaService).findById(2L);
        var captor = forClass(Categoria.class);
        verify(categoriaService).save(captor.capture());

        Categoria saved = captor.getValue();
        assertEquals(2L, saved.getIdCategoria());
        assertEquals("Deporteees", saved.getNombreCategoria());
        assertEquals("Articulos de entretenimiento", saved.getDescripcionCategoria());
        assertEquals(java.time.LocalDate.parse("2026-03-29"), saved.getCreateAt());
    }
}
