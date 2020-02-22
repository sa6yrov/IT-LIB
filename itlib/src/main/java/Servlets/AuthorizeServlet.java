package Servlets;

import AuthorizeRegistr.AuthorizeUser;
import DbConn.DbConnection;
import models.User;
import models.UserLog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizeServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthorizeUser authorizeUser = new AuthorizeUser();
        User user = new User();
        user.setPassword(req.getParameter("password"));
        user.setLogin(req.getParameter("login"));

        boolean isOkay = authorizeUser.authorize(user.getLogin(), user.getPassword());
        String ok = "Authorize was successful!";
        String fail = "Your login or password is incorrect";
        if (isOkay) req.setAttribute("result", ok);
        else req.setAttribute("result", fail);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}