
import java.util.Scanner;

/**
 *
 * @author Sadekujjaman Saju
 */
public class NQueen {

    static int row[] = new int[1000];
    static int plus[] = new int[1000];
    static int minus[] = new int[1000];

    static int ans[] = new int[100];
    
    static int n = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        calculateNQueen(1);
        
        sc.close();
    }

    private static void calculateNQueen(int column) {

        if(column > n){
            for(int i = 1; i <= n; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println("");
            return;
        }
        
        for (int i = 1; i <= n; i++) {

            if (row[i] == 0 && minus[n + i - column] == 0 && plus[i + column] == 0) {
                ans[column] = i;
                minus[n + i - column] = 1;
                plus[i + column] = 1;
                row[i] = 1;

                calculateNQueen(column + 1);

                minus[n + i - column] = 0;
                plus[i + column] = 0;
                row[i] = 0;
            }

        }

    }
}
