/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textanalyzer;

/**
 *
 * @author mnivota
 */
public class Tuple implements Comparable{
    
    String word;
    int count;
    
    Tuple(String wrd, int cnt) {
        word = wrd;
        count = cnt;
    }
    
    @Override
    public String toString() {
        return  "["+ word + ", " + count + "]";
    }

    @Override
    public int compareTo(Object o) {
        Tuple arg0 = (Tuple) o;
        if (this.count > arg0.count) {
            return -1;
        }
        else if (this.count < arg0.count) {
            return 1;
        }
        else {
            return 0;
        }
    }
    
}
