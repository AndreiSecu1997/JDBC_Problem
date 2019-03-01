import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

class JDBC_Util {

    private final String url = "jdbc:mysql://localhost:3306/automation_practice?allowPublicKeyRetrieval=true&useSSL=false";
    private User user = new User();
    private Connection conn = DriverManager.getConnection(url, user.getUsername(), user.getPassword());
    private Statement statement = conn.createStatement();

    JDBC_Util() throws SQLException {
    }

    void read(String query) throws SQLException {
        ResultSet result = statement.executeQuery(query);
        ResultSetMetaData rsmd = result.getMetaData();

        while (result.next()) {
            int i = 1;
            while (i <= rsmd.getColumnCount()) {
                System.out.print(result.getString(i) + "  ");
                i++;
            }
            System.out.println();
        }

    }

    void update(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    void delete(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    void insert(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    void bulkInsert() throws IOException, SQLException {
        READ_Util read_util = new READ_Util();

        List<String> rows = read_util.read();

        PreparedStatement stmt = conn.prepareStatement("Insert into Sales (SalesOrderID,SalesOrderDetailID,OrderQty," +
                "ProductID,UnitPrice,UnitPriceDiscount,rowguid,ModifiedDate) values(?,?,?,?,?,?,?,?)");


        rows.remove(rows.size()-1);
        rows.remove(rows.size()-1);

        for (int i = 0; i < rows.size(); i++) {

            String[] arr = rows.get(i).split(",");
            stmt.setString(1, arr[0]);
            stmt.setString(2, arr[1]);
            stmt.setString(3, arr[2]);
            stmt.setString(4, arr[3]);
            stmt.setString(5, arr[4]);
            stmt.setString(6, arr[5]);
            stmt.setString(7, arr[6]);
            stmt.setString(8, arr[7]);
            stmt.execute();
        }


        System.out.println("BulkInsert is Done successfully!");
    }


}
