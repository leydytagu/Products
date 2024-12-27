package com.productos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoRepositoryTest {
    private ProductoRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new ProductoRepository();
    }

    @Test
    public void testInsertarProducto() {
        Producto producto = new Producto(1, "Producto A", 100.0);
        repository.insertar(producto);
        assertEquals(1, repository.listar().size());
    }

    @Test
    public void testListarProductos() {
        repository.insertar(new Producto(1, "Producto A", 100.0));
        repository.insertar(new Producto(2, "Producto B", 200.0));
        assertEquals(2, repository.listar().size());
    }

    @Test
    public void testActualizarProducto() {
        Producto producto = new Producto(1, "Producto A", 100.0);
        repository.insertar(producto);

        Producto nuevoProducto = new Producto(1, "Producto Actualizado", 150.0);
        Optional<Producto> actualizado = repository.actualizar(1, nuevoProducto);

        assertTrue(actualizado.isPresent());
        assertEquals("Producto Actualizado", actualizado.get().getNombre());
        assertEquals(150.0, actualizado.get().getPrecio());
    }

    @Test
    public void testBorrarProducto() {
        Producto producto = new Producto(1, "Producto A", 100.0);
        repository.insertar(producto);

        boolean resultado = repository.borrar(1);
        assertTrue(resultado);
        assertEquals(0, repository.listar().size());
    }
}
