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

        User user = new User(req.getParameter("login"), req.getParameter("password"), req.getParameter("email"));
        RegisterUser registerUser = new RegisterUser();
        System.out.println(registerUser.register(user));

        int hash = user.hashCode();
        Integer groupId = Integer.valueOf(req.getParameter("course"));
        StudentDb studentDb = new StudentDb();
        Student student = new Student(req.getParameter("fullName"), req.getParameter("date"), req.getParameter("gender"), groupId + "" + hash, req.getParameter("phone"),
                                        groupId, studentDb.getUserId(user.getLogin()));
        System.out.println(studentDb.addStudentToDb(student));

    }
}
