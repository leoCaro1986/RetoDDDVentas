package co.com.sofkaU.RetoDDD.ventas.values;

import co.com.sofka.domain.generic.Identity;

public class IdFactura extends Identity {
    public IdFactura() {
    }

    private IdFactura(String id){
        super(id);
    }
    public  static  IdFactura of(String id){
        return new IdFactura(id);
    }
}
