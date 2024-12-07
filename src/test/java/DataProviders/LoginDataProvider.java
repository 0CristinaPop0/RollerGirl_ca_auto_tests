package DataProviders;

import ObjectModels.LoginModel;
import com.opencsv.exceptions.CsvException;
import jakarta.xml.bind.JAXBException;
import org.testng.annotations.DataProvider;
import utils.DatabaseUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginDataProvider {


    /* ####################################################### SQL DATA PROVIDER ##########################################  */

    @DataProvider(name = "loginSQLDataProvider")
    public Iterator<Object[]> loginSQLDataProvider() throws JAXBException, IOException, CsvException, SQLException {
        Collection<Object[]> dp = new ArrayList<>();
        DatabaseUtils databaseUtils = new DatabaseUtils();
        // connect to DB and get data
        Connection connection = databaseUtils.connect();
        Statement statement = databaseUtils.getStatement(connection);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM login");

        while (resultSet.next()) {
            // Create LoginModel with four parameters: username, email, password, and loginErr
            LoginModel loginModel = new LoginModel(
                    databaseUtils.getElementFromDB(resultSet, "username"),
                    databaseUtils.getElementFromDB(resultSet, "email"),
                    databaseUtils.getElementFromDB(resultSet, "password"),
                    databaseUtils.getElementFromDB(resultSet, "loginError"));
            dp.add(new Object[]{loginModel});
        }

        return dp.iterator();
    }

}
