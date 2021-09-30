package co.com.sofkaU.RetoDDD.ventas;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkaU.RetoDDD.ventas.values.DescripcionPedido;
import co.com.sofkaU.RetoDDD.ventas.values.IdPedido;
import co.com.sofkaU.RetoDDD.ventas.values.NombrePedido;

import java.util.Objects;

public class Pedido extends Entity<IdPedido> {
    private final NombrePedido nombrePedido;
    private DescripcionPedido descripcionPedido;

    public Pedido(IdPedido entityId, NombrePedido nombrePedido, DescripcionPedido descripcionPedido) {
        super(entityId);
        this.nombrePedido=nombrePedido;
        this.descripcionPedido=descripcionPedido;
    }


    public  void actualizarDescripcion(DescripcionPedido descripcionPedido){
        this.descripcionPedido = Objects.requireNonNull(descripcionPedido);
    }

    public NombrePedido nombrePedido() {

        return nombrePedido;
    }

    public DescripcionPedido descripcionPedido() {

        return descripcionPedido;
    }
}
