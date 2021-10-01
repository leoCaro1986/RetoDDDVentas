package co.com.sofkaU.RetoDDD.atencionAlCLiente.values;

import co.com.sofka.domain.generic.Identity;

public class IdOrdenDeServicio extends Identity {
    public IdOrdenDeServicio() {
    }

    private IdOrdenDeServicio(String id){
        super(id);
    }
    public  static IdOrdenDeServicio of(String id){
        return new IdOrdenDeServicio(id);
    }
}
