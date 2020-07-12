import java.lang.reflect.Field;

public class Solution
{
    public static void main(String [] args)
    {
        BinaryTreeNode parent = new BinaryTreeNode();
        BinaryTreeOperations operations = new BinaryTreeOperations();
        // System.out.println(operations.lock(parent));
        BinaryTreeNode left_child = new BinaryTreeNode();
        left_child.mParent = parent;
        parent.mLeftChild = left_child;
        dump(parent);
        System.out.println(operations.lock(left_child));
        dump(left_child);
    }

    private static void dump(Object o)
    {
        Field[] fields = o.getClass().getDeclaredFields();
        for (int i=0; i<fields.length; i++)
        {
            try
            {
                System.out.println(fields[i].getName() + " - " + fields[i].get(o));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
