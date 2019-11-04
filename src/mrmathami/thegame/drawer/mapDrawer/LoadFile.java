package mrmathami.thegame.drawer.mapDrawer;

import java.io.*;
import java.util.ArrayList;

public class LoadFile {

   // private Map loadedMap;
    private String[][] MAP_SPRITES;
    private int width;
    private int height;
    private String name = "";
    private String userInput = "";
    private String mapInfo = "";

    private static final String folderName = "file:src/assets/images";
    private static final File directory = new File(folderName);
    private static ArrayList<String> files;
    private static String[][] mapList;


    public LoadFile(){


    }

    public void listFilesforFolder(){

        files = new ArrayList<String>();
       /* File[] listOfFiles = directory.listFiles();
        for (int i = 0; i < listOfFiles.length; i++){
            if (listOfFiles[i].isFile()) {
                String name = listOfFiles[i].getName();
                final int lastPeriodPos = name.lastIndexOf('.');
                files.add(listOfFiles[i].getName().substring(0, lastPeriodPos).toString());
            } else if (listOfFiles[i].isDirectory()) {

            }
        }*/

    }

    /**
     * Read and create a map from a text file
     * @return
     * @throws IOException
     */
    public String[][] loadFile(String name) throws IOException {
        this.name = name;
        File file = new File(folderName + "/" + name + ".txt");
        FileReader fr = new FileReader(file);
        BufferedReader br =  new BufferedReader(fr);
        int count = -3;
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            count++;
            if (count == -2){
                width = Integer.valueOf(line);
            }
            else if (count == -1){
                height = Integer.valueOf(line);
            }
            else {
                String[] word = line.split("\\s");
                for(int i = 0; i < width; i++){
                    MAP_SPRITES[count][i] = word[i];
                }
            }

            line = br.readLine();
        }

        br.close();


        return MAP_SPRITES;
    }





}

