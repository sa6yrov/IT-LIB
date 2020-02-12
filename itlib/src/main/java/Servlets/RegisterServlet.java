package Servlets;

import AuthorizeRegistr.RegisterUser;
import DbConn.StudentDb;
import models.Student;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //test
        User user = new User(req.getParameter("login"), req.getParameter("password"), req.getParameter("email"));
        System.out.println(user);
//        RegisterUser registerUser = new RegisterUser();
//        registerUser.register(user);
//
//        String birtDate = req.getParameter("date");
//        Student student = new Student(req.getParameter("fullName"), req.ge);
//        StudentDb studentDb = new StudentDb();
//        studentDb.addStudentToDb(student);
    }
}
