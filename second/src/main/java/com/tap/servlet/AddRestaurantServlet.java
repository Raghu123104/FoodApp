package com.tap.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;

import com.tap.DAOIMP.RestaurantDAOIMP;
import com.tap.Model.Restaurant;
import com.tap.Model.Users;

@WebServlet("/AddRestaurantServlet")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1,  // 1MB
    maxFileSize = 1024 * 1024 * 10,       // 10MB
    maxRequestSize = 1024 * 1024 * 15     // 15MB
)
public class AddRestaurantServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "restaurant_images"; // folder inside webapp
    private RestaurantDAOIMP restaurantDAO;

    @Override
    public void init() throws ServletException {
        restaurantDAO = new RestaurantDAOIMP();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int rating = Integer.parseInt(request.getParameter("rating"));
        String cusineType = request.getParameter("cusineType");
        int id=Integer.parseInt(request.getParameter("adminUserId"));
        boolean isActive = request.getParameter("isActive") != null;

        // Get current user from session
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("currentUser");
        if(user.getUserid()!=id) {
        	response.sendRedirect("Raghu.jsp");
        	return;
        }
        if (user == null) {
            response.sendRedirect("login.jsp"); // redirect if user is not logged in
            return;
        }

        // Handle file upload
        Part filePart = request.getPart("imageFile");
        String fileName = filePart.getSubmittedFileName();
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();
        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);
        String image = UPLOAD_DIR + "/" + fileName;

        // Create Restaurant object
        Restaurant restaurant = new Restaurant(name, address, phone, rating, cusineType, isActive,id, image);

        // Set Many-to-One relationship
        restaurant.setAdmin(user);
        

        // Save to database
        restaurantDAO.saveRestaurant(restaurant);

        response.sendRedirect("Demo.jsp");
    }
}


