package co.com.sofkaU.RetoDDD.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.PostVenta;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.comands.CrearPostVenta;


public class CrearPostVentaUseCase extends UseCase<RequestCommand<CrearPostVenta>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearPostVenta> crearPostVentaRequestCommand) {
        var command = crearPostVentaRequestCommand.getCommand();
        PostVenta postVenta;

        postVenta = new PostVenta(
                command.getIdPostVenta(),
                command.getFechaDeServicio()
        );

        emit().onResponse(new ResponseEvents(postVenta.getUncommittedChanges()));
    }
}
