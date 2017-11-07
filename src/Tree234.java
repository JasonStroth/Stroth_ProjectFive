
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *                                       @author Jeffrey Jason Stroth
 */
public class Tree234
{
   private Node root = new Node();       
   public int find(String key)             
      {
      Node curNode = root;
      int childNumber;
      while(true)
         {
         if(( childNumber = curNode.findItem(key) ) != -1)          //*********************************************8
            return childNumber;            
         else if( curNode.isLeaf() )
            return -1;                       
         else                                 
            curNode = getNextChild(curNode,key);
         }  
      }
   public void insert(String dValue)
      {
      Node curNode = root;
      DataItem tempItem = new DataItem(dValue);

      while(true)
         {
         if( curNode.isFull() )               
            {
            split(curNode);                 
            curNode = curNode.getParent();    
                                             
            curNode = getNextChild(curNode, dValue);
            }  

         else if( curNode.isLeaf() )        
            break;                           
         else
            curNode = getNextChild(curNode, dValue);
         }

      curNode.insertItem(tempItem);     
      }
   
   public void split(Node thisNode) 
      {          
      DataItem itemB, itemC;
      Node parent, child2, child3;
      int itemIndex;
      itemC = thisNode.removeItem();    
      itemB = thisNode.removeItem();    
      child2 = thisNode.disconnectChild(2); 
      child3 = thisNode.disconnectChild(3); 
      Node newRight = new Node();       

      if(thisNode==root)              
         {
         root = new Node();          
         parent = root;                  
         root.connectChild(0, thisNode);  
         }
      else                            
         parent = thisNode.getParent(); 

      itemIndex = parent.insertItem(itemB);
      int n = parent.getNumItems();      

      for(int j = n-1; j > itemIndex; j--)     
         {                                    
         Node temp = parent.disconnectChild(j); 
         parent.connectChild(j+1, temp);      
         }                  
      parent.connectChild(itemIndex+1, newRight);
      newRight.insertItem(itemC);  
      newRight.connectChild(0, child2); 
      newRight.connectChild(1, child3); 
      }  


   public Node getNextChild(Node theNode, String theValue)       
      {
      int j;
     
      int numItems = theNode.getNumItems();
      for(j=0; j<numItems; j++)          
         {                              
         if(theValue.compareTo(theNode.getItem(j).dData) == -1)              //make a string comparison instead of less than
            return theNode.getChild(j);  
         }                  
      return theNode.getChild(j);        
      }
}
