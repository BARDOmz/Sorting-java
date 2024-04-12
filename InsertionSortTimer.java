import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
/**
 * This program displays a panel which the user can implement a set amount of numbers to get a display for their number of arrays.
 * 
 */
public class InsertionSortTimer {
    public static void main(String[] args) {
        int[] saniye = new int[1000];
        int kacElement = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("First array length: ");
        int firstLength = in.nextInt();
        System.out.print("Number of arrays: ");
        int numberOfArrays = in.nextInt();
        StopWatch timer = new StopWatch();

        for (int k = 1; k <= numberOfArrays; k++) {
            int n = k * firstLength;
            int[] a = ArrayUtil.randomIntArray(n, 100);
            
            // Measure time for insertion sort
            timer.start();
            InsertionSorter.sort(a);
            timer.stop();
            System.out.printf("Insertion Sort: Length:%8d Elapsed milliseconds:%8d%n", n, timer.getElapsedTime());
            saniye[k] = (int) timer.getElapsedTime();
            timer.reset();
            
            // Measure time for bubble sort
            timer.start();
            Bubblesort.sort(a);
            timer.stop();
            System.out.printf("Bubble Sort: Length:%8d Elapsed milliseconds:%8d%n", n, timer.getElapsedTime());
            saniye[k] = (int) timer.getElapsedTime();
            timer.reset();
            
            kacElement = k;
        }

        System.out.printf("# elements %d%n", kacElement);
        for (int j = 0; j <= kacElement; j++) {
            if (j % 10 == 0)
                System.out.println();
            System.out.printf("%5d", saniye[j]);
        }
         
        GraphDrawer.drawGraph(saniye, kacElement) ;
        
        JFrame frame = new JFrame("Line Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        LineGraphDrawer3 graphDrawer = new LineGraphDrawer3(saniye, kacElement);
        frame.add(graphDrawer);
        frame.setVisible(true);

        
    }
}

