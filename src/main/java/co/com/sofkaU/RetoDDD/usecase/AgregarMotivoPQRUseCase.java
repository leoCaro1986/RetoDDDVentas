package co.com.sofkaU.RetoDDD.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.PostVenta;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.comands.AgregarAsesor;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.comands.AgregarMotivoPQR;

public class AgregarMotivoPQRUseCase extends UseCase<RequestCommand<AgregarMotivoPQR>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarMotivoPQR> agregarMotivoPQRRequestCommand) {
        var command = agregarMotivoPQRRequestCommand.getCommand();
        var postVenta = PostVenta.from(command.getIdPostVenta(), retrieveEvents());

        try {
            postVenta.agregarMotivoPQR(command.getEntityId(), command.getNombreCliente(), command.getMotivoPQR());
            emit().onResponse(new ResponseEvents(postVenta.getUncommittedChanges()));
        }catch (RuntimeException e){
            emit().onError(new BusinessException(postVenta.identity().value(), e.getMessage()));
        }
    }
}
