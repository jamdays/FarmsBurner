package main.java.data_access;

import main.java.entity.Farm;
import main.java.use_case.load.LoadDataAccessInterface;
import main.java.use_case.save.SaveDataAccessInterface;

import java.io.*;

public class SaveFileAccess implements SaveDataAccessInterface, LoadDataAccessInterface{

    @Override
    public void saveData(Farm farm) throws IOException {
        FileOutputStream fileOutputStream
                = new FileOutputStream("save.txt");
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(farm);
        objectOutputStream.flush();
        objectOutputStream.close();

    }

    @Override
    public Farm loadData() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream
                = new FileInputStream("save.txt");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        Farm out = (Farm) objectInputStream.readObject();
        objectInputStream.close();
        return out;
    }
}