package application.useCase;

import domain.entity.ProposesAndAvgAmountByProperty;

import static java.lang.Integer.parseInt;

public class GetProposesAndAmountAvgByPropertyId extends UseCaseBase {
    @Override
    public void execute() {
        int propertyId = parseInt(messageWindow.messageInputDialog("Id do imóvel a ser buscado: "));
        ProposesAndAvgAmountByProperty response = dao.getProposesAndAvgAmountByPropertyId(propertyId);
        if(isThereResponseToBeShow(response))
            messageWindow.messageDialog(response.toString());
        else
            messageWindow.messageDialog("Não há dados a serem retornados");
    }

    private boolean isThereResponseToBeShow(ProposesAndAvgAmountByProperty resp) {
        return resp != null;
    }
}
