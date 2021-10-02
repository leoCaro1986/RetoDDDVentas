package co.com.sofkaU.RetoDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.comands.AgregarAsesor;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.comands.AgregarOrdenDeServicio;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.events.AsesorAgregado;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.events.OrdenDeServicioAgregada;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.events.PostVentaCreada;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AgregarOrdenDeServicioUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Esta prueba valida que se agregue la orden de servicio")
    public  void agregarOrdenDeServicio(){

        var idPostVenta = IdPostVenta.of("yyyyyy");
        var idordenDeServicio = IdOrdenDeServicio.of("sssss");
        var descripcionOrdenDeServicio = new DescripcionOrdenDeServicio("por daños");
        var estadoOrdenDeServicio = new EstadoOrdenDeServicio("abierta");

        var command = new AgregarOrdenDeServicio(
                idPostVenta,
                idordenDeServicio,
                descripcionOrdenDeServicio,
                estadoOrdenDeServicio
        );
        var useCase= new AgregarOrdenDeServicioUseCase();

        Mockito.when(repository.getEventsBy(idPostVenta.value())).thenReturn(eventStored());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idPostVenta.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event =(OrdenDeServicioAgregada) events.get(0);
        Assertions.assertEquals("yyyyyy", event.aggregateRootId());
        Assertions.assertEquals("sssss", event.getEntityId().value());
        Assertions.assertEquals("por daños", event.getDescripcionOrdenDeServicio().value());
        Assertions.assertEquals("abierta", event.getEstadoOrdenDeServicio().value());
        Mockito.verify(repository).getEventsBy(idPostVenta.value());
    }

    private List<DomainEvent> eventStored() {
        return java.util.List.of(
                new PostVentaCreada( new FechaDeServicio("yyyyyy"))
        );
    }

}