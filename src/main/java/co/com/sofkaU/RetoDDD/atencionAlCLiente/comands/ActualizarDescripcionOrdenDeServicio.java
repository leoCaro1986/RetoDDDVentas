package co.com.sofkaU.RetoDDD.atencionAlCLiente.comands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.DescripcionOrdenDeServicio;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdOrdenDeServicio;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdPostVenta;

public class ActualizarDescripcionOrdenDeServicio extends Command {
    private  final IdPostVenta idPostVenta;
    private final IdOrdenDeServicio entityId;
    private final DescripcionOrdenDeServicio descripcionOrdenDeServicio;

    public ActualizarDescripcionOrdenDeServicio(IdPostVenta idPostVenta, IdOrdenDeServicio entityId, DescripcionOrdenDeServicio descripcionOrdenDeServicio) {
        this.idPostVenta = idPostVenta;
        this.entityId = entityId;
        this.descripcionOrdenDeServicio = descripcionOrdenDeServicio;
    }

    public IdPostVenta getIdPostVenta() {
        return idPostVenta;
    }

    public IdOrdenDeServicio getEntityId() {
        return entityId;
    }

    public DescripcionOrdenDeServicio getDescripcionOrdenDeServicio() {
        return descripcionOrdenDeServicio;
    }
}
