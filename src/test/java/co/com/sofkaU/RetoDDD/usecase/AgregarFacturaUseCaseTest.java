package co.com.sofkaU.RetoDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.ventas.Factura;
import co.com.sofkaU.RetoDDD.ventas.Ventas;
import co.com.sofkaU.RetoDDD.ventas.comands.AgregarFactura;
import co.com.sofkaU.RetoDDD.ventas.events.FacturaAgregada;
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
class AgregarFacturaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Validar que se egregue una factura a una venta")
    void asociarFactura(){

                var idVenta = IdVentas.of("yyyyyy");
                var idFactura = IdFactura.of("xxxx");
                var fechaFactura = new FechaFactura("01/10/2021");
                var precio = new Precio(50.000);


                var command = new AgregarFactura(
                        idVenta,
                        idFactura,
                        fechaFactura,
                        precio
                );

                var useCase= new AgregarFacturaUseCase();

        Mockito.when(repository.getEventsBy(idVenta.value())).thenReturn(eventStored());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idVenta.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents() ;

        var event = (FacturaAgregada) events.get(0);

        Assertions.assertEquals("yyyyyy", event.aggregateRootId());
        Assertions.assertEquals("xxxx", event.getIdFactura().value());
        Assertions.assertEquals("01/10/2021", event.getFechaFactura().value());
        Assertions.assertEquals(50.000, event.getPrecio().value());
        Mockito.verify(repository).getEventsBy(idVenta.value());
    }

    private List<DomainEvent> eventStored(){
        return List.of(
                new VentaCreada( new TipoVenta("yyyyyy"), new CanalVenta("kldsgfjg"))
        );

    }


}