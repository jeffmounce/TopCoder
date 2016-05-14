package challenges;

import java.util.ArrayList;
import java.util.List;

public class AlphabetPath
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

    public String doesItExist(String[] letterMaze)
    {
        String retVal = "NO";

        if( letterMaze == null )
            return retVal;

        int rows = letterMaze.length;

        if( rows == 0 )
            return retVal;

        String first = letterMaze[0];
        int cols = (first == null) ? 0 : first.length();

        if( cols == 0 )
            return retVal;

        Cell[][] grid2 = encodeGrid(letterMaze, rows, cols);

        for(int i=0; i<rows; i++)
        {
            for(int j=0;j<cols;j++)
            {
                boolean exists = doesPathExistAt(new Coordinate(i,j), (char)('A'-1), grid2, rows, cols, 25);
                if( exists )
                    return "YES";
            }
        }

        return retVal;
    }

    private boolean doesPathExistAt(Coordinate coordinate, char letterPrevious, Cell[][] grid2, int rows, int cols, int lengthRemaining)
    {
        boolean retVal = false;

        Cell c = grid2[coordinate.i][coordinate.j];

        if( letterPrevious == (c.Letter - 1) )
        {
            if( lengthRemaining == 0 )
                return true;

            List<Coordinate> coordinatesAround = getCoordinatesAround(coordinate, rows, cols);
            for(Coordinate coordinateAround : coordinatesAround)
            {
                retVal = doesPathExistAt(coordinateAround, c.Letter, grid2, rows, cols, lengthRemaining - 1);
                if( retVal )
                    break;
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
                boolean isAdjacent = (Math.abs(c.i - i) + Math.abs(c.j - j)) == 1;
                boolean isSameCoordinate = (i == c.i) && (j == c.j);
                boolean isInRowBound = i >= 0 && i < rows;
                boolean isInColBound = j >= 0 && j < cols;

                if(!isSameCoordinate && isAdjacent && isInColBound && isInRowBound)
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
