package co.com.sofkaU.RetoDDD.ventas.comands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkaU.RetoDDD.ventas.values.IdFactura;
import co.com.sofkaU.RetoDDD.ventas.values.IdVentas;
import co.com.sofkaU.RetoDDD.ventas.values.Precio;

public class ActualizarPrecio extends Command {
    private final IdVentas idVentas;
    private final IdFactura idFactura;
    private final Precio precio;

    public ActualizarPrecio(IdVentas idVentas, IdFactura idFactura, Precio precio) {
        this.idVentas = idVentas;
        this.idFactura = idFactura;
        this.precio = precio;
    }

    public IdVentas getIdVentas() {
        return idVentas;
    }

    public IdFactura getIdFactura() {
        return idFactura;
    }

    public Precio getPrecio() {
        return precio;
    }
}
