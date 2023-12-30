package project2;
public class MyThread2 extends Thread
//inheriting thread class by using extend keyword
{  
	public Alert pt;//public access
	public MyThread2(Alert pt)//construcor with one parameter
	{  
		this.pt=pt; //this keyword 
	}  
	public void run()//run method
	{  
		pt.show(2); //calling show method 
	}  
}  