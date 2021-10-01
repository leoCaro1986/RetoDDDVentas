package co.com.sofkaU.RetoDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.ventas.comands.AgregarPedido;
import co.com.sofkaU.RetoDDD.ventas.comands.AgregarProducto;
import co.com.sofkaU.RetoDDD.ventas.events.PedidoAgregado;
import co.com.sofkaU.RetoDDD.ventas.events.ProductoAgregado;
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
class AgregarProductoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Esta prueba valida que se agregue un producto a una venta")
    void asociarProducto(){

        var idVenta = IdVentas.of("yyyyyy");
        var idProducto = IdProducto.of("jhjhkgjhg");
        var nombreProducto = new NombreProducto("camiseta");

        var command = new AgregarProducto(
                idVenta,
                idProducto,
                nombreProducto
        );
        var useCase= new AgregarProductoUseCase();

        Mockito.when(repository.getEventsBy(idVenta.value())).thenReturn(eventStored());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idVenta.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event =(ProductoAgregado) events.get(0);

        Assertions.assertEquals("yyyyyy", event.aggregateRootId());
        Assertions.assertEquals("jhjhkgjhg", event.getIdProducto().value());
        Assertions.assertEquals("camiseta", event.getNombreProducto().value());
        Mockito.verify(repository).getEventsBy(idVenta.value());
    }

    private List<DomainEvent> eventStored() {
        return java.util.List.of(
                new VentaCreada( new TipoVenta("yyyyyy"), new CanalVenta("Digital"))
        );
    }


}