package co.com.sofkaU.RetoDDD.atencionAlCLiente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdCliente;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.NombreCliente;

import java.util.UUID;

public class NombreClienteActualizado extends DomainEvent {

    private final NombreCliente nombreCliente;

    public NombreClienteActualizado(NombreCliente nombreCliente) {
        super("empresa.postventa.nombreclienteactualizado");
                this.nombreCliente = nombreCliente;
    }

    public NombreCliente getNombreCliente() {

        return nombreCliente;
    }
}
