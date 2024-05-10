public abstract class Funcionario {
  private String nome;
  private String matricula;
  private double salarioBase; // Adicionando o campo para o salário base

  public Funcionario(String nome, String matricula, double salarioBase) {
      this.nome = nome;
      this.matricula = matricula;
      this.salarioBase = salarioBase;
  }

  public abstract double calcularSalario(); // Declarando o método abstrato calcularSalario()

  public double calcularSalarioBase() {
      return salarioBase;
  }

  public String getNome() {
      return nome;
  }

  public String getMatricula() {
      return matricula;
  }

  @Override
  public String toString() {
      return "Nome: " + nome + ", Matrícula: " + matricula;
  }
}
