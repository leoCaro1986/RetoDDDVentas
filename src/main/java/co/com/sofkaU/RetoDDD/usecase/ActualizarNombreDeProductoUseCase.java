package co.com.sofkaU.RetoDDD.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkaU.RetoDDD.ventas.Ventas;
import co.com.sofkaU.RetoDDD.ventas.comands.ActualizarNombreDeProducto;

public class ActualizarNombreDeProductoUseCase extends UseCase<RequestCommand<ActualizarNombreDeProducto>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreDeProducto> actualizarNombreDeProductoRequestCommand) {
        var command = actualizarNombreDeProductoRequestCommand.getCommand();
        var ventas = Ventas.from(command.getIdVentas(), retrieveEvents());

        try {
            ventas.actualizarNombreDeProducto(command.getIdProducto(), command.getNombreProducto());
            emit().onResponse(new ResponseEvents(ventas.getUncommittedChanges()));
        }catch (RuntimeException e){
            emit().onError(new BusinessException(ventas.identity().value(), e.getMessage()));
        }
    }
}
