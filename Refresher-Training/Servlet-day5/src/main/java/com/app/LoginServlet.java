package com.app;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
    description = "Login Servlet Testing",
    urlPatterns = { "/LoginServlet" },
    initParams = {
        @WebInitParam(name = "user", value = "Shashwat"),
        @WebInitParam(name = "password", value = "shashwat123"),
    }
)

public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Validate Name (UC3)
        if(!isValidName(user)){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            out.println("<font color=red>Invalid Name: Must start with a capital letter and have at least 3 characters.</font>");
            rd.include(request, response);
            return;
        }

        //Validate Password (UC4)
        if(!isValidPassword(pwd)){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            out.println("<font color=red>Invalid Password: must be 8+ chars, contain 1 uppercase letter, 1 digit, and exactly 1 special character.</font>");
            rd.include(request, response);
            return;
        }

        //Check credentials against predefined user (UC2)
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

        if(userID.equals(user) && password.equals(pwd)){
            request.setAttribute("user", user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        }
        else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
        }

        private boolean isValidName(String name) {
        if (name == null || name.length() < 3) {
            return false;
        }
        return Character.isUpperCase(name.charAt(0));
        }

        private boolean isValidPassword(String pwd) {
        if (pwd == null || pwd.length() < 8) {
            return false; // Rule 1
        }

        boolean hasUpper = false;
        boolean hasDigit = false;
        int specialCount = 0;

        for (char c : pwd.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                specialCount++;
            }
        }

        return hasUpper && hasDigit && (specialCount == 1); // Rules 2, 3, 4
    }
}
