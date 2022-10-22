public class Conversor {


    static final Double fator1 = (double)9/5;
    static final Double fator2 = 32.0;

    public Conversor(){}

    static public Double celsiusParaFahrenheit(Double celsius){
        return (celsius*fator1) + fator2;
    }

    static public Double fahrenheitParaCelsius(Double fahrenheit){
        return (fahrenheit - fator2)*5 / 9;
    }

    static public Double celsiusParaKelvin(Double celsius){
        return (celsius + 273);
    }

    static public Double kelvinParaCelsius(Double kelvin){
        return (kelvin - 273);
    }

    static public Double fahrenheitParaKelvin(Double fahrenheit){
        return celsiusParaKelvin(fahrenheitParaCelsius(fahrenheit));
    }

    static public Double kelvinParaFahrenheit(Double kelvin){
        return celsiusParaFahrenheit(kelvinParaCelsius(kelvin));
    }


}
