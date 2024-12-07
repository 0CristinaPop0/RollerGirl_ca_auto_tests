package DataProviders;

import ObjectModels.RegisterModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegisterDataProvider {

    @DataProvider(name = "registerJsonDataProvider")
    public Iterator<Object[]> registerJsonDataProvider() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();

        // Here we load the JSON file
        File jsonFile = new File("src/test/resources/testData/testDataInput.json");

        ObjectMapper objectMapper = new ObjectMapper();
        RegisterModel[] registerModelList = objectMapper.readValue(jsonFile, RegisterModel[].class);

        for (RegisterModel rm : registerModelList) {
            dp.add(new Object[]{rm});
        }

        return dp.iterator();
    }
}
