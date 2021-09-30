package co.com.sofkaU.RetoDDD.ventas.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.ventas.values.FechaFactura;
import co.com.sofkaU.RetoDDD.ventas.values.IdFactura;
import co.com.sofkaU.RetoDDD.ventas.values.Precio;

public class FacturaAgregada extends DomainEvent {
    private final IdFactura idFactura;
    private final FechaFactura fechaFactura;
    private final Precio precio;

    public FacturaAgregada(IdFactura idFactura, FechaFactura fechaFactura, Precio precio) {
        super("empresa.venta.facturaagregada");
        this.idFactura =idFactura;
        this.fechaFactura=fechaFactura;
        this.precio=precio;
    }

    public IdFactura getIdFactura() {
        return idFactura;
    }

    public FechaFactura getFechaFactura() {
        return fechaFactura;
    }

    public Precio getPrecio() {
        return precio;
    }
}
