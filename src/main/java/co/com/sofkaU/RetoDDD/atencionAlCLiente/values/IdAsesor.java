package co.com.sofkaU.RetoDDD.atencionAlCLiente.values;

import co.com.sofka.domain.generic.Identity;

public class IdAsesor extends Identity {
    public IdAsesor() {
    }

    private IdAsesor(String id){
        super(id);
    }
    public  static IdAsesor of(String id){
        return new IdAsesor(id);
    }

}
