
import javax.swing.*;
import java.awt.*;

public class FractalTree extends JPanel {

    private final int MAX_DEPTH = 9;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Start the tree at the bottom center
        int startX = getWidth() / 2;
        int startY = getHeight() - 50;

        drawTree(g, startX, startY, -90, MAX_DEPTH);
    }

    /**
     * Recursively draws a fractal tree.
     */
    private void drawTree(Graphics g, int x1, int y1,
                          double angle, int depth) {

        // 1. Base case: stop when depth reaches zero
        if (depth == 0) {
            return;
        }

        // 2. Calculate the branch length
        int length = depth * 10;

        // 3. Convert the angle to radians
        double radians = Math.toRadians(angle);

        // 4. Calculate the endpoint of the branch
        int x2 = x1 + (int) (length * Math.cos(radians));
        int y2 = y1 + (int) (length * Math.sin(radians));

        // 5. Draw the branch
        g.drawLine(x1, y1, x2, y2);

        // 6. Recursively draw the left branch
        drawTree(g, x2, y2, angle - 20, depth - 1);

        // 7. Recursively draw the right branch
        drawTree(g, x2, y2, angle + 20, depth - 1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.add(new FractalTree());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
