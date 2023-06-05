package application.useCase;

import domain.entity.User;

public class UpdateProfileTypeFromUser extends UseCaseBase {

    private SelectAllUsers selectAllUsers = new SelectAllUsers();
    @Override
    public void execute() {
        messageWindow.messageDialog("Mudaremos o tipo de perfil da usuária Virgulina de Locador para Locatário");
        boolean response = dao.updateProfileTypeFromUser(
            new User(
                    "1",
                    "Virgulina Das Ventanias",
                    "123.456.789-10",
                    4.300,
                    2
            )
        );
        if(response)
            successResponse();
        else
            messageWindow.messageDialog("Operação não pôde ser concluída com sucesso :(");
    }

    private void successResponse() {
        messageWindow.messageDialog("Perfil alterado com sucesso\n");
        selectAllUsers.execute();
    }
}
