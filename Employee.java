
import java.util.*;
import java.text.*;
import java.io.*;

class fileread3
{
    void fileisread(String fname)
    {
    try
	{
   
	FileInputStream fstream = new FileInputStream(fname);
	DataInputStream in = new DataInputStream(fstream);
	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	String strLine;
	int k=0;
	while ((strLine = br.readLine()) != null)   
	{
     fileread obj=new fileread();
     System.out.println("-----------------------------------------------------");
     obj.fileisread(strLine);
     ++k;
     
  	 }
	System.out.println("Number of employees registerd--->"+k);
	in.close();
   
    	 }catch (Exception e)

	{
   System.err.println("Error: " + e.getMessage());
   	}
    }
}


class fileread2
{
    int fileisread(String fname,String uname)
    {
        
        try{
   // Open the file that is the first 
   // command line parameter
   FileInputStream fstream = new FileInputStream(fname);
   // Get the object of DataInputStream
   DataInputStream in = new DataInputStream(fstream);
   BufferedReader br = new BufferedReader(new InputStreamReader(in));
   String strLine;
   //Read File Line By Line
   int k=0;
   while ((strLine = br.readLine()) != null)   
	{
   // Print the content on the console
    if(strLine.equals(uname))
    {
        k=1;
    }
    else
    {
        k=0;
    }
  	// System.out.println (strLine);
   	}
   
   //Close the input stream
   
   in.close();
   return k;
   
     }catch (Exception e){//Catch exception if any
   System.err.println("Error: " + e.getMessage());
   return 0;
  
   }

    }

}


class fileread
{
    void fileisread(String fname)
    {
        
        try{
   // Open the file that is the first 
   // command line parameter
   FileInputStream fstream = new FileInputStream(fname);
   // Get the object of DataInputStream
   DataInputStream in = new DataInputStream(fstream);
   BufferedReader br = new BufferedReader(new InputStreamReader(in));
   String strLine;
   //Read File Line By Line
   int k=0;
   while ((strLine = br.readLine()) != null)   {
   // Print the content on the console
       
   System.out.println (strLine);
   }
   //Close the input stream
   
   in.close();
   
     }catch (Exception e){//Catch exception if any
   System.err.println("Error: " + e.getMessage());
  
   }

    }

}

interface filemanagement 
{
    public void add_infile(String f_name,String add);
    // String remove_file(String f_name);
    
}

class filehandle implements filemanagement
{
    
      public void add_infile(String f_name, String add)
     {
         
      // add=add;  
      try {
    BufferedWriter out = new BufferedWriter(new FileWriter(f_name, true));
    out.write(add);
    out.newLine();
    
    out.close();
} catch (IOException e) {
    
        System.out.println("Unexpected error comes");
                 }


    }

    
    
    
}
class validation
{
    int numbervalidation(String num)
    {
        try{
            int x=Integer.parseInt(num);
            return x;
        }
        catch(Exception e)
        {
            return  0;
        }
    }
}
//end of the class

//employee meta information
class employeemeta
{
    String name;
    int type_of_employee;
    String desig;
    int exp;
    int age;
    String sex;
    int mob;
    int user;
    String fn;
    
    void add_meta()throws IOException
    {
        filehandle objf=new filehandle();
        BufferedReader bfr= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name of the Employee");
        this.name=bfr.readLine();
        
        System.out.println("Which type of employee You are");
        int x=0;
        while(x!=4)
        {
        System.out.println("1:-Senior Software Engineer");
        System.out.println("2:-Software Engineer");
        System.out.println("3:-Software Trainee");
        String ab=bfr.readLine();
        validation obj=new validation();
        int p=obj.numbervalidation(ab);
        if(p==0)
        {
            System.out.println("Please Enter it again in proper format");
            
        }
        
        else if(p>3)
        {
            System.out.println("Please enter proper value");
        }
        else
        {
            this.type_of_employee=p;
            x=4;
        }
        }
        System.out.println("Please enter the experience:--No of years");
        this.exp=Integer.parseInt(bfr.readLine());
        System.out.println("Please enter the Age");
        this.age=Integer.parseInt(bfr.readLine());
        System.out.println("Please enter Sex--M:->male:F:->Female");
        this.sex=bfr.readLine();
        System.out.println("Please enter User name for login..It should be number");
        int uk=0;
        while(uk!=4)
        {
            
        String us=bfr.readLine();
        
             
            
             
        validation ob3=new validation();
        int s=ob3.numbervalidation(us);
             if(s==0)
             {
                 System.out.println("please enter Number for username");
                 uk=0;
             }
             else
             {
                 //check whether the username exists or not
                 //end of logic
                 uk=4;
                 this.fn=us;
                 objf.add_infile("username.txt", us);
                 objf.add_infile(us, "Username:-->"+us);
                 objf.add_infile(us, "Name:-->"+this.name);
                 if(this.type_of_employee==1)
                 {
                     objf.add_infile(us, "Designnation:-->Senior Software Engineer");
                 }
                 else if(this.type_of_employee==2)
                 {
                     objf.add_infile(us,"Designnation:-->Software Engineer");
                 }
                 else if(this.type_of_employee==3)
                         {
                             objf.add_infile(us,"Designnation:-->Software Trainee");
                             
                         }
                 
                 objf.add_infile(us,"Gender-->"+sex);
                 objf.add_infile(us,"Age:-->"+Integer.toString(age));
                 objf.add_infile(us,"Experience-->"+Integer.toString(exp));
                
                 
                
             }
        
         
        }
        //for calculating the DA,HRA,ETC
        //End of calulating it
        //for file handling in it
        //end of file handling
    }
}
//end of meta information
class senior extends employeemeta
{
    
