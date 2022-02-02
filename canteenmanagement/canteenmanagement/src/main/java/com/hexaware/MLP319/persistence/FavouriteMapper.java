package com.hexaware.MLP319.persistence;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hexaware.MLP319.model.Favourite;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class FavouriteMapper implements ResultSetMapper<Favourite> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Favourite map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Menu
       */
    return new Favourite(rs.getInt("food_id"), rs.getInt("customer_id"), rs.getString("food_name"), rs.getInt("food_price"));
  }
}