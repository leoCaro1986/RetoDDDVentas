package co.com.sofkaU.RetoDDD.atencionAlCLiente.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofkaU.RetoDDD.ventas.values.IdFactura;

public class IdPostVenta extends Identity {
    public IdPostVenta() {
    }

    private IdPostVenta(String id){
        super(id);
    }
    public  static IdPostVenta of(String id){
        return new IdPostVenta(id);
    }
}
