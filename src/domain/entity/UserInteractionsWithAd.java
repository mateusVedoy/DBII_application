package domain.entity;

import java.util.Date;

//entidade p montar retornno da funcao interacoes_usuario_anuncios
public class UserInteractionsWithAd {
    private int codeAd;
    private Date postDate;

    private String statusAd;

    private int codeProperty;

    private String propertyDescription;

    public UserInteractionsWithAd(int codeAd, Date postDate, String statusAd, int codeProperty, String propertyDescription) {
        this.codeAd = codeAd;
        this.postDate = postDate;
        this.statusAd = statusAd;
        this.codeProperty = codeProperty;
        this.propertyDescription = propertyDescription;
    }

    public int getCodeAd() {
        return codeAd;
    }

    public Date getPostDate() {
        return postDate;
    }

    public String getStatusAd() {
        return statusAd;
    }

    public int getCodeProperty() {
        return codeProperty;
    }

    public String getPropertyDescription() {
        return propertyDescription;
    }
}
