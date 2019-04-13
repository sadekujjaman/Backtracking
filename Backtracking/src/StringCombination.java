
import java.util.Arrays;


/**
 *
 * @author Sadekujjaman Saju
 */
public class StringCombination {
    
    private static String str = "ABC";
    static int r = 3;
    static String ans = "";
    static char[] ansArr = new char[100];
    static int taken[] = new int[100];
      
    public static void main(String[] args) {
        ansArr[r] = '\0';
        call(0, 0);
        
        
        System.out.println("");
        System.out.println("");
        Arrays.fill(taken, 0);
        ansArr = new char[100];
        ansArr[r] = '\0';
        call1(0, 0);
    }
    
    
    private static void call(int i, int j){
        
        if(i == str.length())
            return;
        
        if(j == r){
            System.out.println(ansArr);
            return;
        }
//        ans += str.charAt(i);
        
        ansArr[j] = str.charAt(i);
        call(i, j + 1);
        
        call(i + 1, j);
    }
    
    
    
    private static void call1(int i, int j){
        
        if(i == str.length())
            return;
        
        if(j == r){
            System.out.println(ansArr);
            return;
        }
//        ans += str.charAt(i);
        if(taken[i] == 0){
            taken[i] = 1;
            ansArr[j] = str.charAt(i);
            call1(i, j + 1);
            taken[i] = 0;
        }
        
        call1(i + 1, j);
    }
}
