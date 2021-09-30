package co.com.sofkaU.RetoDDD.ventas.comands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkaU.RetoDDD.ventas.values.IdProducto;
import co.com.sofkaU.RetoDDD.ventas.values.IdVentas;
import co.com.sofkaU.RetoDDD.ventas.values.NombreProducto;

public class ActualizarNombreDeProducto extends Command {
    private final IdVentas idVentas;
    private final IdProducto idProducto;
    private final NombreProducto nombreProducto;

    public ActualizarNombreDeProducto(IdVentas idVentas, IdProducto idProducto, NombreProducto nombreProducto) {
        this.idVentas = idVentas;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
    }

    public IdVentas getIdVentas() {
        return idVentas;
    }

    public IdProducto getIdProducto() {
        return idProducto;
    }

    public NombreProducto getNombreProducto() {
        return nombreProducto;
    }
}
