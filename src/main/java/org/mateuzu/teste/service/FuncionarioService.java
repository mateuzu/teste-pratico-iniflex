package org.mateuzu.teste.service;

import org.mateuzu.teste.model.Funcionario;
import org.mateuzu.teste.model.Pessoa;
import org.mateuzu.teste.utils.FormatarMoeda;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FuncionarioService  {

    private final Set<Funcionario> funcionarios = new LinkedHashSet<>();
    private final Map<String, List<Funcionario>> funcionariosAgrupados = new HashMap<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void adicionarFuncionarios(){
        funcionarios.add(new Funcionario("Maria", LocalDate.parse("18/10/2000", formatter), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.parse("12/05/1990", formatter), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.parse("02/05/1961", formatter), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.parse("14/10/1988", formatter), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.parse("05/01/1995", formatter), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.parse("19/11/1999", formatter), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.parse("31/03/1993", formatter), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.parse("08/07/1994", formatter), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.parse("24/05/2003", formatter), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.parse("02/09/1996", formatter), new BigDecimal("2799.93"), "Gerente"));
        System.out.println("\n\t\t****** Funcionários carregados na memória ******\n");
    }

    public void removerFuncionario(String nome){
        var funcionarioParaRemover = funcionarios.stream().filter(funcionario -> funcionario.getNome().equalsIgnoreCase(nome)).findFirst();

        if(funcionarioParaRemover.isPresent()){
            funcionarios.remove(funcionarioParaRemover.get());
            System.out.println("Funcionário " + nome + " removido da lista");
        } else {
            System.out.println("Funcionário " + nome + " não encontrado");
        }
    }

    public void imprimirTodosFuncionários(){
        funcionarios.forEach(System.out::println);
    }

    public void aumentarSalario(BigDecimal taxa){
        for(Funcionario funcionario : funcionarios){
            var salarioAtual = funcionario.getSalario();
            var aumento = salarioAtual.multiply(taxa);
            var novoSalario = salarioAtual.add(aumento);
            funcionario.setSalario(novoSalario);
        }

        System.out.println("Salários aumentados em " + taxa + "%" +
                "\n\n\t\tNovos salários");

        funcionarios.forEach(funcionario -> System.out.println("Nome: " + funcionario.getNome()
                + " | Novo salário: R$ " + FormatarMoeda.formatarMoedaBr(funcionario.getSalario())));
    }

    public Map<String, List<Funcionario>> agruparFuncionarios(){

        for(Funcionario funcionario : funcionarios){
            var funcao = funcionario.getFuncao();
            if (!funcionariosAgrupados.containsKey(funcao)){
                funcionariosAgrupados.put(funcao, new ArrayList<>());
            }
            funcionariosAgrupados.get(funcao).add(funcionario);
        }

        System.out.println("Funcionários agrupados\n");

        return funcionariosAgrupados;
    }

    public void imprimirFuncionariosPorFuncao(){
        this.agruparFuncionarios(); //agrupando funcionario antes de imprimir
        for(Map.Entry<String, List<Funcionario>> entry : funcionariosAgrupados.entrySet()){
            var funcao = entry.getKey();
            var listaFuncionario = entry.getValue();

            System.out.println("Função: " + funcao);
            for(Funcionario funcionario : listaFuncionario){
                System.out.println("- " + funcionario.getNome());
            }
        }
    }

    public void imprimirFuncionarioQueFazemAniversarioNoMes10E12(){
        var funcionariosFiltrados = funcionarios.stream()
                .filter(funcionario -> funcionario.getDataNascimento().getMonthValue() == 10
                        || funcionario.getDataNascimento().getMonthValue() == 12)
                .toList();

        funcionariosFiltrados.forEach(System.out::println);
    }

    public void imprimirMaiorIdade(){
        var funcionarioMaisVelho = funcionarios.stream().min(Comparator.comparing(Pessoa::getDataNascimento));

        if(funcionarioMaisVelho.isPresent()){
            var hoje = LocalDate.now();
            var dataNascimento = funcionarioMaisVelho.get().getDataNascimento();
            var idade = hoje.getYear() - dataNascimento.getYear();
            System.out.println("Funcionário mais velho: " + funcionarioMaisVelho.get().getNome() + ", " + idade + " anos");
        }
    }

    public void imprimirOrdemAlfabetica(){
        List<Funcionario> funcionariosOrdenados = new ArrayList<>(funcionarios);
        funcionariosOrdenados.sort(Funcionario.getComparadorOrdemAlfabetica());
        funcionariosOrdenados.forEach(System.out::println);
    }

    public void imprimirSalarioTotal(){
        var total = funcionarios.stream().map(Funcionario::getSalario).reduce(BigDecimal::add).get();
        System.out.println("Salário total: R$ " + FormatarMoeda.formatarMoedaBr(total));
    }

    public void imprimirSalarioMinimo(){
        var salarioMinimo = new BigDecimal("1212.00");

        for(Funcionario funcionario : funcionarios){
            var salarioAtual = funcionario.getSalario();
            var qtdeSalariosMininos = salarioAtual.divide(salarioMinimo, 2);
            System.out.println(funcionario.getNome() + " recebe " + qtdeSalariosMininos + " salarios minimps");
        }

    }

}
