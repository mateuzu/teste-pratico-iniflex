package org.mateuzu.teste.model;

import org.mateuzu.teste.utils.FormatarMoeda;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public final class Funcionario extends Pessoa {

    private BigDecimal salario;
    private String funcao;

    public Funcionario() {
    }

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public static Comparator<Funcionario> getComparadorOrdemAlfabetica() {
        return (o1, o2) -> o1.getNome().compareTo(o2.getNome());
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Nome: " + getNome()
                + " | Data Nascimento: " + formatter.format(getDataNascimento())
                + " | Salário: R$ " + FormatarMoeda.formatarMoedaBr(getSalario())
                + " | Função: " + getFuncao() +
                "\n-------------------------------------------------------------------------------------------";
    }

}
