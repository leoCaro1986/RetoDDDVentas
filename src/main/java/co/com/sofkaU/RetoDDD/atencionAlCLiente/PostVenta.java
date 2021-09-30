package co.com.sofkaU.RetoDDD.atencionAlCLiente;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.events.PostVentaCreada;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.FechaDeServicio;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdPostVenta;

public class PostVenta extends AggregateEvent<IdPostVenta> {
    protected FechaDeServicio fechaDeServicio;
    protected Asesor asesor;
    protected OrdenDeServicio ordenDeServicio;
    protected Cliente cliente;

    public PostVenta(IdPostVenta entityId, FechaDeServicio fechaDeServicio) {
        super(entityId);
        appendChange(new PostVentaCreada(fechaDeServicio)).apply();
    }



}
