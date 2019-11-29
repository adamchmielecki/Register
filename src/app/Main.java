package app;

public class Main {

    public static void main(String[] args) {

        Data.loadData();

        GUI.runRegister();

        Data.saveData();

    }
}
