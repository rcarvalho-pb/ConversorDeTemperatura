public class SeletorDeConversao {



    static Double seletorDeConversao(Unidades tempOrigem, Unidades tempFinal, Double valorTemp) throws IllegalArgumentException{

        if(tempOrigem.equals(Unidades.CELSIUS)){
            return switch (tempFinal) {
                case CELSIUS -> valorTemp;
                case FAHRENHEIT -> Conversor.celsiusParaFahrenheit(valorTemp);
                case KELVIN -> Conversor.celsiusParaKelvin(valorTemp);
            };
        } else if (tempOrigem.equals(Unidades.FAHRENHEIT)) {
            return switch (tempFinal) {
                case CELSIUS -> Conversor.fahrenheitParaCelsius(valorTemp);
                case FAHRENHEIT -> valorTemp;
                case KELVIN -> Conversor.fahrenheitParaKelvin(valorTemp);
            };
        }
        else{
            return switch (tempFinal) {
                case CELSIUS -> Conversor.kelvinParaCelsius(valorTemp);
                case FAHRENHEIT -> Conversor.kelvinParaFahrenheit(valorTemp);
                case KELVIN -> valorTemp;
            };
        }

    }


}
