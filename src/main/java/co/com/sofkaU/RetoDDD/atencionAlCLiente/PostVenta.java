package co.com.sofkaU.RetoDDD.atencionAlCLiente;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.events.*;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.*;
import co.com.sofkaU.RetoDDD.ventas.events.DescripcionDePedidoActualizado;

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
