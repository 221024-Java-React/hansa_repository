package com.revature;

import com.revature.controllers.EmployeeController;
import com.revature.dao.FileIO;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoFile;
import com.revature.exceptions.EmployeeDoesNotExistException;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

import io.javalin.Javalin;

public class EmployeeManagementDriver {

	public static void main(String[] args) {
		EmployeeDao pDao = new EmployeeDaoFile();
		EmployeeService pServ = new EmployeeService(pDao);
		EmployeeController pController = new EmployeeController(pServ);
		
		//Setup our javalin app and routes
		Javalin app = Javalin.create(config -> {
		    config.plugins.enableCors(cors -> {
		        cors.add(it -> {
		            it.anyHost();
		        });
		    });
		});
		
		//Here we would have our routes/handlers
		app.get("/hello", (ctx) -> ctx.result("Hello, we are making our first get request"));
		
		app.post("/employee/register", pController.handleRegister);
		app.get("/employee/", pController.handleGetAll);
		app.post("employee/login", pController.handleLogin);
		
		/*
		//We can also register handlers to deal with exceptions
		app.exception(EmployeeDoesNotExistException.class, (e, context) -> {
			context.status(401);
			context.result("You were unable to login");
		});
		*/
		
		//Finally we start the application
		app.start(8000);
		
		/*
		Employee p = new Employee("Ethan", "McGill", true, "email@mail.com", "password");
		FileIO<Employee> personIO = new FileIO<Employee>("Ethan_Mcgill.txt");
		
		personIO.writeObject(p);
		
		System.out.println(personIO.readObject());
		//The easiest way to test before we have an api setup is through the driver
		EmployeeDao pDao = new EmployeeDaoFile();
		EmployeeService pService = new EmployeeService(pDao);
		
		pService.registerEmployee("Andrew", "Hint", false, "andrew@mail.com", "password");
		
		System.out.println(pService.login("ethan@mail.com"));
		//pDao.addEmployee(new Employee("Ethan", "McGill", true, "ethan@mail.com", "password"));
		
		System.out.println(pDao.getAllPeople());
		*/
	}

}
