package domain.port;

import domain.entity.ProposesAndAvgAmountByProperty;
import domain.entity.UserInteractionsWithAd;

import java.util.List;

public interface IDao {

    List<UserInteractionsWithAd> getUserInteractionsWithAdByUserId(int userId);
    ProposesAndAvgAmountByProperty getProposesAndAvgAmountByPropertyId(int propertyId);
}
