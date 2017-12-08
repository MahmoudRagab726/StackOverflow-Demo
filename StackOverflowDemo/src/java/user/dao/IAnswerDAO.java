/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user.dao;

import java.util.List;
import model.Answers;

/**
 *
 * @author Mahmoud Ragab
 */
public interface IAnswerDAO {
    public void addAnswer(Answers answer);
    public List<Answers> getAllAnswers(int id);
    
}
