package application.WindowDialog;

import application.useCase.GetUserInteractionsWithAdByUserId;
import infraestructure.database.ConnectionFactory;

import java.sql.*;

public class InteractiveMenu extends Menu {
    private static final GetUserInteractionsWithAdByUserId getUserInteractionsWithAdByUserId = new GetUserInteractionsWithAdByUserId();
    public static void execute() {
        while (true){
            switch (buildMenu()){
                case 1:
                    getUserInteractionsWithAdByUserId.execute();
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
