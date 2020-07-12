class BinaryTreeNode
{
    boolean mLocked = false;
    BinaryTreeNode mParent;
    BinaryTreeNode mLeftChild;
    BinaryTreeNode mRightChild;
}

public class BinaryTreeOperations
{
    public boolean is_locked(BinaryTreeNode node)
    {
        return node.mLocked;
    }

    public boolean lock(BinaryTreeNode node)
    {
        if(!checkLocks(node))
        {
            return false;
        }
        node.mLocked = true;
        return true;
    }

    public boolean unlock(BinaryTreeNode node)
    {
        if(!checkLocks(node))
        {
            return false;
        }
        node.mLocked = false;
        return true;
    }

    private boolean checkLocks(BinaryTreeNode node)
    {
        if(!checkChildLocks(node.mLeftChild) || !checkChildLocks(node.mRightChild))
        {
            return false;
        }

        BinaryTreeNode parent = node.mParent;
        while(parent != null)
        {
            if(parent.mLocked)
            {
                return false;
            }
            parent = parent.mParent;
        }
        return true;
    }

    private boolean checkChildLocks(BinaryTreeNode node)
    {
        if(node == null)
        {
            return true;
        }
        if(node.mLocked)
        {
            return false;
        }
        if(!checkChildLocks(node.mLeftChild))
        {
            return false;
        }
        return checkChildLocks(node.mRightChild);
    }
}
