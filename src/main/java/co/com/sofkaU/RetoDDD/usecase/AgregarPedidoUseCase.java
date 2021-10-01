package co.com.sofkaU.RetoDDD.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkaU.RetoDDD.ventas.Ventas;
import co.com.sofkaU.RetoDDD.ventas.comands.AgregarFactura;
import co.com.sofkaU.RetoDDD.ventas.comands.AgregarPedido;

public class AgregarPedidoUseCase extends UseCase<RequestCommand<AgregarPedido>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarPedido> agregarPedidoRequestCommand) {

        var command = agregarPedidoRequestCommand.getCommand();
        var ventas = Ventas.from(command.getIdVentas(), retrieveEvents());

        try {
            ventas.agregarPedido(command.getEntityId(), command.getNombrePedido(), command.getDescripcionPedido());
            emit().onResponse(new ResponseEvents(ventas.getUncommittedChanges()));
        }catch (RuntimeException e){
            emit().onError(new BusinessException(ventas.identity().value(), e.getMessage()));
        }
    }
}
