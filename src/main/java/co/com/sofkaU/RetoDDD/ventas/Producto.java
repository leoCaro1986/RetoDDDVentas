package co.com.sofkaU.RetoDDD.ventas;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkaU.RetoDDD.ventas.values.IdProducto;

public class Producto extends Entity<IdProducto> {
    public Producto(IdProducto entityId) {
        super(entityId);
    }
}
