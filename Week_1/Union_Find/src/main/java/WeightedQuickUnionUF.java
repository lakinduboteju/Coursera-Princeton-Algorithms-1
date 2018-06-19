/**
 * Union Find algorithms are used to solve dynamically connected problem.
 * Quick Find and Quick Union are 2 algorithms used to solve this problem.
 * But both of them are not very suitable to solve huge dynamically connected problems.
 *
 * Weighting the Quick Union means when implementing Quick Union, taking steps to avoid making tall trees.
 * We will keep track of the number of nodes in each tree and maintain balance of the tree depth by
 * making the root of smaller tree a child of the root of larger tree.
 *
 * After weighting, depth of any node is at most log2 N (base 2 logarithm)
 *
 * Complexity:-
 *      Initialization O(N) ,
 *      union O(log N) worst case ,
 *      find if connected O(log N) worst case
 */
public class WeightedQuickUnionUF
{
    // Number of all objects / components
    private int n;

    // Indexes of id array represents each component
    private int[] id;

    // To store number of nodes in each tree
    private int[] sz;

    /**
     * Create an QuickUnionUF object and initialize data structures within QuickUnionUF object
     * @param n Number of all components
     */
    public WeightedQuickUnionUF( int n )
    {
        // Set number of all objects / components
        this.n = n;

        // Initialize id array that represents each component
        // Initially that all are un-connected. So we assign the index of each component as
        // its value. So each of them are their own parent at the beginning.
        id = new int[n];
        sz = new int[n];
        for ( int i = 0; i < n; i++ )
        {
            id[i] = i;

            // Initially only one node in each tree
            sz[i] = 1;
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
        // make the root of smaller tree a child of the root of larger tree.

        // Get roots of p and q first
        int pRoot = root(p);
        int qRoot = root(q);

        // Size of root of p's tree is smaller than size of root of q's tree ?
        if( sz[pRoot] < sz[qRoot] )
        {
            // Set parent of root of p as root of q
            id[pRoot] = qRoot;
            // So now q's tree become bigger
            sz[qRoot] += sz[pRoot];
        }
        else
        {
            // Otherwise q's root becomes the child of p's root
            id[qRoot] = pRoot;
            // So now p's tree become bigger
            sz[pRoot] += sz[qRoot];
        }
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
