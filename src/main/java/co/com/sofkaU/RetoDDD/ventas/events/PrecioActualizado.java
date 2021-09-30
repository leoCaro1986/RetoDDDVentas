package co.com.sofkaU.RetoDDD.ventas.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.ventas.values.IdFactura;
import co.com.sofkaU.RetoDDD.ventas.values.Precio;

public class PrecioActualizado extends DomainEvent{
    private final IdFactura idFactura;
    private final Precio precio;

    public PrecioActualizado(IdFactura idFactura, Precio precio) {
        super("empresa.venta.precioactualizado");
        this.idFactura=idFactura;
        this.precio=precio;
    }

    public IdFactura getIdFactura() {
        return idFactura;
    }

    public Precio getPrecio() {
        return precio;
    }
}
