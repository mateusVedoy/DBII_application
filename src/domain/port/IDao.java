package domain.port;

import domain.entity.Property;
import domain.entity.ProposesAndAvgAmountByProperty;
import domain.entity.User;
import domain.entity.UserInteractionsWithAd;

import java.util.List;

public interface IDao {

    List<UserInteractionsWithAd> getUserInteractionsWithAdByUserId(int userId);
    ProposesAndAvgAmountByProperty getProposesAndAvgAmountByPropertyId(int propertyId);
    String insertUser(User user);
    boolean updateProfileTypeFromUser(int id, int profileType);
    String updatePropertyDescription(int id, String description);
    User getUserById(int id);
    Property getPropertyById(int id);
    List<User> GetAllUsers();
    List<Property> GetAllProperties();
    List<Property> GetAllPropertiesWithActiveAd();
}
