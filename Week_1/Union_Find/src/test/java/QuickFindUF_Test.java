import static org.junit.Assert.*;

import org.junit.Test;

public class QuickFindUF_Test
{
    /**
     * All the steps in this test are the exact steps followed in Quick-find demo
     * from Quick Find lecture video.
     */
    @Test
    public void quickFindDemo()
    {
        // Initialize a QuickFindUF for 10 number of components
        QuickFindUF qfuf = new QuickFindUF( 10 );

        qfuf.union( 4, 3 );
        assertArrayEquals( new int[]{ 0, 1, 2, 3, 3, 5, 6, 7, 8, 9 }, qfuf.getIdArray() );

        qfuf.union( 3, 8 );
        assertArrayEquals( new int[]{ 0, 1, 2, 8, 8, 5, 6, 7, 8, 9 }, qfuf.getIdArray() );

        qfuf.union( 6, 5 );
        assertArrayEquals( new int[]{ 0, 1, 2, 8, 8, 5, 5, 7, 8, 9 }, qfuf.getIdArray() );

        qfuf.union( 9, 4 );
        assertArrayEquals( new int[]{ 0, 1, 2, 8, 8, 5, 5, 7, 8, 8 }, qfuf.getIdArray() );

        qfuf.union( 2, 1 );
        assertArrayEquals( new int[]{ 0, 1, 1, 8, 8, 5, 5, 7, 8, 8 }, qfuf.getIdArray() );

        assertTrue( qfuf.connected( 8, 9 ) );

        assertFalse( qfuf.connected( 5, 0 ) );

        qfuf.union( 5, 0 );
        assertArrayEquals( new int[]{ 0, 1, 1, 8, 8, 0, 0, 7, 8, 8 }, qfuf.getIdArray() );

        qfuf.union( 7, 2 );
        assertArrayEquals( new int[]{ 0, 1, 1, 8, 8, 0, 0, 1, 8, 8 }, qfuf.getIdArray() );

        qfuf.union( 6, 1 );
        assertArrayEquals( new int[]{ 1, 1, 1, 8, 8, 1, 1, 1, 8, 8 }, qfuf.getIdArray() );
    }
}
