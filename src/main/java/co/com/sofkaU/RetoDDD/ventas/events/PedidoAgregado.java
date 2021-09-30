package co.com.sofkaU.RetoDDD.ventas.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.ventas.values.*;

public class PedidoAgregado extends DomainEvent {
    private final IdPedido entityId;
    private final NombrePedido nombrePedido;
    private final DescripcionPedido descripcionPedido;

    public PedidoAgregado(IdPedido entityId, NombrePedido nombrePedido, DescripcionPedido descripcionPedido) {
        super("empresa.venta.pedidoagregado");
        this.entityId=entityId;
        this.nombrePedido=nombrePedido;
        this.descripcionPedido=descripcionPedido;
    }

    public IdPedido getEntityId() {
        return entityId;
    }

    public NombrePedido getNombrePedido() {
        return nombrePedido;
    }

    public DescripcionPedido getDescripcionPedido() {
        return descripcionPedido;
    }
}
