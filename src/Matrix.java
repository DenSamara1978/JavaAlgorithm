public class Matrix {
    private int[][] arr;
    private int dim;

    public Matrix ( int dimension )
    {
        dim = dimension;
        arr = new int [dim][dim];
    }

    public String toString ()
    {
        StringBuilder result = new StringBuilder ();
        for ( int row = 0; row < dim; ++row ) {
            for ( int col = 0; col < dim; ++col ) {
                result.append ( arr [row][col] );
                if ( col != dim - 1 )
                    result.append ( ", ");
            }
            result.append ( "\n" );
        }
        return result.toString();
    }

    public void clear ()
    {
        for ( int row = 0; row < dim; ++row )
            for ( int col = 0; col < dim; ++col )
                arr [row][col] = 0;
    }

    public void setIdentity ()
    {
        for ( int row = 0; row < dim; ++row )
            for ( int col = 0; col < dim; ++col )
                arr [row][col] = ( row == col ) ? 1 : 0;
    }

    public void fillWithSpiral ()
    {
        clear ();
        // Переменная направления 1-вправо, 2-вниз, 3-влево, 4-вверх
        int dir = 1;
        int row = 0, col = 0;
        for ( int n = 1; n <= dim * dim; ++n )
        {
            arr [row][col] = n;
            if ( n == dim * dim )
                break;
            boolean escape = false;
            while ( !escape ) {
                switch (dir) {
                    case 1:
                        if (col == dim - 1)
                            ++dir;
                        else if ( arr[row][col + 1] != 0 )
                            ++dir;
                        else {
                            ++col;
                            escape = true;
                        }
                        break;
                    case 2:
                        if (row == dim - 1)
                            ++dir;
                        else if ( arr[row + 1][col] != 0 )
                            ++dir;
                        else {
                            ++row;
                            escape = true;
                        }
                        break;
                    case 3:
                        if (col == 0)
                            ++dir;
                        else if ( arr[row][col - 1] != 0 )
                            ++dir;
                        else {
                            --col;
                            escape = true;
                        }
                        break;
                    case 4:
                        if (row == 0)
                            dir = 1;
                        else if ( arr[row - 1][col] != 0 )
                            dir = 1;
                        else {
                            --row;
                            escape = true;
                        }
                        break;
                    default:
                        escape = true;
                        break;
                }
            }
        }
    }
}
