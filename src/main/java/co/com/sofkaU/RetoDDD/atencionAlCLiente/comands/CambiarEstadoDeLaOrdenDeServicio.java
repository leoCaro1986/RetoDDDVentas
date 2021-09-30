package co.com.sofkaU.RetoDDD.atencionAlCLiente.comands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.OrdenDeServicio;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdOrdenDeServicio;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdPostVenta;

public class CambiarEstadoDeLaOrdenDeServicio  extends Command {
    private final IdPostVenta idPostVenta;
    private final IdOrdenDeServicio idOrdenDeServicio;
    private final OrdenDeServicio ordenDeServicio;

    public CambiarEstadoDeLaOrdenDeServicio(IdPostVenta idPostVenta, IdOrdenDeServicio idOrdenDeServicio, OrdenDeServicio ordenDeServicio) {
        this.idPostVenta = idPostVenta;
        this.idOrdenDeServicio = idOrdenDeServicio;
        this.ordenDeServicio = ordenDeServicio;
    }

    public IdPostVenta getIdPostVenta() {
        return idPostVenta;
    }

    public IdOrdenDeServicio getIdOrdenDeServicio() {
        return idOrdenDeServicio;
    }

    public OrdenDeServicio getOrdenDeServicio() {
        return ordenDeServicio;
    }
}
