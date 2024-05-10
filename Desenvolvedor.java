import java.util.HashSet;

public class Desenvolvedor extends Funcionario implements Trabalhavel {
    private HashSet<String> tecnologias;

    public Desenvolvedor(String nome, String matricula, HashSet<String> tecnologias) {
        super(nome, matricula, 0); // Defina o salário base adequado aqui
        this.tecnologias = tecnologias;
    }

    public HashSet<String> getTecnologias() {
        return tecnologias;
    }

    @Override
    public double calcularSalario() {
        // Implementar lógica de cálculo de salário base do desenvolvedor
        return calcularSalarioBase();
    }

    @Override
    public void trabalhar() {
        System.out.println("Desenvolvedor " + getNome() + " codificando.");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Desenvolvedor " + getNome() + " finalizou a implementação da funcionalidade X.");
    }
}