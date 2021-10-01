package co.com.sofkaU.RetoDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.ventas.comands.AgregarFactura;
import co.com.sofkaU.RetoDDD.ventas.comands.AgregarPedido;
import co.com.sofkaU.RetoDDD.ventas.events.FacturaAgregada;
import co.com.sofkaU.RetoDDD.ventas.events.PedidoAgregado;
import co.com.sofkaU.RetoDDD.ventas.events.VentaCreada;
import co.com.sofkaU.RetoDDD.ventas.values.*;
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
class AgregarPedidoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Esta prueba valida que se agregue un pedido a una venta")
    void  asociarPedido(){

        var idVenta = IdVentas.of("yyyyyy");
        var idPedido = IdPedido.of("xxxx");
        var nombrePedido = new NombrePedido("pedido1");
        var descripcionPedido = new DescripcionPedido("Este");

        var command = new AgregarPedido(
                idVenta,
                idPedido,
                nombrePedido,
                descripcionPedido
        );

        var useCase= new AgregarPedidoUseCase();

        Mockito.when(repository.getEventsBy(idVenta.value())).thenReturn(eventStored());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idVenta.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents() ;

        var event =(PedidoAgregado) events.get(0);

        Assertions.assertEquals("yyyyyy", event.aggregateRootId());
        Assertions.assertEquals("xxxx", event.getIdPedido().value());
        Assertions.assertEquals("pedido1", event.getNombrePedido().value());
        Assertions.assertEquals("Este", event.getDescripcionPedido().value());
        Mockito.verify(repository).getEventsBy(idVenta.value());
    }

    private List<DomainEvent> eventStored(){
        return java.util.List.of(
                new VentaCreada( new TipoVenta("yyyyyy"), new CanalVenta("Digital"))
        );

    }
}