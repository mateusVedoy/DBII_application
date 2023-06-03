package application.WindowDialog;

import javax.swing.*;

public abstract class Menu {
    public static int buildMenu(){
        String menu = "";
        menu += ("Escolha uma das opções a seguir:\n");
        for(MenuOptions value: MenuOptions.values()){
            menu += value.getDescription() + "\n";
        }
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }
}
