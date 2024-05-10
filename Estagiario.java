public class Estagiario extends Funcionario implements Trabalhavel {
  private int horasTrabalhadas;
  private Funcionario supervisor;

  public Estagiario(String nome, String matricula, int horasTrabalhadas, Funcionario supervisor) {
      super(nome, matricula, 0); // Defina o salário base adequado aqui
      this.horasTrabalhadas = horasTrabalhadas;
      this.supervisor = supervisor;
  }

  public int getHorasTrabalhadas() {
      return horasTrabalhadas;
  }

  public Funcionario getSupervisor() {
      return supervisor;
  }

  @Override
  public double calcularSalario() {
      // Implementar lógica de cálculo de salário base do estagiário (por hora)
      return calcularSalarioBase() * horasTrabalhadas;
  }

  @Override
  public void trabalhar() {
      System.out.println("Estagiário " + getNome() + " executando tarefas supervisionadas.");
  }

  @Override
  public void relatarProgresso() {
      System.out.println("Estagiário " + getNome() + " concluiu as tarefas designadas e reporta ao supervisor " + supervisor.getNome() + ".");
  }
}