package co.com.sofkaU.RetoDDD.atencionAlCLiente.comands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdAsesor;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdPostVenta;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.TipoDeAsesoria;

public class ActualizarTipoDeAsesoria extends Command {
    private final IdPostVenta idPostVenta;
    private final IdAsesor idAsesor;
    private final TipoDeAsesoria tipoDeAsesoria;

    public ActualizarTipoDeAsesoria(IdPostVenta idPostVenta, IdAsesor idAsesor, TipoDeAsesoria tipoDeAsesoria) {
        this.idPostVenta = idPostVenta;
        this.idAsesor = idAsesor;
        this.tipoDeAsesoria = tipoDeAsesoria;
    }

    public IdPostVenta getIdPostVenta() {
        return idPostVenta;
    }

    public IdAsesor getIdAsesor() {
        return idAsesor;
    }

    public TipoDeAsesoria getTipoDeAsesoria() {
        return tipoDeAsesoria;
    }
}
