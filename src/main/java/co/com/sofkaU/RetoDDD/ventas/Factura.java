package co.com.sofkaU.RetoDDD.ventas;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkaU.RetoDDD.ventas.values.IdFactura;

public class Factura extends Entity<IdFactura> {
    public Factura(IdFactura entityId) {
        super(entityId);
    }
}
