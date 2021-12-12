package config;

import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderMy {

    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build()});
        list.add(new Object[]{Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build()});
        list.add(new Object[]{Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginDataCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\User\\QA30\\POM_Qa30_SuperSchedular\\src\\test\\resources\\logindata.csv")));

        String line = reader.readLine();
        while(line!= null){
            String[] split= line.split(",");
            list.add(new Object[]{Auth.builder().email(split[0]).passwoard(split[1]).build()});
            line = reader.readLine();
        }

        return list.iterator();
    }
}