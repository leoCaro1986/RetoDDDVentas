package co.com.sofkaU.RetoDDD.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkaU.RetoDDD.ventas.comands.AgregarFactura;
import co.com.sofkaU.RetoDDD.ventas.comands.AgregarPedido;

public class AgregarPedidoUseCase extends UseCase<RequestCommand<AgregarPedido>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarPedido> agregarPedidoRequestCommand) {

    }
}
