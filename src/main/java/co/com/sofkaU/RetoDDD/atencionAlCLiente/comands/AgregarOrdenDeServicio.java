package co.com.sofkaU.RetoDDD.atencionAlCLiente.comands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.DescripcionOrdenDeServicio;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.EstadoOrdenDeServicio;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdOrdenDeServicio;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdPostVenta;

public class AgregarOrdenDeServicio extends Command {
    private final IdPostVenta idPostVenta;
    private final IdOrdenDeServicio entityId;
    private final DescripcionOrdenDeServicio descripcionOrdenDeServicio;
    private final EstadoOrdenDeServicio estadoOrdenDeServicio;

    public AgregarOrdenDeServicio(IdPostVenta idPostVenta, IdOrdenDeServicio entityId, DescripcionOrdenDeServicio descripcionOrdenDeServicio, EstadoOrdenDeServicio estadoOrdenDeServicio) {
        this.idPostVenta = idPostVenta;
        this.entityId = entityId;
        this.descripcionOrdenDeServicio = descripcionOrdenDeServicio;
        this.estadoOrdenDeServicio = estadoOrdenDeServicio;
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

    public EstadoOrdenDeServicio getEstadoOrdenDeServicio() {
        return estadoOrdenDeServicio;
    }
}
