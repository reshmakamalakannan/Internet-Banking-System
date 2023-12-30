package project1;
/*By default the compiler adds abstract and public keyword before the interface*/
abstract interface Operation//interface
{
    void deposit(double amt);
    void withdrawal(double amt) throws BalanceException;
    double getBalance();
    void history();
}
/*Implementing the interface using implements keyword*/
class EliteDetails implements Operation
{ 
   String uname,pwd;//default access
   long accno;//default access
   //constructor with 3 parameters
   EliteDetails(String uname,String pass,long accno)
   {
       this.uname=uname;
        pwd=pass;
        this.accno=accno;
   }
    int u;
    double ph[]=new double[15];//one dimensional array of type double 
    double balance;
    public double getBalance()
	{
       return balance;
	}
    public void deposit(double amt)
	{
	     balance+=amt;
         ph[u]=+amt;
	}
	public void withdrawal(double amt) throws BalanceException
    {
       	    if(balance<amt)
            {
                //throw keyword
                throw new BalanceException(balance);
            }
            else
            {
            	balance-=amt;
                ph[u]=-amt;
            	System.out.println("Cash of Rs."+amt+" is Withdrawn Successfully");
            }
    }
    public void history()
    {
        for(int v=0;v<=u;v++)
        {
            if(ph[v]>0)
            {
              System.out.println("Deposited : "+ph[v]);
            }
            else if(ph[v]<0)
            {
               System.out.println("Withdrawn : "+Math.abs(ph[v]));
            }
            else
            {
                 System.out.println("************************************");
                 System.out.println("Final Balance : "+balance);
                 System.out.println("************************************");
            }
        }
    }
}