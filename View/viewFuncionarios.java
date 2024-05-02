package View;

public class viewFuncionarios {

    public static void mainAdminFuncionarios() {
        viewLine.title("FUNCIONÁRIO");
        viewLine.alignLeft("[1] - Cadastrar novo funcionário");
        viewLine.alignLeft("[2] - Remover funcionário");
        viewLine.alignLeft("[3] - Atualizar informação do funcionário");
        viewLine.alignLeft("[4] - Consultar funcionarios cadastrados");
        viewLine.alignLeft("[5] - Voltar");
        viewLine.Line();
        viewLine.input();
    }

}
