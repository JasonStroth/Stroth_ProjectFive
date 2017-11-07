/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jason
 */
public class DataItem 
{
   public String dData; 
   public int count;

   public DataItem(String dd)
   { 
       dData = dd;
   }
   
   public DataItem(int cnt)
   {
       count = cnt;
   }
       
   public void displayItem()   
   {
       System.out.println(" "+dData+": "+count+".");
   }
}
