package co.com.sofkaU.RetoDDD.ventas.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.ventas.values.FechaFactura;
import co.com.sofkaU.RetoDDD.ventas.values.IdFactura;
import co.com.sofkaU.RetoDDD.ventas.values.Precio;

import java.util.UUID;

public class FacturaAgregada extends DomainEvent {
    private final IdFactura entityId;
    private final FechaFactura fechaFactura;
    private final Precio precio;

    public FacturaAgregada(IdFactura entityId, FechaFactura fechaFactura, Precio precio) {
        super("empresa.venta.facturaagregada");
        this.entityId=entityId;
        this.fechaFactura=fechaFactura;
        this.precio=precio;
    }

    public IdFactura getEntityId() {
        return entityId;
    }

    public FechaFactura getFechaFactura() {
        return fechaFactura;
    }

    public Precio getPrecio() {
        return precio;
    }
}
