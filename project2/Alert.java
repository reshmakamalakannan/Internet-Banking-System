package project2;
public class Alert
{
	public void show(int op)//show method to print the alert message
    {
    	if(op==1)
		{   try
			{   Thread.sleep(2000);
				System.out.println("                                 ALERT                              ");
				System.out.println("/*ELITE BANK DOES NOT ASK FOR PERSONAL INFORMATIONS*/");
				System.out.println("/*DO NOT SHARE YOUR PASSWORDS OR PERSONAL INFORMATIONS WITH OTHERS*/");
				Thread.sleep(2000); // the thread will sleep for the 2000 milli seconds   
            }
            catch(InterruptedException e)//Thread.sleep()method throws InterruptedException  
            {
        	 System.out.println(e);//printing the error message
        	}
	    }
		if(op==2)
	    {
			try
			{  
			 System.out.println("**************************************************");
			 System.out.println("**************************************************");
			 Thread.sleep(2000);  // the thread will sleep for the 2000 milli seconds  
	        }
	        catch(InterruptedException e)//Thread.sleep()method throws InterruptedException  
	        {
	        	 System.out.println(e);//printing the error message
	        }
	     }
    }
}