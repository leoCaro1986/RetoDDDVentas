package co.com.sofkaU.RetoDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.comands.AgregarAsesor;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.events.AsesorAgregado;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.events.PostVentaCreada;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.*;
import co.com.sofkaU.RetoDDD.ventas.comands.AgregarProducto;
import co.com.sofkaU.RetoDDD.ventas.events.ProductoAgregado;
import co.com.sofkaU.RetoDDD.ventas.events.VentaCreada;
import co.com.sofkaU.RetoDDD.ventas.values.CanalVenta;
import co.com.sofkaU.RetoDDD.ventas.values.IdProducto;
import co.com.sofkaU.RetoDDD.ventas.values.IdVentas;
import co.com.sofkaU.RetoDDD.ventas.values.TipoVenta;
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
class AgregarAsesorUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Esta prueba valida que se agregue un asesor a un servicio de post venta")
    public void asociarAsesor(){

        var idPostVenta = IdPostVenta.of("yyyyyy");
        var idAsesor = IdAsesor.of("sssss");
        var nombreAsesor = new NombreAsesor("Leonardo");
        var tipoDeAsesoria = new TipoDeAsesoria("reclamos");

        var command = new AgregarAsesor(
                idPostVenta,
                idAsesor,
                nombreAsesor,
                tipoDeAsesoria
        );
                var useCase= new AgregarAsesorUseCase();

        Mockito.when(repository.getEventsBy(idPostVenta.value())).thenReturn(eventStored());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idPostVenta.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event =(AsesorAgregado) events.get(0);

        Assertions.assertEquals("yyyyyy", event.aggregateRootId());
        Assertions.assertEquals("sssss", event.getEntityId().value());
        Assertions.assertEquals("Leonardo", event.getNombreAsesor().value());
        Assertions.assertEquals("reclamos", event.getTipoDeAsesoria().value());
        Mockito.verify(repository).getEventsBy(idPostVenta.value());
    }

    private List<DomainEvent> eventStored() {
        return java.util.List.of(
                new PostVentaCreada( new FechaDeServicio("yyyyyy"))
        );
    }


}