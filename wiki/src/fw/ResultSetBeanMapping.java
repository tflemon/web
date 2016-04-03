package fw;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ResultSetBeanMapping", urlPatterns = {"/fw.ResultSetBeanMapping"})
public interface ResultSetBeanMapping {

	/**
	 * ResultSetを元にオブジェクトを作成する
	 */
    public Object createFromResultSet(ResultSet rs)
            throws SQLException;

}
