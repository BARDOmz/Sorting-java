import java.awt.*;
import javax.swing.*;
/**
 * This displays the graphs line/curve.
 * 
 */
public class LineGraphDrawer3 extends JPanel {
    private int[] array;
    private int length;

    public LineGraphDrawer3(int[] array, int length) {
        this.array = array;
        this.length = length;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int maxValue = getMaxValue();
        int size = length;
        int graphHeight = height - 60;
        int barWidth = width / size;

        g.setColor(Color.BLACK);
        g.drawLine(50, height - 40, width - 10, height - 40);

        int tickWidth = (width - 60) / 5;
        for (int i = 0; i < 6; i++) {
            int x = 50 + i * tickWidth;
            int y = height - 40;
            g.drawLine(x, y, x, y + 5);
            String label = Integer.toString(i * 20);
            g.drawString(label, x - 10, y + 20);
        }
        g.drawString("x-axis", width - 60, height - 20);

        g.drawLine(50, 20, 50, height - 50);
        int tickHeight = graphHeight / 5;
        for (int i = 0; i < 6; i++) {
            int x = 50;
            int y = height - 50 - i * tickHeight;
            g.drawLine(x - 5, y, x, y);
            String label = Integer.toString(i * (maxValue / 5));
            g.drawString(label, x - 30, y + 5);
        }
        g.drawString("y-axis", 10, height - 40);

        g.setColor(Color.BLUE);
        for (int i = 0; i < size - 1; i++) {
            int x1 = 50 + i * barWidth;
            int y1 = height - 40 - (int) ((double) array[i] / maxValue * graphHeight);
            int x2 = 50 + (i + 1) * barWidth;
            int y2 = height - 40 - (int) ((double) array[i + 1] / maxValue * graphHeight);
            g.drawLine(x1, y1, x2, y2);
        }
    }
    /**
     * This program gets the Maxvalue from the integer.
     */
    private int getMaxValue() {
        int maxValue = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
