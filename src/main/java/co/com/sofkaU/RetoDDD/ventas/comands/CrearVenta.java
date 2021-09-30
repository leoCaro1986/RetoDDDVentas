package co.com.sofkaU.RetoDDD.ventas.comands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkaU.RetoDDD.ventas.values.CanalVenta;
import co.com.sofkaU.RetoDDD.ventas.values.IdVentas;
import co.com.sofkaU.RetoDDD.ventas.values.TipoVenta;

public class CrearVenta extends Command {
    private final IdVentas entityId;
    private final CanalVenta canalVenta;
    private final TipoVenta tipoVenta;

    public CrearVenta(IdVentas entityId, CanalVenta canalVenta, TipoVenta tipoVenta) {
        this.entityId = entityId;
        this.canalVenta = canalVenta;
        this.tipoVenta = tipoVenta;
    }

    public IdVentas getEntityId() {
        return entityId;
    }

    public CanalVenta getCanalVenta() {
        return canalVenta;
    }

    public TipoVenta getTipoVenta() {
        return tipoVenta;
    }
}
