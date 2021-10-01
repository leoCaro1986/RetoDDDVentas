package co.com.sofkaU.RetoDDD.ventas.values;

import co.com.sofka.domain.generic.Identity;

public class IdPedido extends Identity {
    public IdPedido() {
    }

    private IdPedido(String id){
        super(id);
    }
    public  static  IdPedido of(String id){
        return new IdPedido(id);
    }
}
