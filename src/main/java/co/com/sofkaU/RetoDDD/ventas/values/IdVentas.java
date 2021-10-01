package co.com.sofkaU.RetoDDD.ventas.values;

import co.com.sofka.domain.generic.Identity;

public class IdVentas extends Identity {

    public IdVentas() {
    }

    private IdVentas(String id){
        super(id);
    }
    public  static  IdVentas of(String id){
        return new IdVentas(id);
    }
}
