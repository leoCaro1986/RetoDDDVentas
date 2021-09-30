package co.com.sofkaU.RetoDDD.atencionAlCLiente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdAsesor;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.NombreAsesor;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.TipoDeAsesoria;

public class AsesorAgregado extends DomainEvent {
    private final IdAsesor entityId;
    private final NombreAsesor nombreAsesor;
    private final TipoDeAsesoria tipoDeAsesoria;
    public AsesorAgregado(IdAsesor entityId, NombreAsesor nombreAsesor, TipoDeAsesoria tipoDeAsesoria) {
        super("empresa.postventa.asesoragregado");
        this.entityId=entityId;
        this.nombreAsesor=nombreAsesor;
        this.tipoDeAsesoria=tipoDeAsesoria;
    }

    public IdAsesor getEntityId() {
        return entityId;
    }

    public NombreAsesor getNombreAsesor() {
        return nombreAsesor;
    }

    public TipoDeAsesoria getTipoDeAsesoria() {
        return tipoDeAsesoria;
    }
}
