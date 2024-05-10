import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SistemaGerenciamentoFuncionarios {
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    adicionarFuncionario();
                    break;
                case 2:
                    removerFuncionario();
                    break;
                case 3:
                    exibirFuncionarios();
                    break;
                case 4:
                    buscarFuncionario();
                    break;
                case 0:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 - Adicionar Funcionário");
        System.out.println("2 - Remover Funcionário");
        System.out.println("3 - Exibir Funcionários");
        System.out.println("4 - Buscar Funcionário");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarFuncionario() {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o tipo de funcionário (1 - Gerente, 2 - Desenvolvedor, 3 - Estagiário): ");
        int tipo = input.nextInt();
        input.nextLine(); 

        System.out.println("Informe o nome do funcionário: ");
        String nome = input.nextLine();

        System.out.println("Informe a matrícula do funcionário: ");
        String matricula = input.nextLine();

        switch (tipo) {
            case 1:
                System.out.println("Informe o bônus anual do gerente: ");
                double bonusAnual = input.nextDouble();
                funcionarios.add(new Gerente(nome, matricula, bonusAnual));
                break;
            case 2:
                System.out.println("Informe as tecnologias do desenvolvedor (separadas por vírgula): ");
                String[] tecnologiasArray = input.nextLine().split(",");
                HashSet<String> tecnologias = new HashSet<>();
                for (String tecnologia : tecnologiasArray) {
                    tecnologias.add(tecnologia.trim());
                }
                funcionarios.add(new Desenvolvedor(nome, matricula, tecnologias));
                break;
            case 3:
                System.out.println("Informe as horas trabalhadas do estagiário: ");
                int horasTrabalhadas = input.nextInt();
                input.nextLine(); 
                System.out.println("Informe o nome do supervisor do estagiário: ");
                String nomeSupervisor = input.nextLine();
                Funcionario supervisor = buscarFuncionarioPorNome(nomeSupervisor);
                if (supervisor != null) {
                    funcionarios.add(new Estagiario(nome, matricula, horasTrabalhadas, supervisor));
                } else {
                    System.out.println("Supervisor não encontrado. Estagiário não foi adicionado.");
                }
                break;
            default:
                System.out.println("Tipo de funcionário inválido.");
        }
    }

    private static void removerFuncionario() {
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Informe a matrícula do funcionário a ser removido: ");
        String matricula = scanner.nextLine();
        
        // Procurar o funcionário na lista
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula().equalsIgnoreCase(matricula)) {
                // Remover o funcionário da lista
                funcionarios.remove(funcionario);
                System.out.println("Funcionário removido com sucesso.");
                return;
            }
        }
        // Se o funcionário não for encontrado
        System.out.println("Funcionário não encontrado.");
    }

    private static void exibirFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("Lista de Funcionários:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
        }
    }

    private static void buscarFuncionario() {
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Informe a matrícula do funcionário a ser buscado: ");
        String matricula = scanner.nextLine();
        
        // Procurar o funcionário na lista
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula().equalsIgnoreCase(matricula)) {
                // Exibir o funcionário encontrado
                System.out.println("Funcionário encontrado:");
                System.out.println(funcionario);
                return;
            }
        }
        // Se o funcionário não for encontrado
        System.out.println("Funcionário não encontrado.");
    }

    private static Funcionario buscarFuncionarioPorNome(String nome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                return funcionario;
            }
        }
        return null;
    }
}
