package co.com.sofkaU.RetoDDD.ventas;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkaU.RetoDDD.ventas.values.FechaFactura;
import co.com.sofkaU.RetoDDD.ventas.values.IdFactura;
import co.com.sofkaU.RetoDDD.ventas.values.Precio;

import java.util.Objects;

public class Factura extends Entity<IdFactura> {
    private final FechaFactura fechaFactura;
    private Precio precio;

    public Factura(IdFactura idFactura, FechaFactura fechaFactura, Precio precio) {
        super(idFactura);
        this.fechaFactura=fechaFactura;
        this.precio=precio;
    }


    public void actualizarPrecio(Precio precio){

        this.precio= Objects.requireNonNull(precio);
    }


    public FechaFactura fechaFactura() {

        return fechaFactura;
    }

    public Precio precio() {

        return precio;
    }
}
