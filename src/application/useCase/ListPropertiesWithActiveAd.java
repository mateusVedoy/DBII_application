package application.useCase;

import java.util.List;

import domain.entity.Property;

public class ListPropertiesWithActiveAd extends UseCaseBase {
	@Override
	public void execute() {
		List<Property> propertyList = dao.GetAllPropertiesWithActiveAd();
		if(isThereValuesIntoList(propertyList))
			buildListResponse(propertyList);
		else
			messageWindow.messageDialog("Não há dados para exibir");
	}

	private boolean isThereValuesIntoList(List<Property> list) {
		if (list != null)
			return list.size() > 0;

		return false;
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
