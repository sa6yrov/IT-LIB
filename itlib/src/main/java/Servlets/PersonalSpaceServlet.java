package Servlets;

import DbConn.TrainingStuffDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/space")
public class PersonalSpaceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TrainingStuffDb trainingStuffDb = new TrainingStuffDb();
        req.setAttribute("stuff", trainingStuffDb.getStuffById(1));
        req.getRequestDispatcher("/pages/personalSpace.jsp").forward(req,resp);
    }
}
