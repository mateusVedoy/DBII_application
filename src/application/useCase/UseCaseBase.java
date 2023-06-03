package application.useCase;

import application.WindowDialog.InteractionMessageWindow;
import infraestructure.dao.DBIIDao;

public abstract class UseCaseBase {
    protected static final InteractionMessageWindow messageWindow = new InteractionMessageWindow();
    protected final DBIIDao dao = new DBIIDao();

    public abstract void execute();
}
