package application.useCase;

import domain.entity.User;

public class InsertUser extends UseCaseBase{

    private SelectAllUsers selectAllUsers = new SelectAllUsers();

    @Override
    public void execute() {
        messageWindow.messageDialog("Seu novo usuário terá as seguintes inforações: \nNome completo: \"Virgulina Das Ventanias\" \nCPF:\"123.456.789-10\" \nRenda: 4.300 Mirréis \nPerfil:\"Locador\"");
        boolean response = dao.insertUser(
                new User(
                        "1",
                        "Virgulina Das Ventanias",
                        "123.456.789-10",
                        4.300,
                        1
                )
        );
        if(response)
            successResponse();
        else
            messageWindow.messageDialog("Vixe! Deu errado isso aí :(");
    }

    private void successResponse() {
        messageWindow.messageDialog("Usuário cadastrado com sucesso\n");
        selectAllUsers.execute();
    }
}
