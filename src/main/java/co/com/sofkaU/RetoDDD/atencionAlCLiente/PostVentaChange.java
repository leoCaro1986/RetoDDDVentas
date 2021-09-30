package co.com.sofkaU.RetoDDD.atencionAlCLiente;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.events.*;

public class PostVentaChange extends EventChange {
    public PostVentaChange(PostVenta postVenta) {


        apply((PostVentaCreada event)->{
            postVenta.fechaDeServicio = event.getFechaDeServicio();
        });

        apply((OrdenDeServicioAgregada event)->{
            postVenta.ordenDeServicio = new OrdenDeServicio(event.getEntityId(), event.getDescripcionOrdenDeServicio(), event.getEstadoOrdenDeServicio());
        });

        apply((AsesorAgregado event)->{
            postVenta.asesor =new Asesor(event.getEntityId(), event.getNombreAsesor(), event.getTipoDeAsesoria());
        });

        apply((MotivoPQRAgregado event)->{
            postVenta.cliente = new Cliente(event.getEntityId(), event.getNombreCliente(), event.getMotivoPQR());
        });

        apply((DescripcionOrdenDeServicioActualizada event)->{
            postVenta.ordenDeServicio.descripcionOrdenDeServicio();
        });

        apply((NombreClienteActualizado event)->{
            postVenta.cliente.actualizarNombreCliente(event.getNombreCliente());
        });

        apply((EstadoDeOrdenCambiado event)->{
            postVenta.ordenDeServicio.cambiarEstadoDeLaOrdenDeServicio(event.getEstadoOrdenDeServicio());
        });

        apply((TipoDeAsesoriaActualizado event)->{
            postVenta.asesor.actualizarTipoDeAsesoria(event.getTipoDeAsesoria());
        });

    }
}
