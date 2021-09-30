package co.com.sofkaU.RetoDDD.ventas.comands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkaU.RetoDDD.ventas.values.FechaFactura;
import co.com.sofkaU.RetoDDD.ventas.values.IdFactura;
import co.com.sofkaU.RetoDDD.ventas.values.IdVentas;
import co.com.sofkaU.RetoDDD.ventas.values.Precio;

public class AgregarFactura extends Command {
    private final IdVentas idVentas;
    private final IdFactura entityId;
    private final FechaFactura fechaFactura;
    private final Precio precio;

    public AgregarFactura(IdVentas idVentas, IdFactura entityId, FechaFactura fechaFactura, Precio precio) {
        this.idVentas = idVentas;
        this.entityId = entityId;
        this.fechaFactura = fechaFactura;
        this.precio = precio;
    }

    public IdVentas getIdVentas() {
        return idVentas;
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
