import java.util.Scanner;

public class UI {
    static public void iniciarApplicacao(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("----------------------- Conversor de Temperaturas -----------------------\n");
        System.out.print("Quantas conversões você deseja realizar? ");
        int quantidadeConversoes = entrada.nextInt();



        Double[] temperaturasOrigem = new Double[quantidadeConversoes];
        Double[] temperaturasFinais = new Double[quantidadeConversoes];
        Double mediaTemperaturasIniciais = 0.0;
        Double mediaTemperaturasFinais = 0.0;

        entrada.nextLine();
        System.out.print("De qual unidade de origem a converter? ");
        Unidades unidadeEntrada = Unidades.valueOf(entrada.nextLine().toUpperCase());
        System.out.print("Para qual unidade a ser convertida? ");
        Unidades unidadeSaida = Unidades.valueOf(entrada.nextLine().toUpperCase());
        System.out.println("\nInforme os valores a serem convertidos: ");

        for(int contador = 0; contador < quantidadeConversoes; contador++){
            System.out.print("" + (contador + 1) + "º valor: " );
            temperaturasOrigem[contador] = entrada.nextDouble();
            temperaturasFinais[contador] = SeletorDeConversao.seletorDeConversao(unidadeEntrada, unidadeSaida, temperaturasOrigem[contador]);

            mensagemConversao(unidadeEntrada, unidadeSaida, temperaturasOrigem[contador], temperaturasFinais[contador]);
//
            mediaTemperaturasIniciais += temperaturasOrigem[contador];
            mediaTemperaturasFinais += temperaturasFinais[contador];
        }

        mediaTemperaturasIniciais /= quantidadeConversoes;
        mediaTemperaturasFinais /= quantidadeConversoes;

       mensagemMedia(unidadeEntrada, mediaTemperaturasIniciais);
       mensagemMedia(unidadeSaida, mediaTemperaturasFinais);


//        System.out.println("\n\nA média das temperaturas de origem é: " + mediaTemperaturasIniciais);
//        System.out.println("A média das temperaturas finais é: " + mediaTemperaturasFinais);
    }

    static public void mensagemConversao(Unidades tempOrigem, Unidades tempFinal, Double valorInicial, Double valorFinal){
        if(tempOrigem.equals(Unidades.CELSIUS)){
            switch (tempFinal) {
                case KELVIN -> System.out.printf("%.1fº %s é igual a %.1f %s.\n", valorInicial, tempOrigem, valorFinal, tempFinal);
                case CELSIUS, FAHRENHEIT -> System.out.printf("%.1fº %s é igual a %.1fº %s.\n", valorInicial, tempOrigem, valorFinal, tempFinal);

            }
        }else if(tempOrigem.equals(Unidades.KELVIN)){
            switch(tempFinal){
                case KELVIN -> System.out.printf("%.1f %s é igual a %.1f %s.\n", valorInicial, tempOrigem, valorFinal, tempFinal);
                case CELSIUS, FAHRENHEIT -> System.out.printf("%.1f %s é igual a %.1fº %s.\n", valorInicial, tempOrigem, valorFinal, tempFinal);
            }
        }else {
            switch(tempFinal){
                case KELVIN -> System.out.printf("%.1fº %s é igual a %.1f %s.\n", valorInicial, tempOrigem, valorFinal, tempFinal);
                case CELSIUS, FAHRENHEIT -> System.out.printf("%.1fº %s é igual a %.1fº %s.\n", valorInicial, tempOrigem, valorFinal, tempFinal);
            }
        }
    }

    static public void mensagemMedia(Unidades temp, Double valor){
        if(!temp.equals(Unidades.KELVIN)){
            System.out.printf("\nA média das temperaturas de origem é: %.1fº %s", valor, temp);
            return;
        }
        System.out.printf("\nA média das temperaturas de origem é: %.1f %s", valor, temp);
    }
    
    static public void limparTela(){ //Infelizmente não funciona no Intellij, mas funciona rodando no terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}
