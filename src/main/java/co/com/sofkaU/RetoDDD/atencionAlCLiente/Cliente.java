package co.com.sofkaU.RetoDDD.atencionAlCLiente;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdCliente;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.MotivoPQR;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.NombreCliente;

import java.util.Objects;

public class Cliente extends Entity<IdCliente> {
    private NombreCliente nombreCliente;
    private MotivoPQR motivoPQR;

    public Cliente(IdCliente entityId, NombreCliente nombreCliente, MotivoPQR motivoPQR) {
        super(entityId);
        this.nombreCliente = nombreCliente;
        this.motivoPQR = motivoPQR;
    }

    public void actualizarNombreCliente(NombreCliente nombreCliente){
        this.nombreCliente = Objects.requireNonNull(nombreCliente);
    }

    public NombreCliente nombreCliente() {
        return nombreCliente;
    }

    public MotivoPQR motivoPQR() {
        return motivoPQR;
    }
}
