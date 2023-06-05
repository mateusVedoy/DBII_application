package infraestructure.dao;

import domain.entity.ProposesAndAvgAmountByProperty;
import domain.entity.User;
import domain.entity.UserInteractionsWithAd;
import domain.port.IDao;
import infraestructure.database.ConnectionFactory;
import infraestructure.database.SQLs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBIIDao implements IDao {
    @Override
    public List<UserInteractionsWithAd> getUserInteractionsWithAdByUserId(int userId) {
        List<UserInteractionsWithAd> list = new ArrayList<>();
        try(Connection conn = new ConnectionFactory().getConnection();
                PreparedStatement statement = conn.prepareStatement(SQLs.INTERACTION_AD_BY_USER.getSql())
                ){
            statement.setString(1, String.valueOf(userId));
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                list.add(
                        new UserInteractionsWithAd(
                                resultSet.getInt("codigo_anuncio"),
                                resultSet.getDate("data_postagem"),
                                resultSet.getString("status_anuncio"),
                                resultSet.getInt("codigo_imovel"),
                                resultSet.getString("descricao_imovel")
                        )
                );
            }
        }catch(SQLException ex){
            System.out.println("Exceção SQL: "+ex.getMessage());
        }catch(Exception ex){
            System.out.println("Exeção: "+ex.getMessage());
        }

        return list;
    }

    @Override
    public ProposesAndAvgAmountByProperty getProposesAndAvgAmountByPropertyId(int propertyId) {
        ProposesAndAvgAmountByProperty p = null;

        try(Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement statement = conn.prepareStatement(SQLs.COUNT_AVG_PROPOSES_BY_PROPERTY.getSql())
        ){
            statement.setInt(1, propertyId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                p = new ProposesAndAvgAmountByProperty(
                  resultSet.getInt("total_propostas"),
                  resultSet.getInt("media_valor_proposta")
                );
            }
        }catch (SQLException e) {
            System.out.println("Exceção SQL: "+e.getMessage());
        } catch(Exception e) {
            System.out.println("Exeção: "+e.getMessage());
        }

        return p;
    }

    @Override
    public boolean insertUser(User user) {
        try(Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement statement = conn.prepareStatement(SQLs.INSERT_USER.getSql())){
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getCpf());
            statement.setDouble(3, user.getIncome());
            statement.setInt(4, user.getProfileType());
            statement.execute();
            return true;
        }catch (SQLException e) {
            System.out.println("Exceção SQL: "+e.getMessage());
        } catch(Exception e) {
            System.out.println("Exeção: "+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateProfileTypeFromUser(int id, int profileType) {
        try(Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement statement = conn.prepareStatement(SQLs.UPDATE_USER_PROFILE_TYPE.getSql())){
            statement.setInt(1, id);
            statement.setInt(2, profileType);
            System.out.println("user.getId(): "+id);
            System.out.println("user.getProfileType(): "+profileType);
            statement.execute();
            return true;
        }catch (SQLException e) {
            System.out.println("Exceção SQL: "+e.getMessage());
        } catch(Exception e) {
            System.out.println("Exeção: "+e.getMessage());
        }
        return false;
    }

    @Override
    public List<User> GetAllUsers() {
        try(Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement statement = conn.prepareStatement(SQLs.SELECT_ALL_USERS.getSql())){
            List<User> users = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                users.add(
                        new User(
                                resultSet.getInt("usr_codigo"),
                                resultSet.getString("usr_ativo"),
                                resultSet.getString("usr_nomecompleto"),
                                resultSet.getString("usr_cpf"),
                                resultSet.getDouble("usr_renda"),
                                resultSet.getInt("usr_tipoperfil")
                        )
                );
            }
            return users;
        }catch (SQLException e) {
            System.out.println("Exceção SQL: "+e.getMessage());
        } catch(Exception e) {
            System.out.println("Exceção: "+e.getMessage());
        }

        return null;
    }
    
    @Override
    public User getById(int id) {
    	User u = null;
    	try(Connection conn = new ConnectionFactory().getConnection();
                PreparedStatement statement = conn.prepareStatement(SQLs.SELECT_USER_BY_ID.getSql())
            ){
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()){
                	u = new User(id, 
                      resultSet.getString("usr_ativo"),
                      resultSet.getString("usr_nomecompleto"),
                      resultSet.getString("usr_cpf"),
                      resultSet.getDouble("usr_renda"),
                      resultSet.getInt("usr_tipoperfil")
                      );
                }
                return u;
            }catch (SQLException e) {
                System.out.println("Exceção SQL: "+e.getMessage());
            } catch(Exception e) {
                System.out.println("Exeção: "+e.getMessage());
            }

            return null;
    }
}
