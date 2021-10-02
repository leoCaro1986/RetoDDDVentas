package co.com.sofkaU.RetoDDD.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.PostVenta;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.comands.AgregarAsesor;
import co.com.sofkaU.RetoDDD.atencionAlCLiente.events.AsesorAgregado;
import co.com.sofkaU.RetoDDD.ventas.Ventas;
import co.com.sofkaU.RetoDDD.ventas.comands.AgregarPedido;

public class AgregarAsesorUseCase extends UseCase<RequestCommand<AgregarAsesor>, ResponseEvents> {


        @Override
        public void executeUseCase(RequestCommand<AgregarAsesor> agregarAsesorRequestCommand) {

            var command = agregarAsesorRequestCommand.getCommand();
            var postVenta = PostVenta.from(command.getIdPostVenta(), retrieveEvents());

            try {
                postVenta.agregarAsesor(command.getEntityId(), command.getNombreAsesor(), command.getTipoDeAsesoria());
                emit().onResponse(new ResponseEvents(postVenta.getUncommittedChanges()));
            }catch (RuntimeException e){
                emit().onError(new BusinessException(postVenta.identity().value(), e.getMessage()));
            }
        }


}
