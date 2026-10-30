void main() {
    Scanner sc = new Scanner(System.in);
    ClienteService service = new ClienteService();
    int opcao;

    do {
        IO.println("1 - Cadastrar cliente");
        IO.println("2 - Buscar por ID");
        IO.println("3 - Atualizar cliente");
        IO.println("4 - Deletar cliente");
        IO.println("5 - Sair");
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
            case 5 -> IO.println("Saindo...");
            default -> IO.println("Digite um número válido!");
        }
    } while (opcao != 5);
}
