package websample;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "AccountMapping", urlPatterns = {"/servlet/websample.AccountMapping"})
public class AccountMapping implements ResultSetBeanMapping {

	public Object createFromResultSet(ResultSet rs)
	throws SQLException {

		Account account = new Account();
		account.setId(rs.getInt("ID"));
		account.setName(rs.getString("NAME"));
		account.setMoney(rs.getInt("MONEY"));

		return account;
	}

}
