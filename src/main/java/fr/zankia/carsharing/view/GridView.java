package fr.zankia.carsharing.view;

import fr.zankia.carsharing.Controller;
import fr.zankia.carsharing.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

public class GridView extends JPanel implements IMapView, MouseListener {
    private final int squareSize = 20;
    private IPassenger lastInserted;


    public GridView(){
        int boardWidth = 25;
        int boardHeight = 25;
        Dimension boardDimension = new Dimension(boardWidth * squareSize, boardHeight * squareSize);
        setMinimumSize(boardDimension);
        setMaximumSize(boardDimension);
        setPreferredSize(boardDimension);
        addMouseListener(this);
    }


    @Override
    public void paintComponent(Graphics g) {
        ICityState cityState = Controller.getInstance().getCityState();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(),getHeight());
        /*
        g.setColor(Color.LIGHT_GRAY);
        for(int i = 0; i<boardHeight;i++)
            for(int j = 0; j<boardWidth; j++)
                if(i%(app.blockSize+1)!=0 && j%(app.blockSize+1)!=0)
                    g.fillRect(i*squareSize,j*squareSize,squareSize,squareSize);
        g.setFont(new Font(g.getFont().getFontName(),Font.BOLD,2*squareSize/3));
        */
        for(IVehicle car : cityState.getVehicles()) {
            drawCar(g, car);
        }
        for(Point2D cli : cityState.getLocations()) {
            drawClientPos(g, cli);
        }
        for(Point2D cli : cityState.getDestinations()) {
            drawClientTarget(g, cli);
        }
    }


    private void drawCar(Graphics g, IVehicle car) {
        g.setColor(Color.RED);
        int x = getRelativeCoordinates((float) car.getLocation().getX());
        int y = getRelativeCoordinates((float) car.getLocation().getY());
        g.fillPolygon(
                new int[] {
                        x,
                        x + divideSquare(4),
                        x + divideSquare(2),
                        x + 3 * divideSquare(4),
                        x + divideSquare(1),
                        x + divideSquare(1),
                        x
                },
                new int[] {
                        y + divideSquare(2),
                        y + divideSquare(4),
                        y + divideSquare(4),
                        y + divideSquare(2),
                        y + divideSquare(2),
                        y + 3 * divideSquare(4),
                        y + 3 * divideSquare(4)
                },
                7
        );
        g.fillOval(
                x + divideSquare(8),
                y + 5 * divideSquare(8),
                divideSquare(4),
                divideSquare(4)
        );
        g.fillOval(
                x + 5 * divideSquare(8),
                y + 5 * divideSquare(8),
                divideSquare(4),
                divideSquare(4)
        );
    }


    private void drawClientPos(Graphics g, Point2D cli) {
        g.setColor(Color.BLUE);
        int x = getRelativeCoordinates((float) cli.getX());
        int y = getRelativeCoordinates((float) cli.getY());
        g.drawPolygon(
                new int[] {
                        x + divideSquare(4),
                        x + 3 * divideSquare(4),
                        x + 3 * divideSquare(4),
                        x + divideSquare(2),
                        x + divideSquare(4)
                },
                new int[] {
                        y + divideSquare(4),
                        y + divideSquare(4),
                        y + divideSquare(1),
                        y + 3 * divideSquare(4),
                        y + divideSquare(1)
                },
                5
        );
        g.drawOval(
                x + 3 * divideSquare(8),
                y,
                divideSquare(4),
                divideSquare(4)
        );
    }


    private void drawClientTarget(Graphics g, Point2D cli) {
        g.setColor(Color.BLUE);
        int x = getRelativeCoordinates((float) cli.getX());
        int y = getRelativeCoordinates((float) cli.getY());
        g.fillPolygon(
                new int[] {
                        x + divideSquare(4),
                        x + 3 * divideSquare(4),
                        x + divideSquare(4)
                },
                new int[] {
                        y,
                        y + divideSquare(4),
                        y + divideSquare(2)
                },
                3
        );
        g.drawLine(
                x + divideSquare(4),
                y,
                x + divideSquare(4),
                y + divideSquare(1)
        );
    }


    private int getRelativeCoordinates(float location) {
        return Math.round(location) * squareSize;
    }


    private int divideSquare(int i) {
        return squareSize / i;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        Controller controller = Controller.getInstance();
        int button = e.getButton();
        int x = e.getX() / squareSize;
        int y = e.getY() / squareSize;
        Point2D location = new Point2D.Double(x, y);

        if (button == MouseEvent.BUTTON1) {
            if (lastInserted != null) {
                lastInserted.setDestination(location);
                lastInserted = null;
            } else {
                lastInserted = new Passenger(location);
                controller.getCityState().addPoint(lastInserted);
            }
        } else if (button == MouseEvent.BUTTON3) {
            controller.getCityState().addVehicle(new Vehicle(4, location));
        }
        this.repaint();
    }


    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void update() {
        this.repaint();
    }
}
