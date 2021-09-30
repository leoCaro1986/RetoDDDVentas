package co.com.sofkaU.RetoDDD.atencionAlCLiente;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdAsesor;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.NombreAsesor;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.TipoDeAsesoria;

import java.util.Objects;

public class Asesor extends Entity<IdAsesor> {
    private final NombreAsesor nombreAsesor;
    private TipoDeAsesoria tipoDeAsesoria;

    public Asesor(IdAsesor entityId, NombreAsesor nombreAsesor, TipoDeAsesoria tipoDeAsesoria) {
        super(entityId);
        this.nombreAsesor=nombreAsesor;
        this.tipoDeAsesoria=tipoDeAsesoria;
    }

    public void actualizarTipoDeAsesoria(TipoDeAsesoria tipoDeAsesoria){
        this.tipoDeAsesoria = Objects.requireNonNull(tipoDeAsesoria);
    }

    public NombreAsesor nombreAsesor() {
        return nombreAsesor;
    }

    public TipoDeAsesoria tipoDeAsesoria() {
        return tipoDeAsesoria;
    }
}
