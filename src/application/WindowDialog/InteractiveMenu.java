package application.WindowDialog;

import application.useCase.GetProposesAndAmountAvgByPropertyId;
import application.useCase.GetUserInteractionsWithAdByUserId;
import application.useCase.InsertUser;
import application.useCase.UpdateProfileTypeFromUser;

import java.sql.*;

public class InteractiveMenu extends Menu {
    private static final GetUserInteractionsWithAdByUserId getUserInteractionsWithAdByUserId = new GetUserInteractionsWithAdByUserId();
    private static final GetProposesAndAmountAvgByPropertyId getProposesAndAmountAvgByProperty = new GetProposesAndAmountAvgByPropertyId();
    private static final InsertUser insertUser = new InsertUser();
    private static final UpdateProfileTypeFromUser updateProfileTypeFromUser = new UpdateProfileTypeFromUser();
    public static void execute() {
        while (true){
            switch (buildMenu()){
                case 1:
                    getUserInteractionsWithAdByUserId.execute();
                    break;
                case 2:
                    getProposesAndAmountAvgByProperty.execute();
                    break;
                case 3:
                    insertUser.execute();
                    break;
                case 4:
                    updateProfileTypeFromUser.execute();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
