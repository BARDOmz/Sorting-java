

import java.util.Arrays;
/**
 * This class draws the graphs x and y numbers and the graph itself.
 *
 */
public class GraphDrawer {
    public static void main(String[] args) {
        int[] array = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100};
        // drawGraph(array);
    }

    public static void drawGraph(int[] array, int size) {
        int step = size / 10;
        int maxValue = Arrays.stream(array).max().orElse(0);
        for (int i = 0; i <= size; i += step) {
            int value = array[i];
            int barLength = (int) ((double) value / maxValue * 40);
            String bar = repeatCharacter('#', barLength);
            System.out.printf("%3d |%s%n", value, bar);
        }
    
    }

    public static String repeatCharacter(char character, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
        return sb.toString();
    }
}
