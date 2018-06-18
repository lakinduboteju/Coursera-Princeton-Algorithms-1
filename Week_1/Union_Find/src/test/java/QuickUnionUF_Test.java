import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuickUnionUF_Test
{
    /**
     * All the steps in this test are the exact steps followed in Quick-union demo
     * from Quick Union lecture video.
     */
    @Test
    public void quickUnionDemo()
    {
        // Initialize a QuickFindUF for 10 number of components
        QuickUnionUF quuf = new QuickUnionUF( 10 );

        quuf.union( 4, 3 );
        assertArrayEquals( new int[]{ 0, 1, 2, 3, 3, 5, 6, 7, 8, 9 }, quuf.getIdArray() );

        quuf.union( 3, 8 );
        assertArrayEquals( new int[]{ 0, 1, 2, 8, 3, 5, 6, 7, 8, 9 }, quuf.getIdArray() );

        quuf.union( 6, 5 );
        assertArrayEquals( new int[]{ 0, 1, 2, 8, 3, 5, 5, 7, 8, 9 }, quuf.getIdArray() );

        quuf.union( 9, 4 );
        assertArrayEquals( new int[]{ 0, 1, 2, 8, 3, 5, 5, 7, 8, 8 }, quuf.getIdArray() );

        quuf.union( 2, 1 );
        assertArrayEquals( new int[]{ 0, 1, 1, 8, 3, 5, 5, 7, 8, 8 }, quuf.getIdArray() );

        assertTrue( quuf.connected( 8, 9 ) );

        assertFalse( quuf.connected( 5, 4 ) );

        quuf.union( 5, 0 );
        assertArrayEquals( new int[]{ 0, 1, 1, 8, 3, 0, 5, 7, 8, 8 }, quuf.getIdArray() );

        quuf.union( 7, 2 );
        assertArrayEquals( new int[]{ 0, 1, 1, 8, 3, 0, 5, 1, 8, 8 }, quuf.getIdArray() );

        quuf.union( 6, 1 );
        assertArrayEquals( new int[]{ 1, 1, 1, 8, 3, 0, 5, 1, 8, 8 }, quuf.getIdArray() );

        quuf.union( 7, 3 );
        assertArrayEquals( new int[]{ 1, 8, 1, 8, 3, 0, 5, 1, 8, 8 }, quuf.getIdArray() );
    }
}
