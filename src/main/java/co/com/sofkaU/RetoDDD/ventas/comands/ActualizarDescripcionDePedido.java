package co.com.sofkaU.RetoDDD.ventas.comands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkaU.RetoDDD.ventas.values.DescripcionPedido;
import co.com.sofkaU.RetoDDD.ventas.values.IdPedido;
import co.com.sofkaU.RetoDDD.ventas.values.IdVentas;

public class ActualizarDescripcionDePedido extends Command {
    private final IdVentas idVentas;
    private final IdPedido entityId;
    private final DescripcionPedido descripcionPedido;

    public ActualizarDescripcionDePedido(IdVentas idVentas, IdPedido entityId, DescripcionPedido descripcionPedido) {
        this.idVentas = idVentas;
        this.entityId = entityId;
        this.descripcionPedido = descripcionPedido;
    }

    public IdVentas getIdVentas() {
        return idVentas;
    }

    public IdPedido getEntityId() {
        return entityId;
    }

    public DescripcionPedido getDescripcionPedido() {
        return descripcionPedido;
    }
}
