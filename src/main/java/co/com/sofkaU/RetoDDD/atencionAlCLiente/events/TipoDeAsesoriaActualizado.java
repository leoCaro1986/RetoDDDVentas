package co.com.sofkaU.RetoDDD.atencionAlCLiente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.EstadoOrdenDeServicio;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.TipoDeAsesoria;

import java.util.UUID;

public class TipoDeAsesoriaActualizado extends DomainEvent {
    private final TipoDeAsesoria tipoDeAsesoria;

    public TipoDeAsesoriaActualizado(TipoDeAsesoria tipoDeAsesoria) {
        super("empresa.postventa.tipodeasesoriaactualizado");
        this.tipoDeAsesoria = tipoDeAsesoria;
    }

    public TipoDeAsesoria getTipoDeAsesoria() {
        return tipoDeAsesoria;
    }
}
