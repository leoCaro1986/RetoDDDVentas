package co.com.sofkaU.RetoDDD.ventas.values;

import co.com.sofka.domain.generic.Identity;

public class IdProducto extends Identity {
    public IdProducto() {
    }

    private IdProducto(String id){
        super(id);
    }
    public  static  IdProducto of(String id){
        return new IdProducto(id);
    }
}