    int basic_sal=60000;
    int da=30,hra=20,ta=10;
    float gross_sal;
    
    void calc_cal()
    {
        gross_sal=basic_sal+((basic_sal/100)*da)+((basic_sal/100)*hra)+((basic_sal/100)*ta);
        
        
    }

}

class soft_eng extends employeemeta
{
    
    int basic_sal=40000;
    int da=25,hra=20,ta=10;
    float gross_sal;
    
    void calc_cal()
    {
        gross_sal=basic_sal+((basic_sal/100)*da)+((basic_sal/100)*hra)+((basic_sal/100)*ta);
    }

}

class soft_trainee extends employeemeta
{
    
    int basic_sal=30000;
    int da=20,hra=20,ta=10;
    float gross_sal;
    
    void calc_cal()
    {
        gross_sal=basic_sal+((basic_sal/100)*da)+((basic_sal/100)*hra)+((basic_sal/100)*ta);
    }

}
public class Employee 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        BufferedReader bfr= new BufferedReader(new InputStreamReader(System.in));
        int choice=0,ch;
        String ch2;
       
        while(choice!=4)
        {
        System.out.println("*********************Employee Managment System*********************");
        System.out.println("1:---Admin Login");
        System.out.println("2:---Employee Login");
        System.out.println("3:---New User-Registration");
        System.out.println("4:---Exit");
        int x2=0;
        while(x2!=1)
        {
        ch2=bfr.readLine();
        validation obj=new validation();
        ch=obj.numbervalidation(ch2);//catches the number
        if(ch>0)
        {
        
            x2=1;
        }
        else
        {
            x2=0;
            System.out.println("Please enter only number not alphabets");
        }
        
        switch(ch){
            
            case 1:{
                System.out.println("***********************Admin***************");
                System.out.println("Please Enter the password");
                String adminpass=bfr.readLine();
                if(adminpass.equals("admin"))
                {
                 fileread3 ob12=new fileread3();
                 ob12.fileisread("username.txt");
                    
                }
                else
                {
                    System.out.println("You are Not allowed in this area");
                }
                break;
                
            }
            case 2:
            {
                System.out.println("Please Enter the username");
                String abc=bfr.readLine();
                fileread2 ob10=new fileread2();
                int im=ob10.fileisread("username.txt", abc);
                if(im==1)
                {
                    fileread ob11=new fileread();
                    System.out.println("Employee Details");
                    ob11.fileisread(abc);
                }
                else
                {
                    System.out.println("user Doesnt exists");
                }
                
                
                break;
            }
            case 3:
            {
                //new User Registraion start
                employeemeta obj1=new employeemeta();
                obj1.add_meta();
                if(obj1.type_of_employee==1)
                {
                    //senior Software engineer
                    senior objs=new senior();
                    objs.calc_cal();
                    filehandle obj7=new filehandle();
                    obj7.add_infile(obj1.fn,Integer.toString(objs.da));
                    obj7.add_infile(obj1.fn,Integer.toString(objs.hra));
                    obj7.add_infile(obj1.fn,Integer.toString(objs.ta));
                    obj7.add_infile(obj1.fn,Float.toString(objs.gross_sal));
                    
                    
                }
                else if(obj1.type_of_employee==2)
                {
                    //Software engineer
                    soft_eng obje=new soft_eng();
                    obje.calc_cal();
                    filehandle obj7=new filehandle();
                    obj7.add_infile(obj1.fn,Integer.toString(obje.da));
                    obj7.add_infile(obj1.fn,Integer.toString(obje.hra));
                    obj7.add_infile(obj1.fn,Integer.toString(obje.ta));
                    obj7.add_infile(obj1.fn,Float.toString(obje.gross_sal));
                    
                }
                else if(obj1.type_of_employee==3)
                {
                    //Softwares
                    soft_trainee objt=new soft_trainee();
                    objt.calc_cal();
                    filehandle obj7=new filehandle();
                    obj7.add_infile(obj1.fn,Integer.toString(objt.da));
                    obj7.add_infile(obj1.fn,Integer.toString(objt.hra));
                    obj7.add_infile(obj1.fn,Integer.toString(objt.ta));
                    obj7.add_infile(obj1.fn,Float.toString(objt.gross_sal));
                }
                //end of registration form
                break;
            }
            case 4:
            {
                System.out.println("Exit");
                System.exit(0);
                break;
            }
            default:
            {
                System.out.println("Enter Valid choice");
            }
                break;
        }
        }
		System.out.println();
		System.out.println();
    }
}
}