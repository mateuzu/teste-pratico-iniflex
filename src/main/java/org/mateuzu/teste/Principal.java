package org.mateuzu.teste;

import org.mateuzu.teste.service.FuncionarioService;
import org.mateuzu.teste.utils.Cores;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        FuncionarioService funcionarioService = new FuncionarioService();
        funcionarioService.adicionarFuncionarios(); //adicionando funcionarios

        while (true){
            System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
                    + "*******************************************************************************");
            System.out.println("*                                                                             *");
            System.out.println("*                          TESTE PRÁTICO - INIFLEX                            *");
            System.out.println("*                     Desenvolvido por Mateus Ferreira                        *");
            System.out.println("*******************************************************************************");
            System.out.println("*                                                                             *");
            System.out.println("*             1 - Imprimir todos os funcionários                              *");
            System.out.println("*             2 - Remover funcionário João da lista                           *");
            System.out.println("*             3 - Aumentar salário dos funcionários                           *");
            System.out.println("*             4 - Imprimir funcionários agrupados                             *");
            System.out.println("*             5 - Imprimir funcionários que fazem aniversário no mês 10 e 12  *");
            System.out.println("*             6 - Imprimir funcionário com a maior idade                      *");
            System.out.println("*             7 - Imprimir funcionarios em ordem alfabética                   *");
            System.out.println("*             8 - Imprimir o salário total dos funcionários                   *");
            System.out.println("*             9 - Imprimir quantos salários mínimos ganha cada funcionário    *");
            System.out.println("*             0 - Sair                                                        *");
            System.out.println("*                                                                             *");
            System.out.println("*******************************************************************************");
            System.out.println("            Entre com a opção desejada:                ");
            System.out.println(Cores.TEXT_RESET);

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException ex){
                System.out.println("\nDigite valores inteiros!");
                scanner.nextLine();
                opcao = -1;
            }

            if(opcao == 0){
                System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
                System.out.println("**********************************************************************");
                System.out.println("*                                                                    *");
                System.out.println("*     Programa encerrado com sucesso                                 *");
                System.out.println("*     Obrigado por utilizar o sistema da Iniflex                     *");
                System.out.println("*                                                                    *");
                System.out.println("*             Desenvolvido por Mateus Ferreira                       *");
                System.out.println("*     GitHub: https://github.com/mateuzu                             *");
                System.out.println("*     Repositório: https://github.com/mateuzu/teste-pratico-iniflex  *");
                System.out.println("*     Linkedin: https://linkedin.com/in/mateus-ferreira-costa        *");
                System.out.println("*                                                                    *");
                System.out.println("**********************************************************************");
                System.out.println(Cores.TEXT_RESET);
                scanner.close();
                System.exit(0);
            }

            switch (opcao){
                case 1:
                    System.out.println("\t\tImprimir todos funcionários\n");
                    funcionarioService.imprimirTodosFuncionários();
                    keyPress();
                    break;
                case 2:
                    System.out.println("\t\tRemover funcionário João\n");
                    funcionarioService.removerFuncionario("João");
                    keyPress();
                    break;
                case 3:
                    System.out.println("\t\tAumentar salário dos funcionários\n");
                    funcionarioService.aumentarSalario(new BigDecimal("0.10"));
                    keyPress();
                    break;
                case 4:
                    System.out.println("\t\tImprimir funcinários agrupados\n");
                    funcionarioService.imprimirFuncionariosPorFuncao();
                    keyPress();
                    break;
                case 5:
                    System.out.println("\t\tImprimir funcionários que nasceram no mês 10 e 12\n");
                    funcionarioService.imprimirFuncionarioQueFazemAniversarioNoMes10E12();
                    keyPress();
                    break;
                case 6:
                    System.out.println("\t\tImprimir funcionário com a maior idade\n");
                    funcionarioService.imprimirMaiorIdade();
                    keyPress();
                    break;
                case 7:
                    System.out.println("\t\tImprimir funcionários em ordem alfabética\n");
                    funcionarioService.imprimirOrdemAlfabetica();
                    keyPress();
                    break;
                case 8:
                    System.out.println("\t\tImprimir salário total:\n");
                    funcionarioService.imprimirSalarioTotal();
                    keyPress();
                    break;
                case 9:
                    System.out.println("\t\tImprimir quantidade de salários minimos\n");
                    funcionarioService.imprimirSalarioMinimo();
                    keyPress();
                    break;
                default:
                    System.out.println(Cores.TEXT_RED_BOLD + "Opção inválida \n\n");
                    keyPress();
                    break;
            }
        }

    }

    public static void keyPress() {
        try {
            System.out.println(Cores.TEXT_RESET + "\nPressione enter para continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }
}