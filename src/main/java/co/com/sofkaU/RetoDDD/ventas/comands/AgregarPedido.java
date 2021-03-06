package co.com.sofkaU.RetoDDD.ventas.comands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkaU.RetoDDD.ventas.values.DescripcionPedido;
import co.com.sofkaU.RetoDDD.ventas.values.IdPedido;
import co.com.sofkaU.RetoDDD.ventas.values.IdVentas;
import co.com.sofkaU.RetoDDD.ventas.values.NombrePedido;

public class AgregarPedido extends Command {
    private final IdVentas idVentas;
    private final IdPedido entityId;
    private final NombrePedido nombrePedido;
    private final DescripcionPedido descripcionPedido;

    public AgregarPedido(IdVentas idVentas, IdPedido entityId, NombrePedido nombrePedido, DescripcionPedido descripcionPedido) {
        this.idVentas = idVentas;
        this.entityId = entityId;
        this.nombrePedido = nombrePedido;
        this.descripcionPedido = descripcionPedido;
    }

    public IdVentas getIdVentas() {
        return idVentas;
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
