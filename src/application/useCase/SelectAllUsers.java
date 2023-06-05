package application.useCase;

import domain.entity.User;
import domain.entity.UserInteractionsWithAd;

import java.util.List;

public class SelectAllUsers extends UseCaseBase{
    @Override
    public void execute() {
        List<User> userList = dao.GetAllUsers();
        if(isThereValuesIntoList(userList))
            buildListResponse(userList);
        else
            messageWindow.messageDialog("Não há dados para exibir");
    }

    private boolean isThereValuesIntoList(List<User> list) {
        return list.size() > 0;
    }

    private void buildListResponse(List<User> list) {
        String result = "Informações: \n";
        for(User resp: list){
            result += resp.toString();
            result += "\n";
        }
        messageWindow.messageDialog(result);
    }
}
