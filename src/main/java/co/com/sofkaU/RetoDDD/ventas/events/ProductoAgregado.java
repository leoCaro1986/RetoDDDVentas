package co.com.sofkaU.RetoDDD.ventas.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.ventas.values.IdProducto;
import co.com.sofkaU.RetoDDD.ventas.values.NombreProducto;

public class ProductoAgregado extends DomainEvent{
    private final IdProducto idProducto;
    private final NombreProducto nombreProducto;

    public ProductoAgregado(IdProducto idProducto, NombreProducto nombreProducto) {
        super("empresa.venta.productoagregado");
        this.idProducto =idProducto;
        this.nombreProducto=nombreProducto;
    }

    public IdProducto getIdProducto() {
        return idProducto;
    }

    public NombreProducto getNombreProducto() {
        return nombreProducto;
    }
}
