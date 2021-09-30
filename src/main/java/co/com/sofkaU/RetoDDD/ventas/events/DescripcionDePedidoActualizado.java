package co.com.sofkaU.RetoDDD.ventas.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.ventas.values.DescripcionPedido;
import co.com.sofkaU.RetoDDD.ventas.values.IdPedido;

public class DescripcionDePedidoActualizado extends DomainEvent {
    private final IdPedido idPedido1;
    private final DescripcionPedido descripcionPedido;

    public DescripcionDePedidoActualizado(IdPedido idPedido1, DescripcionPedido descripcionPedido) {
        super("empresa.venta.descripciondepedidoactualizado");
        this.idPedido1 =idPedido1;
        this.descripcionPedido=descripcionPedido;
    }

    public IdPedido getIdPedido1() {
        return idPedido1;
    }

    public DescripcionPedido getDescripcionPedido() {
        return descripcionPedido;
    }
}
