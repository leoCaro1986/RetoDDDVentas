package co.com.sofkaU.RetoDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkaU.RetoDDD.ventas.comands.CrearVenta;
import co.com.sofkaU.RetoDDD.ventas.events.VentaCreada;
import co.com.sofkaU.RetoDDD.ventas.values.CanalVenta;
import co.com.sofkaU.RetoDDD.ventas.values.IdVentas;
import co.com.sofkaU.RetoDDD.ventas.values.TipoVenta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CrearVentaUseCaseTest {

    @Test
    void crearVentaPorTipoVentaPorDefecto(){
    //arrange
        var command = new CrearVenta(
                IdVentas.of("1234fdsajhf"),
                new CanalVenta("efectivo"),
                new TipoVenta("leonar")

        );
        var useCase = new CrearVentaUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert

        var event = (VentaCreada)events.get(0);
        Assertions.assertEquals("efectivo", event.getCanalVenta().value());
        Assertions.assertEquals("digital", event.getTipoVenta().value());
    }

    @Test
    void crearCasoExplicito(){

        var command = new CrearVenta(
                IdVentas.of("12345tryod"),
                new CanalVenta("efectivo"),
                new TipoVenta("digital")
        );
        var useCase = new CrearVentaUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (VentaCreada)events.get(0);
        Assertions.assertEquals("efectivo", event.getCanalVenta().value());
        Assertions.assertEquals("digital", event.getTipoVenta().value());

    }

}