/**
 * Union Find algorithms are used to solve dynamically connected problem.
 * Quick Union is a better approach than Quick Find. It is called lazy approach to solve the problem.
 *
 * Objects or components in the problem are represented by indexes in an integer array.
 * Each component has its parent component so that these components can be interpreted as multiple number of trees.
 *
 * 2 components are connected iff they have the same root component.
 * To connect 2 components - p and q ,
 *      Get root of q and set it as current root of p's parent
 *
 * Complexity:-
 *      Initialization O(N) ,
 *      union O(N) worst case ,
 *      find if connected O(N) worst case
 *
 * Find if connected is too expensive when trees get tall.
 */
public class QuickUnionUF
{
    // Number of all objects / components
    private int n;

    // Indexes of id array represents each component
    private int[] id;

    /**
     * Create an QuickUnionUF object and initialize data structures within QuickUnionUF object
     * @param n Number of all components
     */
    public QuickUnionUF( int n )
    {
        // Set number of all objects / components
        this.n = n;

        // Initialize id array that represents each component
        // Initially that all are un-connected. So we assign the index of each component as
        // its value. So each of them are their own parent at the beginning.
        id = new int[n];
        for ( int i = 0; i < n; i++ )
        {
            id[i] = i;
        }
    }

    /**
     * Finds the top level parent or the root of the given component.
     * @param c Given component to find its root
     * @return Integer represents the root component
     */
    private int root( int c )
    {
        // if given component's parent equals to itself, then we found the top level parent,
        // which is the root
        int parent = id[c];
        if ( parent == c )
        {
            // root found
            return parent;
        }

        // if given component's parent is different, then go ahead and find parent of that parent
        return root( parent );
    }

    /**
     * Says if gievn 2 components are connected (true) or not connected (false).
     * @param p Represents first component passed to the method (id of first component)
     * @param q Represents second component passed to the method (id of second component)
     * @return true if 2 components are connected or false if they are not connected.
     */
    public boolean connected( int p, int q )
    {
        // 2 components have same root?
        // then get root of q and set it as current root of p's parent
        if ( root(p) == root(q) )
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
        // If both have same root, then nothing to do (already are connected)
        if( root(p) == root(q) )
            return;

        // If they do not have the same root,
        // Set p's parent as q's root
        id[ root(p) ] = root(q);
    }

    /**
     * Gives the internal data structure (id array) used for Quick Union algorithm
     * @return id array that is used as the internal data structure in Quick Union algorithm
     */
    protected int[] getIdArray()
    {
        return id;
    }
}
