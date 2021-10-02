package co.com.sofkaU.RetoDDD.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.PostVenta;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.comands.AgregarAsesor;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.comands.AgregarOrdenDeServicio;

public class AgregarOrdenDeServicioUseCase extends UseCase<RequestCommand<AgregarOrdenDeServicio>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarOrdenDeServicio> agregarOrdenDeServicioRequestCommand) {

        var command = agregarOrdenDeServicioRequestCommand.getCommand();
        var postVenta = PostVenta.from(command.getIdPostVenta(), retrieveEvents());

        try {
            postVenta.agregarOrdenDeServicio(command.getEntityId(), command.getDescripcionOrdenDeServicio(), command.getEstadoOrdenDeServicio());
            emit().onResponse(new ResponseEvents(postVenta.getUncommittedChanges()));
        }catch (RuntimeException e){
            emit().onError(new BusinessException(postVenta.identity().value(), e.getMessage()));
        }
    }
}
