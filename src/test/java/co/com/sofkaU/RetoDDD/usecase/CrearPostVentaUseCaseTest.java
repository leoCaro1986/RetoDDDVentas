package co.com.sofkaU.RetoDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.comands.CrearPostVenta;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.events.PostVentaCreada;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.FechaDeServicio;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.values.IdPostVenta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CrearPostVentaUseCaseTest {

    @Test
    void CrearTestPorDefecto(){
        //arrange
        var command = new CrearPostVenta(
                IdPostVenta.of("sdfkjhñl"),
                new FechaDeServicio("10/05/2021")
        );
        var useCase =new CrearPostVentaUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (PostVentaCreada)events.get(0);
        Assertions.assertEquals("10/05/2021",event.getFechaDeServicio().value());

    }

}