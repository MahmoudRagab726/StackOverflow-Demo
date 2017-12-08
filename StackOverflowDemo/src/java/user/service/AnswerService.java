/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user.service;

import java.util.List;
import model.Answers;
import user.dao.AnswerDao;
import user.dao.IAnswerDAO;
import userservice.Interfaces.IAnswerService;

/**
 *
 * @author Mahmoud Ragab
 */
public class AnswerService implements IAnswerService{
    IAnswerDAO answerDAO;
    @Override
    public void addQuestion(Answers answer) {
        getAnswerDAO().addAnswer(answer);
        
    }

    @Override
    public List<Answers> getAllAnswers(int id) {
        return getAnswerDAO().getAllAnswers(id);
    }
    
    

    public IAnswerDAO getAnswerDAO() {
        if (answerDAO == null) {
            answerDAO = new AnswerDao();
        }
        return answerDAO;
    }
    
}
