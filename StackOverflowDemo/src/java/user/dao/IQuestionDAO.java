/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user.dao;

import java.util.List;
import model.Questions;


/**
 *
 * @author Mahmoud Ragab
 */
public interface IQuestionDAO {
	public void addQuestion(Questions question);
        public List<Questions> getAllQuestions();
        public List<Questions> getQuestionsByEmail(String email);
	public void updateQuestion(Questions question);
	public List<Questions>  getOneQuestion(int id);
	
	public void deleteQuestion(int id);
	
    
}
