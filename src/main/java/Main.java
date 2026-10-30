import java.sql.SQLException;

void main() throws SQLException {
    Scanner sc = new Scanner(System.in);
    ClienteService service = new ClienteService();
    int opcao;

    do {
        IO.println("1 - Cadastrar cliente");
        IO.println("2 - Buscar por ID");
        IO.println("3 - Atualizar cliente");
        IO.println("4 - Deletar cliente");
        IO.println("5 - Listar clientes");
        IO.println("6 - Sair");
        IO.print("Opção: ");
        opcao = Integer.parseInt(sc.nextLine());

        switch (opcao) {

            case 1 -> {
                IO.print("Nome: ");
                String nome = sc.nextLine();
                IO.print("Email: ");
                String email = sc.nextLine();
                service.cadastrarCliente(nome, email);
                IO.println("Cliente cadastrado!");
            }

            case 2 -> {
                IO.print("ID: ");
                int id = Integer.parseInt(sc.nextLine());
                service.buscarPorId(id);
            }

            case 3 -> {
                IO.print("Id para atualizar os dados: ");
                int id = Integer.parseInt(sc.nextLine());
                IO.print("Novo nome: ");
                String nome = sc.nextLine();
                IO.print("Novo email: ");
                String email = sc.nextLine();
                service.atualizarCliente(id, nome, email);
                IO.println("Dados do cliente atualizado!");
            }

            case 4 -> {
                IO.print("Id para DELETAR: ");
                int id = Integer.parseInt(sc.nextLine());
                service.deletarCliente(id);
                IO.println("Cliente removido!");
            }

            case 5 -> {
                service.listarClientes();
            }

            case 6 -> IO.println("Saindo...");

            default -> IO.println("Digite um número válido!");
        }
    } while (opcao != 6);
}
