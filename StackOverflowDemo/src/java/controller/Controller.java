package controller;

import beans.QuestionBean;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import model.Questions;

public class Controller extends HttpServlet {

    Questions q;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String data = request.getParameter("id");
        System.out.println("IDDDDD : "+data);
        String status = request.getParameter("status");
        if (status.equals("delete") && data != null) {
            int id = Integer.parseInt(data);
            new QuestionBean().deleteQuestion(id);
            response.sendRedirect("Show.sakr");
        }else if(status.equals("logout")){
            request.getSession().invalidate();
            response.sendRedirect("Login.sakr");
        }
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String data = request.getParameter("id");
        int id = Integer.parseInt(data);
        String title = request.getParameter("title");
        String question = request.getParameter("question");
        q = new QuestionBean().getOneQuestion(id).get(0);
        q.setTitle(title);
        q.setQuestion(question);
        new QuestionBean().updateQuestion(q);
        response.sendRedirect("Show.sakr");

    
    }
    

}
