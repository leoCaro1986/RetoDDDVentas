package co.com.sofkaU.RetoDDD.ventas.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdPostVenta;

public class PostVentaAsociada extends DomainEvent {
    private final IdPostVenta idPostVenta;

    public PostVentaAsociada(IdPostVenta idPostVenta) {
        super("empresa.venta.postventaasociada");
        this.idPostVenta = idPostVenta;
    }

    public IdPostVenta getIdPostVenta() {
        return idPostVenta;
    }
}
