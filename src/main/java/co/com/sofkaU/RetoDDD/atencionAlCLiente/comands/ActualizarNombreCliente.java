package co.com.sofkaU.RetoDDD.atencionAlCLiente.comands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdCliente;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdPostVenta;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.NombreCliente;

public class ActualizarNombreCliente extends Command {
    private final IdPostVenta idPostVenta;
    private final IdCliente idCliente;
    private final NombreCliente nombreCliente;

    public ActualizarNombreCliente(IdPostVenta idPostVenta, IdCliente idCliente, NombreCliente nombreCliente) {
        this.idPostVenta = idPostVenta;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
    }

    public IdPostVenta getIdPostVenta() {
        return idPostVenta;
    }

    public IdCliente getIdCliente() {
        return idCliente;
    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }
}
