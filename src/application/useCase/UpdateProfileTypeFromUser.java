package application.useCase;

import static java.lang.Integer.parseInt;

import domain.entity.User;

public class UpdateProfileTypeFromUser extends UseCaseBase {

	private SelectAllUsers selectAllUsers = new SelectAllUsers();

	@Override
	public void execute() {
		int userId = parseInt(messageWindow.messageInputDialog("Digite o Id do usuário a ser alterado: "));
		User user = dao.getById(userId);
		if (user == null) {
			messageWindow.messageDialog("Não há usuários com esse Id");
			return;
		}

		int profileId = parseInt(messageWindow.messageInputDialog("Perfil: (1 - Locatário, 2 - Locador)"));
		if (profileId < 1 || profileId > 2) {
			messageWindow.messageDialog("Perfil inválido");
			return;
		}

		boolean response = dao.updateProfileTypeFromUser(userId, profileId);
		if (response)
			successResponse();
		else
			messageWindow.messageDialog("Operação não pôde ser concluída com sucesso :(");

	}

	private void successResponse() {
		messageWindow.messageDialog("Perfil alterado com sucesso\n");
		selectAllUsers.execute();
	}
}
