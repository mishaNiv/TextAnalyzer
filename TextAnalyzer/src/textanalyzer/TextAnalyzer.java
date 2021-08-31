/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textanalyzer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author mnivota
 */
public class TextAnalyzer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
              
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Tuple> tuples = new ArrayList<>();
        ArrayList<String> useless = new ArrayList<>();
        
        //adding the words in beowulf that are not in useless to list
        addNotInUseless(list, useless); 
 
        //converting all of the Strings in list to lowercase
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).toLowerCase());
        }
        
        //sorting list by alphabetical order
        Collections.sort(list);      

        //putting the words in list into Tuple by calling the listToTuple function
        listToTuple(list, tuples);
             
        //sorting the Tuples in tuples by their count, greatest to least
        tuples.sort(null);

        //printing the top ten most common words from tuples
        printFirstTen(tuples);
    } 
    
    public static void addNotInUseless(ArrayList<String> lists, ArrayList<String> useless){
        
        //putting all of the words in useless.txt in the ArrayList useless
        InputStream use = TextAnalyzer.class.getResourceAsStream("useless.txt"); 
        Scanner u = new Scanner(use);
        
        while (u.hasNext()) {
            useless.add(u.next());
        }
        
        //putting all of the words in Beowulf in the ArrayList list, except the words that are also in useless
        InputStream is = TextAnalyzer.class.getResourceAsStream("beowulf.txt");        
        Scanner s = new Scanner(is);      
        
        String str;
        while (s.hasNext()) {
            str = s.next();
            if (!useless.contains(str)) {
                    lists.add(str);
            }
        }        
    }
    
    public static void listToTuple(ArrayList<String> lists, ArrayList<Tuple> tuple) {
        
        int cnt = 1; //count
        String check = ""; //will be the previous word
        String last = ""; //to add the last word in list to tuples
        
        //putting all of the words in list and their count in Tuples in the tuples ArrayList
        for (String indx : lists) { //for each word (indx) in list
            last = indx;
            if (indx.equals(check)) { //if indx is the same as the previous word (check)
                cnt++;
            }
            else if (!check.equals("")){ //if it isn't the same as 
                tuple.add(new Tuple(check, cnt));
                cnt = 1;
                check = indx;
            }
            else {
                check = indx;
            }
        }
        tuple.add(new Tuple(last, cnt)); //had to add in this line because either the first word
                                          // wasn't added to the list or the last word wasn't, so I
                                          // added the last one separately
    }
    
    public static void printFirstTen(ArrayList<Tuple> tuple) {
         for (int i = 0; i < 10; i++) {
            System.out.println((tuple.get(i)).toString()); //printing first 10 words
        }
    }
    
}
