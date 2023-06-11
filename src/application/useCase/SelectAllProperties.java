package application.useCase;

import java.util.List;

import domain.entity.Property;

public class SelectAllProperties extends UseCaseBase {
    public void execute() {
        List<Property> propertyList = dao.GetAllProperties();
        if(isThereValuesIntoList(propertyList))
            buildListResponse(propertyList);
        else
            messageWindow.messageDialog("Não há dados para exibir");
    }

    private boolean isThereValuesIntoList(List<Property> list) {
        return list.size() > 0;
    }

    private void buildListResponse(List<Property> list) {
        String result = "Informações: \n";
        for(Property resp: list){
            result += resp.toString();
            result += "\n";
        }
        messageWindow.messageDialog(result);
    }
}
