package com.tap.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

import com.tap.DAOIMP.MenuDAOIMP;
import com.tap.Model.Menu;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItemServlet")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 1,  // 1MB
	    maxFileSize = 1024 * 1024 * 10,       // 10MB
	    maxRequestSize = 1024 * 1024 * 15     // 15MB
	)
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "restaurant_images"; // folder inside webapp
	 private MenuDAOIMP menu;//instance variable
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		menu =new MenuDAOIMP();
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int restaurantId=Integer.parseInt(request.getParameter("restaurantId"));
		String itemName=request.getParameter("itemName");
		String description=request.getParameter("description");
		int price=Integer.parseInt(request.getParameter("price"));
		boolean isAvailable =Boolean.parseBoolean("isavailable");
		
		int rating=Integer.parseInt(request.getParameter("rating"));
		
		 // Handle file upload
        Part filePart = request.getPart("imageFile");
        String fileName = filePart.getSubmittedFileName();
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();
        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);
        String image = UPLOAD_DIR + "/" + fileName;
		Menu m=new Menu(itemName,description,price,rating,
				isAvailable,image);
		menu.addItem(m,restaurantId);
		request.getRequestDispatcher("Demo.jsp").forward(request, response);
		
		
		
	
		
		
	}

}
