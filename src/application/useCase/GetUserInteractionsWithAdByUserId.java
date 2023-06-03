package application.useCase;

import domain.entity.UserInteractionsWithAd;

import java.util.List;

import static java.lang.Integer.parseInt;

public class GetUserInteractionsWithAdByUserId extends UseCaseBase{
    @Override
    public void execute() {
       int userId = parseInt(messageWindow.messageInputDialog("Id do usuário a ser buscado: "));
        List<UserInteractionsWithAd> response = dao.getUserInteractionsWithAdByUserId(userId);
        if(isThereValuesIntoList(response))
            buildListResponse(response);
        else
            messageWindow.messageDialog("Não há dados para retornar");
    }

    private boolean isThereValuesIntoList(List<UserInteractionsWithAd> list) {
        return list.size() > 0;
    }

    private void buildListResponse(List<UserInteractionsWithAd> list) {
        String result = "Informações: \n";
        for(UserInteractionsWithAd resp: list){
            result += resp.toString();
            result += "\n";
        }
        messageWindow.messageDialog(result);
    }
}
