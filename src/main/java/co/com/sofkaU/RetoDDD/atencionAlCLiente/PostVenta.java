package co.com.sofkaU.RetoDDD.atencionAlCLiente;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.events.*;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.*;

import java.util.List;
import java.util.Objects;

public class PostVenta extends AggregateEvent<IdPostVenta> {
    protected FechaDeServicio fechaDeServicio;
    protected Asesor asesor;
    protected OrdenDeServicio ordenDeServicio;
    protected Cliente cliente;

    public PostVenta(IdPostVenta entityId, FechaDeServicio fechaDeServicio) {
        super(entityId);
        appendChange(new PostVentaCreada(fechaDeServicio)).apply();
    }

    private PostVenta(IdPostVenta entityId){
        super(entityId);
        subscribe(new PostVentaChange(this));
    }


    public static PostVenta from(IdPostVenta idPostVenta, List<DomainEvent> events){
        var postVenta = new PostVenta(idPostVenta);
        events.forEach(postVenta::applyEvent);
        return postVenta;
    }


    public void agregarOrdenDeServicio(IdOrdenDeServicio entityId, DescripcionOrdenDeServicio descripcionOrdenDeServicio, EstadoOrdenDeServicio estadoOrdenDeServicio){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(descripcionOrdenDeServicio);
        Objects.requireNonNull(estadoOrdenDeServicio);
        appendChange(new OrdenDeServicioAgregada(entityId, descripcionOrdenDeServicio, estadoOrdenDeServicio)).apply();
    }

    public void agregarAsesor(IdAsesor entityId, NombreAsesor nombreAsesor, TipoDeAsesoria tipoDeAsesoria){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombreAsesor);
        Objects.requireNonNull(tipoDeAsesoria);
        appendChange(new AsesorAgregado(entityId, nombreAsesor, tipoDeAsesoria)).apply();
    }

    public void agregarMotivoPQR(IdCliente entityId, NombreCliente nombreCliente, MotivoPQR motivoPQR){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombreCliente);
        Objects.requireNonNull(motivoPQR);
        appendChange(new MotivoPQRAgregado(entityId, nombreCliente, motivoPQR)).apply();
    }

    public void actualizarDescripcionOrdenDeServicio(IdOrdenDeServicio entityId, DescripcionOrdenDeServicio descripcionOrdenDeServicio){
        appendChange(new DescripcionOrdenDeServicioActualizada(entityId, descripcionOrdenDeServicio)).apply();
    }

    public void actualizarNombreCliente(NombreCliente nombreCliente){
        appendChange(new NombreClienteActualizado(nombreCliente)).apply();
    }

    public void cambiarEstadoDeLaOrdenDeServicio(EstadoOrdenDeServicio estadoOrdenDeServicio){
        appendChange(new EstadoDeOrdenCambiado(estadoOrdenDeServicio)).apply();
    }

    public void actualizarTipoDeAsesoria(TipoDeAsesoria tipoDeAsesoria){
        appendChange(new TipoDeAsesoriaActualizado(tipoDeAsesoria)).apply();
    }




    public FechaDeServicio fechaDeServicio(){
        return fechaDeServicio;
    }

    public Asesor asesor(){
        return asesor;
    }

    public OrdenDeServicio ordenDeServicio(){
        return ordenDeServicio;
    }

    public Cliente cliente(){
        return cliente;
    }



}
