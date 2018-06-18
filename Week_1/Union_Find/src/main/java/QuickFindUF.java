/**
 * Union Find algorithms are used to solve dynamically connected problem.
 * Quick Find is one approach. It is called eager approach to solve the problem.
 *
 * Objects or components in the problem are represented by indexes in an integer array.
 * 2 objects / components are connected iff values at their indexes are the same.
 * When connecting 2 objects / components - p and q ,
 *      Change all entries with value of p to the value of q .
 *
 * Complexity:-
 *      Initialization O(N) ,
 *      union O(N) ,
 *      find if connected O(1)
 *
 * Union is too expensive when performing M (large number) union operations on
 * N (large number) of components, complexity is O(N^2) .
 */
public class QuickFindUF
{
    // Number of all objects / components
    private int n;

    // Indexes of id array represents each component
    private int[] id;

    /**
     * Create an QuickFindUF object and initialize data structures within QuickFindUF object
     * @param n Number of all components
     */
    public QuickFindUF( int n )
    {
        // Set number of all objects / components
        this.n = n;

        // Initialize id array that represents each component
        // Initially that all are un-connected. So we assign the index of each component as
        // its value. So all of them have a different value saying that they all are not connected.
        id = new int[n];
        for ( int i = 0; i < n; i++ )
        {
            id[i] = i;
        }
    }

    /**
     * Says if gievn 2 components are connected (true) or not connected (false).
     * @param p Represents first component passed to the method (id of first component)
     * @param q Represents second component passed to the method (id of second component)
     * @return true if 2 components are connected or false if they are not connected.
     */
    public boolean connected( int p, int q )
    {
        // 2 components have same value?
        // then they are connected
        if ( id[p] == id[q] )
            return true;

        return false;
    }

    /**
     * Connects given 2 components
     * @param p Represents first component passed to the method (id of first component)
     * @param q Represents second component passed to the method (id of second component)
     */
    public void union ( int p, int q )
    {
        // If both have same value, then nothing to do
        if( id[p] == id[q] )
            return;

        // If they do not have the same value,
        // then go through all components in array,
        // check for components that have value of p,
        // change their values to value of q

        int pValue = id[p];

        for ( int i = 0; i < n; i++ )
        {
            if( pValue == id[i] )
                id[i] = id[q];
        }
    }

    /**
     * Gives the internal data structure (id array) used for Quick Find algorithm
     * @return id array that is used as the internal data structure in Quick Find algorithm
     */
    protected int[] getIdArray()
    {
        return id;
    }
}
