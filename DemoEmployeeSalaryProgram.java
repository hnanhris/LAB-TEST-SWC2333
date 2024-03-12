
/**
 * Programme Description : To display employee data using java
 * Programmer: HananHaris
 * Date: 12 March 2024
 */

//import the respective packages
import java.io.*;
import java.util.StringTokenizer;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

//driver class
public class DemoEmployeeSalaryProgram
{
    //Driver method
    public static void main(String[]args) throws IOException
    {
        //Instantiate the object of DecimalFormat
        DecimalFormat dF = new DecimalFormat("0.00");
        
        try
        {
            //Set the input/output file
            //input file
            BufferedReader inputFile = new BufferedReader(new FileReader("employeeSalaries.txt"));

            //Output files
            PrintWriter employeeData = new PrintWriter(new FileWriter("employeeData.txt"));

            //Declare the variables
            String inputData = null;
            String employeeName;
            double annualSalaries;
            int yearsOfService;
            int baseSalary;

            //Write the title of the patient details to the employeeData.txt
            employeeData.println("List of employee data");
            
            employeeData.println("\nEmployee's Name\t\tTotal Annual Salaries\t\tYears of service");
            
            employeeData.println("----------------------------------------------------------------------------------------------------");


              while((inputData = inputFile.readLine()) != null)
              {
                //INstantiate the object reference of the StringTokenizerclass
                
                //to pass the string line (input data) & to set the delimeter
                StringTokenizer sT= new StringTokenizer(inputData,";");
                                    //to pass the string line &delimeter
                                    
                //Break into tokens and assign to the appropriate variables
                employeeName = sT.nextToken();
                
                //or

                annualSalaries =Double.parseDouble(sT.nextToken());
                yearsOfService=Integer.parseInt(sT.nextToken());
                
                //String str = sT.nextToken();
                //custQuan = Integer.parseInt(str);
                
                //To test for the negative number
                if(annualSalaries < 0)
                throw new IllegalArgumentException();

                //Calculate the annual price
                baseSalary = 0;
                annualSalaries = baseSalary +  (baseSalary * 5/100);

                //Initialize the category to null
                String category =null;
                if(annualSalaries < 1000000)
                {
                    //Calculate discount
                    annualSalaries = 0.0;
                    employeeData.println(employeeName + "\t\t" + dF.format(annualSalaries));
                }
                else if (annualSalaries >= 1000000)
                {
                    employeeData.println(employeeName + "\t\t" + dF.format(annualSalaries));
                }
    
                }//end of while loop

                //close all the input/output files
                //Close the input/output file
                inputFile.close();
                employeeData.close();
            }//end of try block
            
            catch(FileNotFoundException ex)
            {
                String output="File not found";
                JOptionPane.showMessageDialog(null, output);
            }
    
            catch(IllegalArgumentException iae)
            {
                String output="Invalid input! The price must be a positive number";
                JOptionPane.showMessageDialog(null, output);
            }//end of catch
     }//end of main
}//end of class
