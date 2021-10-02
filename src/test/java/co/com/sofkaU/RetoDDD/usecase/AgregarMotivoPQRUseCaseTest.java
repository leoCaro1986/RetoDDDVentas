package co.com.sofkaU.RetoDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.comands.AgregarAsesor;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.comands.AgregarMotivoPQR;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.events.AsesorAgregado;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.events.MotivoPQRAgregado;
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
class AgregarMotivoPQRUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Esta prueba valida que se agregue el motivo del PQR")
    public void agregarMotivoPQR(){
        var idPostVenta = IdPostVenta.of("yyyyyy");
        var idMotivoPQR = IdCliente.of("sssss");
        var nombreCliente = new NombreCliente("Leonardo");
        var motivoPQR = new MotivoPQR("reclamo");

        var command = new AgregarMotivoPQR(
                idPostVenta,
                idMotivoPQR,
                nombreCliente,
                motivoPQR
        );
        var useCase= new AgregarMotivoPQRUseCase();

        Mockito.when(repository.getEventsBy(idPostVenta.value())).thenReturn(eventStored());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idPostVenta.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event =(MotivoPQRAgregado) events.get(0);

        Assertions.assertEquals("yyyyyy", event.aggregateRootId());
        Assertions.assertEquals("sssss", event.getEntityId().value());
        Assertions.assertEquals("Leonardo", event.getNombreCliente().value());
        Assertions.assertEquals("reclamo", event.getMotivoPQR().value());
        Mockito.verify(repository).getEventsBy(idPostVenta.value());
    }

    private List<DomainEvent> eventStored() {
        return java.util.List.of(
                new PostVentaCreada( new FechaDeServicio("yyyyyy"))
        );
    }

}