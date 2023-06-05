package application.useCase;

import domain.entity.User;

public class InsertUser extends UseCaseBase{

    private SelectAllUsers selectAllUsers = new SelectAllUsers();

    @Override
    public void execute() {
        messageWindow.messageDialog("Seu novo usuário terá as seguintes inforações: \nNome completo: \"Fulaninho Serra\" \nCPF:\"999.456.789-10\" \nRenda: 5.300 Mirréis \nPerfil:\"Locador\"");
        boolean response = dao.insertUser(
                new User(
                        "1",
                        "Beltraninho Serra",
                        "987.456.789-10",
                        5.300,
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
