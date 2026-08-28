package utilities;

import Base.LoginData;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonDataReader {

    public LoginData[] readLoginData() throws IOException {
        Reader reader=new FileReader("src/test/resources/testdata.json");
        Gson gson=new Gson();
        LoginData[] data=gson.fromJson(reader,LoginData[].class);

        reader.close();
        return data;

    }
}
