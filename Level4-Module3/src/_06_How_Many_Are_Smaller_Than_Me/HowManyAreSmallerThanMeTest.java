package _06_How_Many_Are_Smaller_Than_Me;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import _05_Intro_to_AVL_Trees.AVLTree;

public class HowManyAreSmallerThanMeTest {

    private ArrayList<Integer> nums;
    private Random rand;
    
    public HowManyAreSmallerThanMeTest() {
        nums = new ArrayList<>();
        rand = new Random();
    }
    
    @Test
    public void howManyAreSmallerThanMeTest() {
        
        AVLTree<Integer> av = new AVLTree<>();
        HowManyAreSmallerThanMe hm = new HowManyAreSmallerThanMe();
        
        int totalNums = 10;
        
        while(nums.size() < totalNums) {
            int randomNum = rand.nextInt(20) + 1;
            
            if(!nums.contains(randomNum)) {
                nums.add(randomNum);
                av.insert(randomNum);
            }
        }
        
        av.printVertical();
        
        int me = nums.get(rand.nextInt(nums.size()));
        
        assertEquals(findSmallest(me), hm.howManyAreSmallerThanMe(av, me) );
        
    }
    
    private int findSmallest(int me) {
        
        int total = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            if(nums.get(i) < me) {
                total++;
            }
        }
        
        return total;
        
    }
    

}
