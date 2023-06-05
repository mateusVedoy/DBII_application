package domain.port;

import domain.entity.ProposesAndAvgAmountByProperty;
import domain.entity.User;
import domain.entity.UserInteractionsWithAd;

import java.util.List;

public interface IDao {

    List<UserInteractionsWithAd> getUserInteractionsWithAdByUserId(int userId);
    ProposesAndAvgAmountByProperty getProposesAndAvgAmountByPropertyId(int propertyId);
    boolean insertUser(User user);
    boolean updateProfileTypeFromUser(User user);
    List<User> GetAllUsers();
}
