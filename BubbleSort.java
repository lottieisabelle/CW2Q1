// Bubble sort algorithm

import java.io.*;

public class BubbleSort {
    private int numberCommas = 0;

    /**
     * constructor
     */
    public BubbleSort(){

    }

    // TODO TAKE OUT MAYBE
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
    private String[] readFile(String fileName) {

        try {
            File file = new File(fileName); // attempts to find file

            // TODO change this to your local file path
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\lotti\\IdeaProjects\\CW2\\src\\names.txt"));

            String s;
            int x = 0;

            while ((s = reader.readLine()) != null) {
                x = s.length();
                // counts the number of commas
                for (int i = 0; i < s.length() - 1; i++) {
                    if (s.charAt(i) == ',') {
                        numberCommas++;
                    }
                }
            }
            reader.close();

            // TODO change this to your local file path
            BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\lotti\\IdeaProjects\\CW2\\src\\names.txt"));

            String[] nameList = new String[numberCommas+1];
            int listPointer = 0; // pointer for the nameList array
            // holder for the current name
            String newName = "";

            while ((s = fileReader.readLine()) != null){
                for (int j = 0; j < x-1; j++){

                    if (s.charAt(j) == ','){
                        nameList[listPointer] = newName;
                        newName = ""; // reset name string
                        listPointer++; // increment pointer
                    } else if (s.charAt(j) != '"'){
                        newName = newName + s.charAt(j);
                    }
                }
                nameList[listPointer] = newName;
                newName = ""; // reset name string
                listPointer++; // increment pointer
            }
            fileReader.close();

            return nameList;
        }
        catch(FileNotFoundException e) {
            System.out.println("Error. File not found.");
            e.printStackTrace();
            System.exit(0);
            return null;
        }
        catch(IOException e) {
            System.out.println("Error reading file.");
            System.exit(0);
            return null;
        }
    }

    /** bubble sort algorithm
     *
     * @param list : list of items to sort
     */
    private String[] sort(String[] list){
        boolean isEqual;
        boolean yIsShorter = true;
        boolean swap = true;

        for (int x = 0; x < list.length-1; x++){
            for (int y = 0; y < list.length-1; y++){
                isEqual = true;

                int maxIndex = list[y].length(); // length of the shortest name in the comparison
                if (list[y].length() > list[y+1].length()){
                    yIsShorter = false;
                    maxIndex = list[y+1].length();
                }

                int counter = 0;
                while(isEqual){
                    if (counter == maxIndex){
                        if (!yIsShorter){
                            String temp = list[y];
                            list[y] = list[y+1];
                            list[y+1] = temp;
                        }
                        break;
                    }

                    if (list[y].charAt(counter) == list[y+1].charAt(counter)){
                        counter++;
                    } else {
                        isEqual = false;
                    }
                }

                if (counter != maxIndex){
                    if (list[y].charAt(counter) > list[y+1].charAt(counter)){
                        String temp = list[y];
                        list[y] = list[y+1];
                        list[y+1] = temp;
                    }
                }
            }
        }
        return list;
    }

    private void writeFile(String[] list){
        try {
            // TODO change this to your local file path
            FileWriter fileWriter = new FileWriter("C:\\Users\\lotti\\IdeaProjects\\CW2\\src\\sortedNames.txt");

            for (int i = 0; i < list.length; i++){
                if (i == list.length-1){
                    fileWriter.write('"' + list[i] + '"');
                } else {
                    fileWriter.write('"' + list[i] + '"' + ',');
                }
            }
            fileWriter.close();

        } catch (IOException e){
            System.out.println("Error writing to file. Check the file path.");
            System.exit(0);
        }
    }

    public static void main(String[] args){
        BubbleSort bubbleSort = new BubbleSort();

        System.out.println("Welcome to the Bubble Sort Algorithm");

        String[] ListOfNames = bubbleSort.readFile("names.txt");
        System.out.println("Names have been read into the program.");

        String[] sortedNames = bubbleSort.sort(ListOfNames);
        System.out.println("Names have been sorted into alphabetical order.");

        bubbleSort.writeFile(sortedNames);
        System.out.println("Names have been saved in a new file.");
    }
}

