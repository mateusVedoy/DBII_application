package infraestructure.dao;

import domain.entity.ProposesAndAvgAmountByProperty;
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
            statement.setInt(1, userId);
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
}
