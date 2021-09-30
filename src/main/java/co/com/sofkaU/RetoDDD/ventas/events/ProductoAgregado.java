package co.com.sofkaU.RetoDDD.ventas.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.ventas.values.IdProducto;
import co.com.sofkaU.RetoDDD.ventas.values.NombreProducto;

import java.util.UUID;

public class ProductoAgregado extends DomainEvent{
    private final IdProducto entityId;
    private final NombreProducto nombreProducto;

    public ProductoAgregado(IdProducto entityId, NombreProducto nombreProducto) {
        super("empresa.venta.productoagregado");
        this.entityId=entityId;
        this.nombreProducto=nombreProducto;
    }

    public IdProducto getEntityId() {
        return entityId;
    }

    public NombreProducto getNombreProducto() {
        return nombreProducto;
    }
}