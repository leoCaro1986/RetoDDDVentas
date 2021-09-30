package co.com.sofkaU.RetoDDD.atencionAlCLiente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.FechaDeServicio;

import java.util.UUID;

public class PostVentaCreada extends DomainEvent {
    private final FechaDeServicio fechaDeServicio;
    public PostVentaCreada(FechaDeServicio fechaDeServicio) {
        super("empresa.postventa.postventacreada");
        this.fechaDeServicio=fechaDeServicio;
    }

    public FechaDeServicio getFechaDeServicio() {
        return fechaDeServicio;
    }
}
