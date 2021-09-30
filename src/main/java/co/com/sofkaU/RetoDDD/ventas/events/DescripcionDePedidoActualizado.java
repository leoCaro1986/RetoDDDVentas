package co.com.sofkaU.RetoDDD.ventas.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.ventas.values.DescripcionPedido;
import co.com.sofkaU.RetoDDD.ventas.values.IdPedido;

import java.util.UUID;

public class DescripcionDePedidoActualizado extends DomainEvent {
    private final IdPedido entityId;
    private final DescripcionPedido descripcionPedido;

    public DescripcionDePedidoActualizado(IdPedido entityId, DescripcionPedido descripcionPedido) {
        super("empresa.venta.descripciondepedidoactualizado");
        this.entityId=entityId;
        this.descripcionPedido=descripcionPedido;
    }

    public IdPedido getEntityId() {
        return entityId;
    }

    public DescripcionPedido getDescripcionPedido() {
        return descripcionPedido;
    }
}
