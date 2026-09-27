package oopsConcept;

import java.util.*;

class Employee
{
	int emp_id, emp_salary;
	String emp_name, emp_dept;

	Employee(int emp_id, String emp_name, int emp_salary, String emp_dept)
	{
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_salary = emp_salary;
		this.emp_dept = emp_dept;
	}
}

class code9
{
	public static List<Employee> employeeDb;
	public static List<Integer> ids;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		employeeDb = new ArrayList<>();
		ids = new ArrayList<>();

		while(true)
		{
            System.out.println("\n1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Find the employee");
            System.out.println("4. Update the employee salary");
            System.out.println("5. Find the highest salary of the employee");
            System.out.println("6. Remove the entered Employee");
            System.out.println("7. Exit");

            System.out.print("Enter the Action: ");
            int action = sc.nextInt();

            if(action == 1)
            {
            	System.out.print("Enter the new Employee Id: ");
            	int emp_id = sc.nextInt();

            	if(!ids.contains(emp_id))
            	{
            		ids.add(emp_id);
            	}
            	else
            	{
            		System.out.println("The id is already exists!!!");
            		continue;
            	}

            	System.out.print("Enter the new Employee Name: ");
            	String emp_name = sc.next();

            	System.out.print("Enter the new Employee Salary: ");
            	int emp_salary = sc.nextInt();

            	System.out.print("Enter the new Employee Department: ");
            	sc.nextLine();
            	String emp_dept = sc.nextLine();

            	employeeDb.add(
            	    new Employee(emp_id, emp_name, emp_salary, emp_dept)
            	);

                System.out.println("Employee added successfully!");
            }

            else if(action == 2)
            {
            	if(employeeDb.size() == 0)
            	{
            		System.out.println("The employee list is empty!!!");
            		continue;
            	}

                System.out.println("\nDisplay all employees:");
                System.out.println("ID\tName\tSalary\tDepartment");

                for(Employee e : employeeDb)
                {
                    System.out.println(
                        e.emp_id + "\t" +
                        e.emp_name + "\t" +
                        e.emp_salary + "\t" +
                        e.emp_dept
                    );
                }
            }

            else if(action == 3)
            {
                System.out.print("Search the Employee Id: ");
                int emp_id = sc.nextInt();

                if(!ids.contains(emp_id))
                {
                	System.out.println("The Employee id does not exist!!!");
                	continue;
                }

                System.out.println("ID\tName\tSalary\tDepartment");

                for(Employee e : employeeDb)
                {
                    if(e.emp_id == emp_id)
                    {
                    	System.out.println(
                            e.emp_id + "\t" +
                            e.emp_name + "\t" +
                            e.emp_salary + "\t" +
                            e.emp_dept
                        );
                        break;
                    }
                }
            }

            else if(action == 4)
            {
            	System.out.print("Enter the Employee Id: ");
            	int emp_id = sc.nextInt();

            	if(!ids.contains(emp_id))
                {
                	System.out.println("The Employee id does not exist!!!");
                	continue;
                }

            	System.out.print("Enter the updated salary of the Employee: ");
            	int updated_salary = sc.nextInt();

            	for(Employee e : employeeDb)
            	{
            		if(e.emp_id == emp_id)
            		{
            			e.emp_salary = updated_salary;
            			System.out.println("The salary is updated successfully!!!");
            			break;
            		}
            	}
            }

            else if(action == 5)
            {
            	if(employeeDb.size() == 0)
            	{
            		System.out.println("The employee list is empty!!!");
            		continue;
            	}

            	Employee high = null;
            	int maxSalary = Integer.MIN_VALUE;

            	for(Employee e : employeeDb)
            	{
            		if(maxSalary < e.emp_salary)
            		{
            			high = e;
            			maxSalary = e.emp_salary;
            		}
            	}

            	System.out.println("Highest salary of the listed employee:");
            	System.out.println("ID\tName\tSalary\tDepartment");

            	System.out.println(
                    high.emp_id + "\t" +
                    high.emp_name + "\t" +
                    high.emp_salary + "\t" +
                    high.emp_dept
                );
            }

            else if(action == 6)
            {
            	System.out.print("Enter the Employee Id to delete: ");
            	int emp_id = sc.nextInt();

            	int index = -1;

            	for(int i = 0; i < employeeDb.size(); i++)
            	{
            	    if(employeeDb.get(i).emp_id == emp_id)
            	    {
            	        index = i;
            	        break;
            	    }
            	}

            	if(index != -1)
            	{
            	    employeeDb.remove(index);
            	    ids.remove(Integer.valueOf(emp_id));

            	    System.out.println("Employee deleted successfully!");
            	}
            	else
            	{
            	    System.out.println("Employee ID does not exist!");
            	}
            }

            else if(action == 7)
            {
            	System.out.println("-----------Exit--------------");
            	break;
            }

            else
            {
                System.out.println("Invalid Action!");
            }
        }

		sc.close();
	}
}