package project2;
//generic class
//Use of final keyword this class cannot be inherited
public final class Wel<T extends String>//bounded type
{
   public T wmes;//instance variable having public access
   public Wel(T mes)
   {
     wmes=mes;//assigning the value to instance variable of type T
   }
   public void display()//display method
   {
     System.out.println(wmes);//displaying the message
   }
}