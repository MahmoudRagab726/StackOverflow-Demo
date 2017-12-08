/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package userservice.Interfaces;

import java.util.List;
import model.Questions;

/**
 *
 * @author Mahmoud Ragab
 */
public interface IQuestionService {
    public void addQuestion(Questions question);
    public List<Questions> getAllQuestions();
    public List<Questions> getQuestionsByEmail(String email);
    public void deleteQuestion(int id);
    public void updateQuestion(Questions question);
    public List<Questions> getOneQuestion(int id);
}
