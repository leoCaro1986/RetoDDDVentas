package co.com.sofkaU.RetoDDD.ventas;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkaU.RetoDDD.ventas.values.IdProducto;
import co.com.sofkaU.RetoDDD.ventas.values.NombreProducto;

import java.util.Objects;

public class Producto extends Entity<IdProducto> {
    private NombreProducto nombreProducto;

    public Producto(IdProducto idProducto, NombreProducto nombreProducto) {
        super(idProducto);
        this.nombreProducto=nombreProducto;
    }

    public  void actualizarNombreProducto(NombreProducto nombreProducto){
        this.nombreProducto= Objects.requireNonNull(nombreProducto);
    }

    public NombreProducto nombreProducto() {
        return nombreProducto;
    }
}
