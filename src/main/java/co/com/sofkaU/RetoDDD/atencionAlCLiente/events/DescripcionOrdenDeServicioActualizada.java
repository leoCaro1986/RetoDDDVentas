package co.com.sofkaU.RetoDDD.atencionAlCLiente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.DescripcionOrdenDeServicio;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdOrdenDeServicio;

public class DescripcionOrdenDeServicioActualizada extends DomainEvent {
    private final IdOrdenDeServicio entityId;
    private final DescripcionOrdenDeServicio descripcionOrdenDeServicio;
    public DescripcionOrdenDeServicioActualizada(IdOrdenDeServicio entityId, DescripcionOrdenDeServicio descripcionOrdenDeServicio) {
        super("empresa.postventa.descripcionordendeservicioactualizada");
        this.entityId=entityId;
        this.descripcionOrdenDeServicio=descripcionOrdenDeServicio;
    }

    public IdOrdenDeServicio getEntityId() {
        return entityId;
    }

    public DescripcionOrdenDeServicio getDescripcionOrdenDeServicio() {
        return descripcionOrdenDeServicio;
    }
}
