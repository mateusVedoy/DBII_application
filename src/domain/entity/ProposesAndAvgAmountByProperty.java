package domain.entity;

//entidade para funcao propostas_anuncio_imovel
public class ProposesAndAvgAmountByProperty {
    private int totalProposes;

    private int proposeAmountAvg;

    public ProposesAndAvgAmountByProperty(int totalProposes, int proposeAmountAvg) {
        this.totalProposes = totalProposes;
        this.proposeAmountAvg = proposeAmountAvg;
    }

    public int getTotalProposes() {
        return totalProposes;
    }

    public int getProposeAmountAvg() {
        return proposeAmountAvg;
    }

	@Override
	public String toString() {
		return "ProposesAndAvgAmountByProperty [totalProposes=" + totalProposes + ", proposeAmountAvg="
				+ proposeAmountAvg + "]";
	}
    
    
}
