package co.com.sofkaU.RetoDDD.atencionAlCLiente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class FechaDeServicio implements ValueObject<Date> {

    private final Date value;

    public FechaDeServicio(Date value){
        this.value= Objects.requireNonNull(value);
        if (this.value.toString().isBlank()){
            throw new IllegalArgumentException("La fecha del servicio no puede estar vacio");
        }
    }

    public Date value() {
        return  value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaDeServicio that = (FechaDeServicio) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
