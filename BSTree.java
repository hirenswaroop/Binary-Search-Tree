/**
 * Handles all Binary Search tree
 * manipulation and traversals
 * @author uscart
 *
 * @param <T>
 */

public class BSTree <T extends Comparable<T>> {
   private BSTNode <T> root;
   private LList<T> list = new LList<T>();
   private LList<T> list1 = new LList<T>();
   private LList<T> list2 = new LList<T>();
   public class BSTNode <E extends Comparable <E>> {
       public BSTNode <E> left = null;
       public BSTNode <E> right = null;
       public E data = null;

       public BSTNode (BSTNode <E> left, BSTNode <E> right, E data) {
           this.left = left;
           this.right = right;
           this.data = data;
       }
   }

   
   /**
    * sets root to null
    * Runtime is O(1)
    */
   public BSTree () {
       root = null;
   }

   /**
    * add method that is public
    * Runtime is O(n)
    * @param e
    * @return boolean
    */
   public boolean add (T e) {
       return addHelper (root, e);
   }

   // Runtime is O(n)
   private boolean addHelper (BSTNode<T> node, T e) {
       BSTNode <T> nNode = new BSTNode <T> (null, null, e);
       if (root == null) {
           root = nNode;
           return true;
       }

       if (node == null) {
           node = root;
       }

       if (node.data.compareTo(e) > 0 || node.data.compareTo(e) == 0) {
           if (node.left == null) {
               node.left = nNode;
           } else {
               addHelper (node.left, (T) nNode.data);
           }
       } else {
           if (node.right == null) {
               node.right = nNode;
           } else {
               addHelper(node.right, (T) nNode.data);
           }
       }
       return true;
   }

   // Runtime is O(n)
   private BSTNode<T> pred(BSTNode<T> curr) {
       BSTNode<T> parent = curr;
       curr = curr.left;

       while (curr.right != null) {
           parent = curr;
           curr = curr.right;
       }

       if (parent.left == curr) {
           parent.left = curr.left;
       } else if (parent.right == curr) {
           parent.right = curr.left;
       }

       return curr;
   }

   /**
    * remove method that will remove a node
    * Runtime is O(nlog(n))
    * @param e
    * @return boolean
    */
   public boolean remove (T e) {
       if (root == null) {
           return false;
       }

       BSTNode<T> parent = null;
       BSTNode<T> curr = root;
       while (curr.data.compareTo(e) != 0) {
           parent = curr;
           if (curr.data.compareTo(e) >= 0) {
               curr = curr.left;
           } else {
               curr = curr.right;
           }
           if (curr == null) {
               return false;
           }
       }
       return deleteNode (parent, curr);
   }

   // Runtime is O(n)
   private boolean deleteNode (BSTNode<T> parent, BSTNode<T> curr) {
       int childCount = 0;
       boolean found = false;

       if (curr.left != null) {
           childCount++;
       }
       if (curr.right != null) {
           childCount++;
       }
       if (childCount <= 1) {
           found = true;
           if (parent == null) {
               if (curr.left != null) {
                   root = curr.left;
                   curr.left = null;
               } else {
                   root = curr.right;
                   curr.right = null;
               }
           } else {
               boolean lc = false;
               if (parent.left == curr) {
                   lc = true;
               }
               BSTNode<T> next = curr.left;
               if (curr.left == null) {
                   next = curr.right;
               } else if (curr.right == null) {
                   next = curr.left;
               }
               if (lc) {
                   parent.left = next;
               } else {
                   parent.right = next;
               }
           }
       } else {
           BSTNode<T> pred;

           pred = pred(curr);
           curr.data = pred.data;
           found = true;
       }
       return found;
   }

   // Runtime is O(n^2log(n))
   public void removeAll(T e) {
       while (remove(e)) {
           continue;
       }
   }

   /**
    * gets in order traversal
    * Runtime is O(n)
    * @return LList<T>
    */
   public LList <T> inOrder() {
       return inOrderHelper (root);
   }

   // Runtime is O(n)
   private LList<T> inOrderHelper (BSTNode <T> node) {
       if (node != null) {
           if (node.left != null) {
               inOrderHelper (node.left);
           }
           list.add (node.data);
           if (node.right != null) {
               inOrderHelper (node.right);
           }
       }

       return list;
   }

   /**
    * gets pre order traversal
    * Runtime is O(n)
    * @return LList<T>
    */
   public LList<T> preOrder() {
       return preOrderHelper (root);
   }

   // Runtime is O(n)
   private LList<T> preOrderHelper (BSTNode <T> node) {
       if (node != null) {
           list1.add(node.data);
           if (node.left != null) {
               preOrderHelper (node.left);
           }
           if (node.right != null) {
               preOrderHelper (node.right);
           }
       }

       return list1;
   }

   /**
    * gets post order traversal
    * Runtime is O(n)
    * @return LList<T>
    */
   public LList<T> postOrder() {
       return postOrderHelper (root);
   }

   // Runtime is O(n)
   private LList<T> postOrderHelper (BSTNode <T> node) {
       if (node != null) {
           if (node.left != null) {
               postOrderHelper (node.left);
           }
           if (node.right != null) {
               postOrderHelper (node.right);
           }
           list2.add (node.data);
       }

       return list2;
   }
}