package co.com.sofkaU.RetoDDD.atencionAlCLiente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.DescripcionOrdenDeServicio;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.EstadoOrdenDeServicio;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdOrdenDeServicio;

public class OrdenDeServicioAgregada  extends DomainEvent {
    private final IdOrdenDeServicio entityId;
    private final DescripcionOrdenDeServicio descripcionOrdenDeServicio;
    private final EstadoOrdenDeServicio estadoOrdenDeServicio;

    public OrdenDeServicioAgregada(IdOrdenDeServicio entityId, DescripcionOrdenDeServicio descripcionOrdenDeServicio, EstadoOrdenDeServicio estadoOrdenDeServicio) {
        super("empresa.postventa.ordendeservicioagregada");
        this.entityId=entityId;
        this.descripcionOrdenDeServicio=descripcionOrdenDeServicio;
        this.estadoOrdenDeServicio=estadoOrdenDeServicio;
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

