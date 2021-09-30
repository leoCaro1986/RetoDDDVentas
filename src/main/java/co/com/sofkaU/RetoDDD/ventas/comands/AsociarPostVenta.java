package co.com.sofkaU.RetoDDD.ventas.comands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdPostVenta;

public class AsociarPostVenta extends Command {
    private  final IdPostVenta idPostVenta;
    public AsociarPostVenta(IdPostVenta idPostVenta) {
        this.idPostVenta=idPostVenta;
    }

    public IdPostVenta getIdPostVenta() {
        return idPostVenta;
    }
}
