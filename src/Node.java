/**                                      @author Jefrey Jason Stroth
 * 
 * Found parts of this code online and tailored it to fit my program:
 * https://www.unf.edu/~wkloster/3540/234tree.java
 */

public class Node 
{
   private static final int ORDER = 4;
   private int numItems;
   private Node parent;
   private Node childArray[] = new Node[ORDER];
   private DataItem itemArray[] = new DataItem[ORDER-1];
   //private DataItem count = new DataItem (int);              ******* Need to fix Counter**********

   // connect child to this node
   public void connectChild(int childNum, Node child)
      {
      childArray[childNum] = child;
      if(child != null)
         child.parent = this;
      }

   // disconnect child from this node, return it
   public Node disconnectChild(int childNum)
      {
      Node tempNode = childArray[childNum];
      childArray[childNum] = null;
      return tempNode;
      }

   public Node getChild(int childNum)
      { 
          return childArray[childNum]; 
      }

   public Node getParent()
     { 
          return parent; 
     }

   public boolean isLeaf()
     { 
      if(childArray[0] == null)
            {
                return true;
            }
            else
                return false;
     }

   public int getNumItems()
     {
         return numItems;
     }

   public DataItem getItem(int index)
     {
       return itemArray[index];
     }

   public boolean isFull()
     {
          if(numItems == ORDER-1)
                return true;
            else 
                return false;
     }

   public int findItem(double key)   
     {                                    
      for(int j=0; j<ORDER-1; j++)   
         {                                
         if(itemArray[j] == null)
            break;
         else
            {
     //           count = count++;                                          // increase count by one
            }
         return j;
         }
      return -1;
     } 

   public int insertItem(DataItem newItem)
      {
      numItems++;             
      String newKey = newItem.dData;       
      for(int j=ORDER-2; j>=0; j--)        
         {                                 
         if(itemArray[j] == null)          
            continue;                      
         else                              
            {                              
            String itsKey = itemArray[j].dData;
            if(newKey.compareTo(itsKey) == -1)                             //have to do a comparison instead less than. 
               itemArray[j+1] = itemArray[j];   
            else
               {
               itemArray[j+1] = newItem;   
               return j+1;                 
               }                           
            }  
         }  
      itemArray[0] = newItem;              
      return 0;
      }  

   public DataItem removeItem()        
      {
      // assumes node not empty
      DataItem temp = itemArray[numItems-1];  
      itemArray[numItems-1] = null;          
      numItems--;                             
      return temp;                            
      }

   public void displayNode()         
      {
      for(int j=0; j<numItems; j++)
         itemArray[j].displayItem();        
      }
}
