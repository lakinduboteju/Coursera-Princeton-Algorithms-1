import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class WeightedQuickUnionUF_Test
{
    /**
     * All the steps in this test are the exact steps followed in Weighted Quick-union demo
     * from Quick Union Improvements lecture video.
     */
    @Test
    public void weightedQuickUnionDemo()
    {
        // Initialize a QuickFindUF for 10 number of components
        WeightedQuickUnionUF wquuf = new WeightedQuickUnionUF( 10 );

        wquuf.union( 4, 3 );
        assertArrayEquals( new int[]{ 0, 1, 2, 4, 4, 5, 6, 7, 8, 9 }, wquuf.getIdArray() );

        wquuf.union( 3, 8 );
        assertArrayEquals( new int[]{ 0, 1, 2, 4, 4, 5, 6, 7, 4, 9 }, wquuf.getIdArray() );

        wquuf.union( 6, 5 );
        assertArrayEquals( new int[]{ 0, 1, 2, 4, 4, 6, 6, 7, 4, 9 }, wquuf.getIdArray() );

        wquuf.union( 9, 4 );
        assertArrayEquals( new int[]{ 0, 1, 2, 4, 4, 6, 6, 7, 4, 4 }, wquuf.getIdArray() );

        wquuf.union( 2, 1 );
        assertArrayEquals( new int[]{ 0, 2, 2, 4, 4, 6, 6, 7, 4, 4 }, wquuf.getIdArray() );

        wquuf.union( 5, 0 );
        assertArrayEquals( new int[]{ 6, 2, 2, 4, 4, 6, 6, 7, 4, 4 }, wquuf.getIdArray() );

        wquuf.union( 7, 2 );
        assertArrayEquals( new int[]{ 6, 2, 2, 4, 4, 6, 6, 2, 4, 4 }, wquuf.getIdArray() );

        wquuf.union( 6, 1 );
        assertArrayEquals( new int[]{ 6, 2, 6, 4, 4, 6, 6, 2, 4, 4 }, wquuf.getIdArray() );

        wquuf.union( 7, 3 );
        assertArrayEquals( new int[]{ 6, 2, 6, 4, 6, 6, 6, 2, 4, 4 }, wquuf.getIdArray() );
    }
}
