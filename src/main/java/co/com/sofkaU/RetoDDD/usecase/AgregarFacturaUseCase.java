package co.com.sofkaU.RetoDDD.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkaU.RetoDDD.ventas.Ventas;
import co.com.sofkaU.RetoDDD.ventas.comands.AgregarFactura;

public class AgregarFacturaUseCase extends UseCase<RequestCommand<AgregarFactura>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarFactura> agregarFacturaRequestCommand) {

        var command = agregarFacturaRequestCommand.getCommand();
        var ventas = Ventas.from(command.getIdVentas(), retrieveEvents());

        try {
            ventas.agregarFactura(command.getEntityId(), command.getFechaFactura(), command.getPrecio());
            emit().onResponse(new ResponseEvents(ventas.getUncommittedChanges()));
        }catch (RuntimeException e){
            emit().onError(new BusinessException(ventas.identity().value(), e.getMessage()));
        }

    }
}
