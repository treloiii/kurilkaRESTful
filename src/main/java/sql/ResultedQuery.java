package sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component("resultedQuery")
public class ResultedQuery {
    Connection c;
    @Autowired
    DatabaseInstance db;
    public ResultedQuery() {
    }

    public ResultSet getResultSet(String query) throws SQLException {
        c=db.getConnection();
        PreparedStatement ps=c.prepareStatement(query);
        return ps.executeQuery();
    }
    public void voidQuery(String query) throws SQLException {
        c=db.getConnection();
        PreparedStatement ps=c.prepareStatement(query);
        ps.execute();
    }

}
