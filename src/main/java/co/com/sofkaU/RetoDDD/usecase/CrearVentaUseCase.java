package co.com.sofkaU.RetoDDD.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkaU.RetoDDD.ventas.Ventas;
import co.com.sofkaU.RetoDDD.ventas.comands.CrearVenta;
import co.com.sofkaU.RetoDDD.ventas.values.TipoVenta;


public class CrearVentaUseCase extends UseCase<RequestCommand<CrearVenta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearVenta> crearVentaRequestCommand) {
        var command = crearVentaRequestCommand.getCommand();
        Ventas ventas;

        if(command.getTipoVenta().value() == "leonar"){
            ventas = new Ventas(
                    command.getEntityId(),
                    command.getCanalVenta(),
                    new TipoVenta("digital")
            );

        }else {
            ventas = new Ventas(
                    command.getEntityId(),
                    command.getCanalVenta(),
                    command.getTipoVenta()
            );
        }


        emit().onResponse(new ResponseEvents(ventas.getUncommittedChanges()));
    }
}
