package application.WindowDialog;

//PRECISO CRIAR CONTAINER DOCKER
//VER COMO RESOLVER PONTO ACIMA OU USAR WINDOWS
public enum MenuOptions {
    INTERACTION_AD_BY_USER(1, "1 – Interações com anúncios por usuário"),
    COUNT_AVG_PROPOSES_BY_PROPERTY(2, "2 – Quantidade e valor médio de propostas por imóvel"),
    INSERT_USER(3, "3 – Insere usuário no sistema"),
    LIST_ALL_PROPERTIES_WITH_ACTIVE_AD(4, "4 – Atualizar tipo de perfil do usuário"),
    EXIT(5, "5 – Sair");

    private final int identifier;
    private final String description;

    MenuOptions(int identifier, String description) {
        this.identifier = identifier;
        this.description = description;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getDescription() {
        return description;
    }
}
