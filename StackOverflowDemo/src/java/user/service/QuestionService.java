/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.service;

import java.util.List;
import model.Questions;
import user.dao.IQuestionDAO;
import user.dao.IUserDAO;
import user.dao.QuestionDao;
import user.dao.UserDao;
import userservice.Interfaces.IQuestionService;

/**
 *
 * @author Mahmoud Ragab
 */
public class QuestionService implements IQuestionService {

    IQuestionDAO quesionDAO;

    @Override
    public void addQuestion(Questions question) {
        getQuestionDAO().addQuestion(question);

    }
    
    @Override
    public List<Questions> getAllQuestions() {
        return getQuestionDAO().getAllQuestions();
    }

    @Override
    public List<Questions> getQuestionsByEmail(String email) {
        return getQuestionDAO().getQuestionsByEmail(email);
    }

    @Override
    public void deleteQuestion(int id) {
       getQuestionDAO().deleteQuestion(id);
    }

    @Override
    public void updateQuestion(Questions question) {
       getQuestionDAO().updateQuestion(question);
    }

    @Override
    public List<Questions> getOneQuestion(int id) {
        return getQuestionDAO().getOneQuestion(id);
    }
    
    
    

    public IQuestionDAO getQuestionDAO() {
        if (quesionDAO == null) {
            quesionDAO = new QuestionDao();
        }
        return quesionDAO;
    }

    

}
