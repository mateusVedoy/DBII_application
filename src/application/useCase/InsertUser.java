package application.useCase;

import static java.lang.Integer.parseInt;

import domain.entity.User;

public class InsertUser extends UseCaseBase{

    private SelectAllUsers selectAllUsers = new SelectAllUsers();

    @Override
    public void execute() {
    	String name = messageWindow.messageInputDialog("Digite o nome do usuário: ");
    	String cpf = messageWindow.messageInputDialog("Digite o CPF: ");
    	String formatCpf = cpf.replaceAll("[^0-9]", "");
    	double income = Double.parseDouble(messageWindow.messageInputDialog("Digite a renda: "));
		int profileId = parseInt(messageWindow.messageInputDialog("Perfil: (1 - Locatário, 2 - Locador)"));
		if (profileId < 1 || profileId > 2) {
			messageWindow.messageDialog("Perfil inválido");
			return;
		}
        String response = dao.insertUser(
        		new User("1", name, formatCpf, income, profileId)
        );        

        responseMessage(response);
    }

    private void responseMessage(String response) {
        messageWindow.messageDialog(response);
        if (response.contains("sucesso"))
            selectAllUsers.execute();
    }
}
