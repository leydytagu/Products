package com.productos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private final List<Producto> productos = new ArrayList<>();

    // Inserta un producto
    public void insertar(Producto producto) {
        productos.add(producto);
    }

    // Lista todos los productos
    public List<Producto> listar() {
        return productos;
    }

    // Actualiza un producto por ID
    public Optional<Producto> actualizar(int id, Producto nuevoProducto) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                producto.setNombre(nuevoProducto.getNombre());
                producto.setPrecio(nuevoProducto.getPrecio());
                return Optional.of(producto);
            }
        }
        return Optional.empty();
    }

    // Borra un producto por ID
    public boolean borrar(int id) {
        return productos.removeIf(producto -> producto.getId() == id);
    }
}
