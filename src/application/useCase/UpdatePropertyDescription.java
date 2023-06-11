package application.useCase;

import static java.lang.Integer.parseInt;

import domain.entity.Property;

public class UpdatePropertyDescription extends UseCaseBase{
	
	private SelectAllProperties selectAllProperties = new SelectAllProperties();

	@Override
	public void execute() {
		int propertyId = parseInt(messageWindow.messageInputDialog("Digite o Id do imóvel a ser alterado: "));
		Property property = dao.getPropertyById(propertyId);
		String description = messageWindow.messageInputDialog("Digite a descrição: ");
		String response = dao.updatePropertyDescription(propertyId, description);

		responseMessage(response);
	}

	private void responseMessage(String response) {
		messageWindow.messageDialog(response);
		selectAllProperties.execute();
	}
}
