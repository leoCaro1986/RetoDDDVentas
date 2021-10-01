package co.com.sofkaU.RetoDDD.atencionAlCLiente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreCliente implements ValueObject<String> {

    private final String value;

    public NombreCliente(String value){
        this.value= Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("El Nombre del CLiente no puede estar vacio");
        }
        if (this.value.length()<=5){
            throw new IllegalArgumentException("EL nombre debe contener mas de 5 caracteres");
        }
        if (this.value.length()>=50){
            throw new IllegalArgumentException("EL nombre debe no contener mas de 50 caracteres");
        }

    }

    public String value() {
        return  value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NombreCliente that = (NombreCliente) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
