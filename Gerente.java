import java.util.ArrayList;

public class Gerente extends Funcionario implements Trabalhavel {
    private double bonusAnual;
    private ArrayList<Funcionario> equipe;

    public Gerente(String nome, String matricula, double bonusAnual) {
        super(nome, matricula, 0); // Defina o salário base adequado aqui
        this.bonusAnual = bonusAnual;
        this.equipe = new ArrayList<>();
    }

    public void adicionarFuncionarioEquipe(Funcionario funcionario) {
        equipe.add(funcionario);
    }

    public double getBonusAnual() {
        return bonusAnual;
    }

    public ArrayList<Funcionario> getEquipe() {
        return equipe;
    }

    @Override
    public double calcularSalario() {
        return calcularSalarioBase() + bonusAnual;
    }

    @Override
    public void trabalhar() {
        System.out.println("Gerente " + getNome() + " liderando a equipe.");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Equipe liderada por " + getNome() + " apresentando bom progresso.");
    }
}