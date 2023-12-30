package project1;
import project2.*;//importing user defined package
import java.io.Console;//importing Console class for accepting passwords
import java.util.Scanner;//importing Scanner class for accepting user input
import java.util.Random;//importing Random class for generating random numbers
import java.io.IOException;
class Elite//main class of name Elite
{
	public static void main(String[] args) throws IOException, InterruptedException  
	{
		//Instantiation of object.Creating object for Elite class
		Elite m=new Elite();

		//final variable,this value does not cahnge
		final int CUST=5;

		//creating object for scanner class using new keyword
		Scanner s = new Scanner(System.in);
		
		//This statement clears the screen
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
		
		//Storing the Bank Customer details using array of objects
		EliteDetails[]e = new EliteDetails[CUST];
		e[0]=new EliteDetails("Username1","Ben10",1234); 
		e[1]=new EliteDetails("Username2","Ben11",5678);
		e[2]=new EliteDetails("Username3","Ben12",1011);
		e[3]=new EliteDetails("Username4","Ben13",1213);
		e[4]=new EliteDetails("Username5","Ben14",1415);
		System.out.println();

		//using generic one type parameter,printing welcome message
		Wel<String> w = new Wel<String>("**************************************************\n"+
			"**************************************************\n"+
			"         WELCOME TO ELITE INTERNET BANKING        \n"+
			"**************************************************\n"+
			"**************************************************\n");

		//display welcome message using method
		w.display();

		//Alert message using MultiThreading
		Alert obj = new Alert();

    	//creating threads.
	    Thread t1=new MyThread1(obj);  //dynamic method dispatch
	    Thread t2=new MyThread2(obj);  

	    //starting the  thread1.
	    t1.start();
	    try//try block
	    {
	    	t1.join();//join method,It waits for the thread to die
	    }
	    catch(Exception err) 
	    {
	    	System.out.println("The exception has been caught " + err);  
	    }

	    //starting the  thread2.
	    t2.start();
	    try
	    { 
	    	t2.join();
	    } 
	    catch(Exception err)  //general Exception class 
	    {
	    	System.out.println("The exception has been caught " + err);  
	    }

	    int op,i,ch;
	    do//do while loop
		{
                System.out.println("1.LOGIN");
                System.out.println("2.EXIT");
                System.out.println("Enter your choice : ");
                op=s.nextInt();
                if(op==1)
                {
                	System.out.println("      LOGIN   ");
					System.out.println();
					System.out.print("USERNAME : ");
					String u=s.next();
					Console cons;
					if((cons=System.console())!=null)//if block
				    {
				    	char[] password=cons.readPassword("PASSWORD : "); 
			            String p=new String(password);
			            for(i=0;i<=4;i++)//for loop
			            {
			            	 if(e[i].uname.equals(u))
		                     {
		                     	if(e[i].pwd.equals(p))
				                {
				                   System.out.println("Successful Login");
				                   do
					               {
								       System.out.println("**************************************************");
							           System.out.println("                     MENU                         ");
							           System.out.println("**************************************************");
							           System.out.println("1.DEPOSIT");
							           System.out.println("2.WITHDRAWAL");
							           System.out.println("3.BALANCE ENQUIRY");
							           System.out.println("4.TRANSACTION HISTORY");
							           System.out.println("5.TRANSFER FUNDS");
							           System.out.println("6.PAY BILLS");
							           System.out.println("7.EXIT");
							           System.out.println("**************************************************");
							           System.out.print("Enter your choice : ");
							           ch=s.nextInt();
							           switch(ch)//switch case
								       {
								              case 1:System.out.print("Enter the amount to deposit : ");
								                     double amt=s.nextDouble();
								                     e[i].deposit(amt);
								                     e[i].u++;
								                     break;
								              case 2:System.out.print("Enter the amount to Withdraw : ");
								                     amt=s.nextDouble();
									                     try
										                 {
										                 	/*The withdrawal method is put inside try block as 
										                 	it may throw an error*/
										                     e[i].withdrawal(amt);
										                     e[i].u++;
										                 }
										                 catch(BalanceException err)
												         {
										                   System.out.println("Caught Error : "+err);
												         }
								                     break;
								              case 3:System.out.println("Your Balance is : "+e[i].getBalance());
								                     break;
								              case 4: System.out.println("TRANSACTION HISTORY");
								                      System.out.println("************************");
								                      System.out.println();
								                      if(e[i].balance==0)
								                      {
								                      	System.out.println("No transaction occured");
								                      }
								                      else
								                      {
								                          e[i].history();
								                      }
								                      break;
								              case 5:
								                    System.out.print("Enter the account no :");
											        long acc=s.nextLong();
											        System.out.print("Enter the amount you want to transfer :");
											        amt=s.nextDouble();
											        for(int j=0;j<=4;j++)
											        {
											            if(acc==e[j].accno)
											            {
											                Random r = new Random();//Creating object for random class
													        char [] o=new char[6];//array of characters
													        for(int k=0;k<6;k++)
													        {
													            o[k]=(char)(r.nextInt(10)+48);
													        }
													        System.out.println("Your OTP is : "+ new String(o));
													        System.out.print("Enter the OTP : ");
													        String otp=s.next();
													        /*checking whether the generated otp and entered otp 
													        are same using equals()method*/
													        if(new String(o).equals(otp))
													        {
													        	 e[j].deposit(amt);
													        	 e[j].u++;
													        	 try
													        	 {
												                     e[i].withdrawal(amt);
												                     e[i].u++;
											                     }
											                     catch(BalanceException err)
											                     {
									                               System.out.println("Caught Error : "+err);
											                     }
													             System.out.println("Transaction Successful");
													        }
													        else
													        {
													            System.out.println("Transaction Not Successful");
													        }
											               break;
											            }
											        }
								                     break;
								              case 6:
								              //printing the class name Elite using getClass().getSimpleName()
								               System.out.println("Pay your bills through "+m.getClass().getSimpleName()+
								               	" Internet banking Happily!! ");
                                               System.out.println("**************************************************");
								               System.out.println("1.MOBILE BILL");
								               System.out.println("2.ELECTRICITY BILL");
								               System.out.println("**************************************************");
								               System.out.print("Enter your choice : ");
                                               int pch=s.nextInt();
                                               if(pch==1)
                                               {
                                               	     System.out.println("**********************");
                                               	     System.out.println("MOBILE BILL");
                                               	     System.out.println("**********************");
								                     System.out.print("Enter mobile number : ");
								                     long ph=s.nextLong();
								                     System.out.print("Enter the amount you want to pay : ");
								                     amt=s.nextDouble();
                                               }
                                               else
                                               {
                                               	     System.out.println("**********************");
                                               	     System.out.println("ELECTRICITY BILL");
                                               	     System.out.println("**********************");
								                     System.out.print("Enter Consumer number : ");
								                     long cn=s.nextLong();
								                     System.out.print("Enter the amount you want to pay : ");
								                     amt=s.nextDouble();
                                               }
								                  try
									              {
									                     e[i].withdrawal(amt);
									                     e[i].u++;
									               }
									               catch(BalanceException err)
											       {
									                   System.out.println("Caught Error : "+err);
											        }
											 break;
										}
							       }while(ch!=7);
				                }
				                else
                               {
                	                System.out.println("Invalid Login");
	                  	             break;
                                }
		                     }
			            }
				    }
                }
        }while(op!=2);
	}
}