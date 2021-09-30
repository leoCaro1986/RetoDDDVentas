package co.com.sofkaU.RetoDDD.atencionAlCLiente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdCliente;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.MotivoPQR;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.NombreCliente;

public class MotivoPQRAgregado extends DomainEvent {
    private final IdCliente entityId;
    private final NombreCliente nombreCliente;
    private final MotivoPQR motivoPQR;
    public MotivoPQRAgregado(IdCliente entityId, NombreCliente nombreCliente, MotivoPQR motivoPQR) {
        super("empresa.postventa.motivopqragregado");
        this.entityId=entityId;
        this.nombreCliente=nombreCliente;
        this.motivoPQR=motivoPQR;
    }

    public IdCliente getEntityId() {
        return entityId;
    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }

    public MotivoPQR getMotivoPQR() {
        return motivoPQR;
    }
}
