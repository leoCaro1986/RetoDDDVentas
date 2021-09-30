package co.com.sofkaU.RetoDDD.atencionAlCLiente.comands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdCliente;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdPostVenta;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.MotivoPQR;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.NombreCliente;

public class AgregarMotivoPQR extends Command {
    private final IdPostVenta idPostVenta;
    private final IdCliente entityId;
    private final NombreCliente nombreCliente;
    private final MotivoPQR motivoPQR;

    public AgregarMotivoPQR(IdPostVenta idPostVenta, IdCliente entityId, NombreCliente nombreCliente, MotivoPQR motivoPQR) {
        this.idPostVenta = idPostVenta;
        this.entityId = entityId;
        this.nombreCliente = nombreCliente;
        this.motivoPQR = motivoPQR;
    }

    public IdPostVenta getIdPostVenta() {
        return idPostVenta;
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

