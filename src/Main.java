import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        try{

            while(true){
                UI.limparTela(); //Caso esteja rodando no terminal e não no intellij
                UI.iniciarApplicacao();

                System.out.print("\n\nDeseja continuar (s/qualquer tecla)? ");
                char teste = entrada.next().charAt(0);
                if(!(teste == 's')) break;

                System.out.println();
            }


        }
        catch(InputMismatchException e){
            System.err.println("\nErro: Quantidade de tentativas inválidas. ");
        }
        catch(IllegalArgumentException e){
            System.err.println("\nError: Unidade de Temperatura inválida. ");
        }
        catch (Exception e){
            System.err.println("\nErro inesperado. Encerrando a aplicação. ");
        }
        finally {
            entrada.close();
        }
    }
}