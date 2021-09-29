package co.com.sofkaU.RetoDDD.ventas.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.ventas.values.CanalVenta;
import co.com.sofkaU.RetoDDD.ventas.values.TipoVenta;

import java.util.UUID;

public class VentaCreada extends DomainEvent {
    private final TipoVenta tipoVenta;
    private final CanalVenta canalVenta;
    public VentaCreada(TipoVenta tipoVenta, CanalVenta canalVenta) {
        super("empresa.venta.ventacreada");
        this.tipoVenta=tipoVenta;
        this.canalVenta=canalVenta;
    }

    public TipoVenta getTipoVenta() {
        return tipoVenta;
    }

    public CanalVenta getCanalVenta() {
        return canalVenta;
    }
}
