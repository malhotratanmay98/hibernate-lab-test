package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.persistence.BranchEnum;
import com.model.persistence.Trainee;
import com.model.service.TraineeService;
import com.model.service.TraineeServiceImpl;

@WebServlet("/TraineeController.do")
public class TraineeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private TraineeService traineeService= new TraineeServiceImpl();
   
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("showall")) {
			
			List<Trainee> trainees = traineeService.getAll();
			request.setAttribute("trainees",trainees);
			RequestDispatcher rd = request.getRequestDispatcher("alltrainees.jsp");
			rd.forward(request, response);
			
		}
		else if(action.equalsIgnoreCase("addtrainee")) {
			RequestDispatcher rd = request.getRequestDispatcher("addtrainee.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//Integer id=Integer.parseInt(request.getParameter("id").trim());
		
		String name=request.getParameter("trainee_name");
		String branch=request.getParameter("branch").toUpperCase();
		Double percentage=Double.parseDouble(request.getParameter("percentage"));
	
		
		Trainee trainee=new Trainee(name,BranchEnum.valueOf(branch),percentage);
		 
		 traineeService.addTrainee(trainee);
		
		
		response.sendRedirect("TraineeController.do?action=showall");  //redirecting to the same page but with value showall
		
	}

}
