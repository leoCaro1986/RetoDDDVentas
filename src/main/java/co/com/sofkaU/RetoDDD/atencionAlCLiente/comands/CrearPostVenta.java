package co.com.sofkaU.RetoDDD.atencionAlCLiente.comands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.FechaDeServicio;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdPostVenta;

public class CrearPostVenta extends Command {
    private final IdPostVenta idPostVenta;
    private final FechaDeServicio fechaDeServicio;

    public CrearPostVenta(IdPostVenta idPostVenta, FechaDeServicio fechaDeServicio) {
        this.idPostVenta = idPostVenta;
        this.fechaDeServicio = fechaDeServicio;
    }

    public IdPostVenta getIdPostVenta() {
        return idPostVenta;
    }

    public FechaDeServicio getFechaDeServicio() {
        return fechaDeServicio;
    }
}
