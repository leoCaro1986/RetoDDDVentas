package co.com.sofkaU.RetoDDD.atencionAlCLiente.comands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdAsesor;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdPostVenta;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.NombreAsesor;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.TipoDeAsesoria;

public class AgregarAsesor extends Command {
    private final IdPostVenta idPostVenta;
    private final IdAsesor entityId;
    private final NombreAsesor nombreAsesor;
    private final TipoDeAsesoria tipoDeAsesoria;

    public AgregarAsesor(IdPostVenta idPostVenta, IdAsesor entityId, NombreAsesor nombreAsesor, TipoDeAsesoria tipoDeAsesoria) {
        this.idPostVenta = idPostVenta;
        this.entityId = entityId;
        this.nombreAsesor = nombreAsesor;
        this.tipoDeAsesoria = tipoDeAsesoria;
    }

    public IdPostVenta getIdPostVenta() {
        return idPostVenta;
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
