package project2;
public class MyThread1 extends Thread
//inheriting thread class by using extend keyword
{  
    public Alert pt;//public access
    public MyThread1(Alert pt)//construcor with one parameter
    {  
    	this.pt=pt;//this keyword
    }  
    public void run()//run method
    { 
    	pt.show(1);//calling show method
    }        
}  