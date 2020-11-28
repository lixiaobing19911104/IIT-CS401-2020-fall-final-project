package Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class ProjectTest {
    private final static int    SIZE                   = 4000;
    private final static String FRUIT_FILE_PATH_FORMAT = "src%sProject%sfruit.txt";

    public static void main(String[] args) throws Exception {
        //Create these inputs
        final Integer[] unsortedList = createRandomIntegerList();

        final Integer[] sortedList = sortList(unsortedList);

        final String[] unsortedFruits = createUnsortedFruitListFromFile();

        final String[] sortedFruits = sortFruits(unsortedFruits);

        // Create the int and String linklist from the Array
        GeneralLinkedList<Integer> unsortedIntegerList = GeneralLinkedList.fromArray(unsortedList);
        System.out.println("The top element of unsorted random list is " + unsortedIntegerList.top());

        GeneralLinkedList<Integer> sortedIntegerList = GeneralLinkedList.fromArray(sortedList);
        System.out.println("The top element of sorted list is " + sortedIntegerList.top());

        GeneralLinkedList<String> unsortedStringList = GeneralLinkedList.fromArray(unsortedFruits);
        System.out.println("The top element of unsorted random fruits is " + unsortedStringList.top());

        GeneralLinkedList<String> sortedStringList = GeneralLinkedList.fromArray(sortedFruits);
        System.out.println("The top element of sorted fruits is " + sortedStringList.top());

        // BinarySearchTree
        BinarySearchTree<Integer> bstintunsort = new BinarySearchTree(unsortedList);

        BinarySearchTree<Integer> bstintsort      = new BinarySearchTree(sortedList);
        BinarySearchTree<String>  bstStringunsort = new BinarySearchTree(unsortedFruits);
        BinarySearchTree<String>  bstStringsort   = new BinarySearchTree(unsortedFruits);
        //find Arrayunsort
        SearchHelper.exhaustiveSearch(unsortedList, 16578964);
        //find Arraysort
        SearchHelper.binarySearch(sortedList, 16578964);
        //find intlistunsort
        unsortedIntegerList.find(16579864);
        //find intlistsort
        sortedIntegerList.find(16579864);
        //find Listunsort
        unsortedStringList.find("Watermelon");
        //find Listsort
        sortedStringList.find("Orange");
        //find BST unsort int
        bstintunsort.contains(12609785);
        System.out.println(String.format("12609785%s数字列表里", bstintsort.contains(12609785) ? "在" : "不在"));

        //find BST sort int
        bstintsort.contains(12609785);
        System.out.println(String.format("12609785%s数字列表里", bstintsort.contains(12609785) ? "在" : "不在"));

        //find BST unsort String
        System.out.println(String.format("orange%s水果列表里", bstStringunsort.contains("Orange") ? "在" : "不在"));
        //find BST sort String
        System.out.println(String.format("Watermelon%s水果列表里", bstStringunsort.contains("Watermelon") ? "在" : "不在"));

    }


    /**
     * create random integer list
     *
     * @return
     */
    private static Integer[] createRandomIntegerList() {
        Random          random       = new Random();
        final Integer[] unsortedList = new Integer[SIZE];
        for (int i = 1; i <= SIZE; i++) {
            unsortedList[i - 1] = random.nextInt();
        }
        System.out.println("random integer list: " + Arrays.asList(unsortedList));
        return unsortedList;
    }

    /**
     * sort list
     *
     * @param unsortedList
     * @return
     */
    private static Integer[] sortList(Integer[] unsortedList) {
        Integer[] sortedList = unsortedList.clone();
        SortHelper.bubbleSort(sortedList);
        System.out.println("sorted integer list: " + Arrays.asList(sortedList));
        return sortedList;
    }

    /**
     * create unsorted fruits list
     *
     * @return
     * @throws IOException
     */
    private static String[] createUnsortedFruitListFromFile() throws IOException {
        InputStreamReader str = new InputStreamReader(new FileInputStream(
                String.format(FRUIT_FILE_PATH_FORMAT, File.separator, File.separator)));
        BufferedReader productName = new BufferedReader(str);
        //Line Object
        String line = "";
        //Save the necessary Data
        String[] unsortedFruits = new String[100];
        //Cycle every line and get the necessary data;
        int a = 0;
        while ((line = productName.readLine()) != null) {
            unsortedFruits[a] = line;
            a++;
        }
        System.out.println("unsorted fruits: " + Arrays.asList(unsortedFruits));
        return unsortedFruits;
    }

    /**
     * sort fruits
     *
     * @param unsortedFruits
     * @return
     */
    private static String[] sortFruits(String[] unsortedFruits) {
        String[] sortedFruits = unsortedFruits.clone();
        SortHelper.bubbleSort(sortedFruits);
        System.out.println("sorted random list: " + Arrays.asList(sortedFruits));
        return sortedFruits;
    }


}


