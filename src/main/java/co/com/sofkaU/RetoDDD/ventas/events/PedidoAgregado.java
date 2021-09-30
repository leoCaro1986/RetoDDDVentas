package co.com.sofkaU.RetoDDD.ventas.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.ventas.values.*;

public class PedidoAgregado extends DomainEvent {
    private final IdPedido idPedido;
    private final NombrePedido nombrePedido;
    private final DescripcionPedido descripcionPedido;

    public PedidoAgregado(IdPedido idPedido, NombrePedido nombrePedido, DescripcionPedido descripcionPedido) {
        super("empresa.venta.pedidoagregado");
        this.idPedido =idPedido;
        this.nombrePedido=nombrePedido;
        this.descripcionPedido=descripcionPedido;
    }

    public IdPedido getIdPedido() {

        return idPedido;
    }

    public NombrePedido getNombrePedido() {

        return nombrePedido;
    }

    public DescripcionPedido getDescripcionPedido() {

        return descripcionPedido;
    }
}
