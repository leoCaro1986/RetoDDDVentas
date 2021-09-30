package co.com.sofkaU.RetoDDD.atencionAlCLiente;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.DescripcionOrdenDeServicio;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.EstadoOrdenDeServicio;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdOrdenDeServicio;

import java.util.Objects;

public class OrdenDeServicio extends Entity<IdOrdenDeServicio> {
    private DescripcionOrdenDeServicio descripcionOrdenDeServicio;
    private EstadoOrdenDeServicio estadoOrdenDeServicio;

    public OrdenDeServicio(IdOrdenDeServicio entityId, DescripcionOrdenDeServicio descripcionOrdenDeServicio, EstadoOrdenDeServicio estadoOrdenDeServicio) {
        super(entityId);
        this.descripcionOrdenDeServicio = descripcionOrdenDeServicio;
        this.estadoOrdenDeServicio = estadoOrdenDeServicio;
    }

    public  void cambiarEstadoDeLaOrdenDeServicio(EstadoOrdenDeServicio estadoOrdenDeServicio){
        this.estadoOrdenDeServicio = Objects.requireNonNull(estadoOrdenDeServicio);
    }

    public DescripcionOrdenDeServicio descripcionOrdenDeServicio(){
        return descripcionOrdenDeServicio;
    }

    public EstadoOrdenDeServicio estadoOrdenDeServicio() {
        return estadoOrdenDeServicio;
    }
}
