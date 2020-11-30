package Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ProjectTest {
    private final static int    SIZE                   = 2000;
    private final static String FRUIT_FILE_PATH_FORMAT = "src%sProject%sfruit.txt";


    public static void main(String[] args) throws Exception {
        //Create these inputs
        String type1;
        String type2;
        String type3;
        int    number1;
        String fruitname1;


        System.out.print("Please input the type of data you want, int or String: ");
        Scanner data = new Scanner(System.in);
        type1 = data.next();


        System.out.println("Please input the type of database you want for search, Array, Linklist or BinarySearchTree:");
        Scanner database = new Scanner(System.in);
        type2 = database.next();


        System.out.println("Please input whether you like sorted data or not, sorted or unsorted: ");
        Scanner sort = new Scanner(System.in);
        type3 = sort.next();


        //Choose int 
        if (type1.equals("int")) {
            // Create the Random int Array
            final Integer[] unsortedList = createRandomIntegerList();
            final Integer[] sortedList   = sortList(unsortedList);
            System.out.println("Please enter a random number: ");
            Scanner number = new Scanner(System.in);
            number1 = number.nextInt();
            //Choose int and Array;
            if (type2.equals("Array")) {
                if (type3.equals("unsorted")) {
                    //find intArrayunsort
                    SearchHelper.exhaustiveSearch(unsortedList, number1);
                } else if (type3.equals("sorted")) {
                    //find intArraysort
                    SearchHelper.binarySearch(sortedList, number1);
                }
            }


            // Choose int and Linklist
            else if (type2.equals("Linklist")) {
                if (type3.equals("unsorted")) {
                    GeneralLinkedList<Integer> unsortedIntegerList = GeneralLinkedList.fromArray(unsortedList);
                    System.out.println("The top element of unsorted random list is " + unsortedIntegerList.top());
                    //find intlistunsort
                    unsortedIntegerList.find(number1);
                } else if (type3.equals("sorted")) {
                    GeneralLinkedList<Integer> sortedIntegerList = GeneralLinkedList.fromArray(sortedList);
                    System.out.println("The top element of sorted list is " + sortedIntegerList.top());
                    //find intlistsort
                    sortedIntegerList.find(number1);
                }
            }

            // Choose int and BST
            else if (type2.equals("BinarySearchTree")) {
                if (type3.equals("unsorted")) {
                    BinarySearchTree<Integer> bstintunsort = new BinarySearchTree(unsortedList);
                    //find BST unsort int
                    System.out.println(String.format("The item is %s integer list", bstintunsort.contains(number1) ? "in" : "not in"));
                    System.out.print(bstintunsort.searchcount(number1));
                } else if (type3.equals("sorted")) {
                    BinarySearchTree<Integer> bstintsort = new BinarySearchTree(sortedList);
                    //find BST sort int
                    System.out.println(String.format("The item is %s integer list", bstintsort.contains(number1) ? "in" : "not in"));
                    System.out.print(bstintsort.searchcount(number1));
                }
            }


            //String database
        }
        if (type1.equals("String")) {
            // Create the String Array
            final String[] unsortedFruits = createUnsortedFruitListFromFile();
            final String[] sortedFruits   = sortFruits(unsortedFruits);
            System.out.println("Please enter a fruit name: ");
            Scanner fruitname = new Scanner(System.in);
            fruitname1 = fruitname.next();

            //String and Array
            if (type2.equals("Array")) {
                if (type3.equals("unsorted")) {
                    //find StringArrayunsort
                    SearchHelper.exhaustiveSearch(unsortedFruits, fruitname1);
                } else if (type3.equals("sorted")) {
                    //find StringArayysort
                    SearchHelper.binarySearch(sortedFruits, fruitname1);

                }
            }

            //String and Linklist
            else if (type2.equals("Linklist")) {
                if (type3.equals("unsorted")) {
                    GeneralLinkedList<String> unsortedStringList = GeneralLinkedList.fromArray(unsortedFruits);
                    //find Listunsort
                    unsortedStringList.find(fruitname1);
                } else if (type3.equals("sorted")) {
                    GeneralLinkedList<String> sortedStringList = GeneralLinkedList.fromArray(sortedFruits);
                    //find Listsort
                    sortedStringList.find(fruitname1);
                }
            }

            //String and BST
            else if (type2.equals("BinarySearchTree")) {
                if (type3.equals("unsorted")) {
                    BinarySearchTree<String> bstStringunsort = new BinarySearchTree(unsortedFruits);
                    //find BST unsort String
                    System.out.println(String.format("The item is %s String list", bstStringunsort.contains(fruitname1) ? "in" : "not in"));
                        System.out.print(bstStringunsort.searchcount(fruitname1));
                } else if (type3.equals("sorted")) {
                    BinarySearchTree<String> bstStringsort = new BinarySearchTree(unsortedFruits);
                    //find BST sort String
                    System.out.println(String.format("The item is %s String list", bstStringsort.contains(fruitname1) ? "in" : "not in"));
                        System.out.print(bstStringsort.searchcount(fruitname1));
                }
            }
        } else {
            System.out.print("Cannot find the things you want.");
        }
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



