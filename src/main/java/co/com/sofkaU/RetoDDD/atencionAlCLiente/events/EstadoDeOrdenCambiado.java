package co.com.sofkaU.RetoDDD.atencionAlCLiente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.EstadoOrdenDeServicio;

import java.util.UUID;

public class EstadoDeOrdenCambiado extends DomainEvent {
    private final EstadoOrdenDeServicio estadoOrdenDeServicio;

    public EstadoDeOrdenCambiado( EstadoOrdenDeServicio estadoOrdenDeServicio) {
        super("empresa.postventa.estadodeordecambiado");
        this.estadoOrdenDeServicio = estadoOrdenDeServicio;
    }

    public EstadoOrdenDeServicio getEstadoOrdenDeServicio() {
        return estadoOrdenDeServicio;
    }
}
