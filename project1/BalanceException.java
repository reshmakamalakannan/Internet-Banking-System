package project1;
//User Defined Exception 
class BalanceException extends Exception//inheriting Exception class
{
	 double amt;//default access
    BalanceException(double amt)//constructor with one parameter
    {
       this.amt=amt;//this keyword
    }
    public String toString()//toString method
    {
         return "Not sufficient Balance,check Balance";
    }
}