// Bubble sort algorithm

import java.io.*;
import java.util.ArrayList;

public class BubbleSort {
    // TODO change to a list of strings
    // TODO change to a data type that is allowed or i made myself
    ArrayList<Integer> list = new ArrayList<Integer>();

    /**
     * constructor
     */
    public BubbleSort(){

    }

    private String readFileName(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            //Keep on accepting input from the command-line
            while(true) {
                String line = reader.readLine();

                //Close on an End-of-file (EOF) (Ctrl-D on the terminal)
                if(line == null)
                {
                    //Exit code 0 for a graceful exit
                    System.exit(0);
                }

                return line;
            }
        } catch(IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return null;
    }

    /**
     * Reads the text from file. Stores text in an array.
     *
     * @param fileName : Name of the file.
     */
    protected void readFile(String fileName) {

        try {
            File file = new File(fileName); // attempts to find file

            // file reader reads text files in the default encoding
            FileReader fileReader = new FileReader(fileName);
            // always wrap file reader in buffered reader
            BufferedReader reader = new BufferedReader(fileReader);
            String s;

            ArrayList<String> names = new ArrayList<String>();

            while ((s = reader.readLine()) != null){

                String[] split = s.split(",");

                for (int i = 0; i < split.length;){
                    names.add(split[i]);
                    System.out.println(split[i]);
                }
            }
            reader.close();


            /*
            do {
                s = reader.readLine(); // reads first line of file
            }

            while ((s.length() > 3) && (!s.substring(0,4).equals("name")));{
                mapName = s.replace("name ", "");
            }

            do {
                s = reader.readLine(); // reads second line of file
            }

            while ((s.length() > 2) && (!s.substring(0,3).equals("win")));{
                String[] split = s.split(" ");
                goldRequired = Integer.parseInt(split[1]);
            }
            */
        }
        catch(FileNotFoundException e) {
            System.out.println("Error. File not found.");
            System.exit(0);
        }
        catch(IOException e) {
            System.out.println("Error reading file.");
            System.exit(0);
        }
    }

    /** bubble sort algorithm
     *
     * @param list : list of items to sort
     */
    private void sort(ArrayList<Integer> list){

        // TODO - change to comparing ascii values
        for (int x = 0; x < list.size()-1; x++){
            for (int y = 0; y < list.size()-1; y++){
                if (list.get(y) > list.get(y+1)){
                    int temp = list.get(y);
                    list.set(y, list.get(y+1));
                    list.set(y+1, temp);

                    // TODO output lists (DEBUG)
                    System.out.println(list);
                }
            }
        }
    }

    public static void main(String[] args){
        BubbleSort bubbleSort = new BubbleSort();

        
        bubbleSort.list.add(21);
        bubbleSort.list.add(3);
        bubbleSort.list.add(33);
        bubbleSort.list.add(1);
        bubbleSort.list.add(7);
        bubbleSort.list.add(4);
        bubbleSort.list.add(2);
        bubbleSort.list.add(33);


        /*
        bubbleSort.list.add("f");
        bubbleSort.list.add("z");
        bubbleSort.list.add("m");
        bubbleSort.list.add("t");
        bubbleSort.list.add("g");
        bubbleSort.list.add("a");
        bubbleSort.list.add("s");
        bubbleSort.list.add("d");
        */


        System.out.println(bubbleSort.list);

        bubbleSort.sort(bubbleSort.list);

        //
        System.out.println("Welcome to the Bubble Sort Algorithm");
        System.out.println("Please enter the name of your text file, including .txt: ");

        // String inputFile = bubbleSort.readFileName();


        // TODO read a list of names from a file
        // TODO store these names
        // TODO compare ascii values of these words to swap them

    }
}

