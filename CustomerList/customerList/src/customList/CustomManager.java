package customList;

import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;

public class CustomManager {
    //ArrayList
    ArrayList<CustomInfo> customManagers = new ArrayList<>();

    //Singleton pattern
    static CustomManager inst = null;
    private CustomManager(){}
    public static CustomManager createCustomManager(){
        if(inst == null)
            inst = new CustomManager();
        return inst;
    }

    public void readFile(String csv) throws FileNotFoundException {
        BufferedReader csvFile = new BufferedReader(new FileReader("src" + File.separator + csv));

        try {
            String file = csvFile.readLine(); //to skip the first line

            while((file = csvFile.readLine()) != null){
                String[] data = file.split(",");
                //adding to ArrayList
                customManagers.add(new CustomInfo(Integer.parseInt(data[0]),data[1],data[2],data[3],data[4],data[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (CustomInfo c : customManagers) {
            System.out.println(c.toString());
        }
    }

    public ArrayList<CustomInfo> getList(){
       return customManagers;
    }
}
