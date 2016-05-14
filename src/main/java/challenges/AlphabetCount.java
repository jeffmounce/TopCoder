package challenges;

import java.util.ArrayList;
import java.util.List;

public class AlphabetCount
{
    private class Coordinate
    {
        public int i;
        public int j;

        public Coordinate(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
    }

    private class Cell
    {
        public char Letter;
        public Coordinate Position;

        public Cell(char letter, Coordinate position)
        {
            Letter = letter;
            Position = position;
        }
    }

    public int count(String[] grid, int length)
    {
        int retVal = 0;

        if( length == 0 )
            return retVal;

        if( grid == null )
            return retVal;

        int rows = grid.length;

        if( rows == 0 )
            return retVal;

        String first = grid[0];
        int cols = (first == null) ? 0 : first.length();

        if( cols == 0 )
            return retVal;


        Cell[][] grid2 = encodeGrid(grid, rows, cols);

        for(int i=0; i<rows; i++)
        {
            for(int j=0;j<cols;j++)
            {
                retVal += countPathsAt(new Coordinate(i,j), (char)('A'-1), grid2, rows, cols, length - 1);
                if( retVal >= 1000000 )
                {
                    retVal = 1000000;
                    return retVal;
                }
            }
        }

        return retVal;
    }

    private int countPathsAt(Coordinate coordinate, char letterPrevious, Cell[][] grid2, int rows, int cols, int lengthRemaining)
    {
        int retVal = 0;

        Cell c = grid2[coordinate.i][coordinate.j];

        if( letterPrevious == (c.Letter - 1) )
        {
            if( lengthRemaining == 0 )
                return 1;

            List<Coordinate> coordinatesAround = getCoordinatesAround(coordinate, rows, cols);
            for(Coordinate coordinateAround : coordinatesAround)
            {
                retVal += countPathsAt(coordinateAround, c.Letter, grid2, rows, cols, lengthRemaining - 1);
                if( retVal >= 1000000 )
                {
                    retVal = 1000000;
                    return retVal;
                }
            }
        }

        return retVal;
    }

    private List<Coordinate> getCoordinatesAround(Coordinate c, int rows, int cols)
    {
        int iL = c.i - 1;
        int iU = c.i + 1;
        int jL = c.j - 1;
        int jU = c.j + 1;

        List<Coordinate> retVal = new ArrayList<>();

        for(int i=iL; i<=iU; i++)
        {
            for(int j=jL; j<=jU; j++)
            {
                boolean isSameCoordinate = (i == c.i) && (j == c.j);
                boolean isInRowBound = i >= 0 && i < rows;
                boolean isInColBound = j >= 0 && j < cols;

                if(!isSameCoordinate && isInRowBound && isInColBound)
                {
                    retVal.add(new Coordinate(i,j));
                }
            }
        }

        return retVal;
    }

    private Cell[][] encodeGrid(String[] grid, int rows, int cols)
    {
        Cell[][] retVal = new Cell[rows][cols];

        for(int i=0; i<rows; i++)
        {
            String row = grid[i];

            for (int j=0; j<cols; j++)
            {
                char letter = row.charAt(j);
                retVal[i][j] = new Cell(letter, new Coordinate(i,j));
            }
        }

        return retVal;
    }
}
