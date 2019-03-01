import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        JDBC_Util jdbc = new JDBC_Util();

//        jdbc.read("Select * from Sales where SalesOrderID=26271");

//        String update = "Update Sales " + "SET OrderQty=OrderQty*2";
//        jdbc.update(update);

//        System.out.println();
//        jdbc.read("Select * from Sales");
//
//        jdbc.delete("Delete from Sales where UnitPrice<160");
//
//        System.out.println();
//        jdbc.insert("INSERT INTO Sales (SalesOrderID,SalesOrderDetailID,OrderQty,ProductID,UnitPrice,UnitPriceDiscount,rowguid,ModifiedDate)\n" +
//                "values (26280,110567,1,905,140.90,0.00,'3','2008-06-01 00:00:00.000')");
//
//
        jdbc.read("Select * from Sales");

        jdbc.bulkInsert();
        System.out.println();
        jdbc.read("Select * from Sales");


    }
}
