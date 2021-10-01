package co.com.sofkaU.RetoDDD.ventas.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DescripcionPedido implements ValueObject<String> {

    private final String value;

    public DescripcionPedido(String value){
        this.value= Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("La descripción del pedido no puede estar vacia");
        }
    }

    public String value() {
        return  null;
    }
}
