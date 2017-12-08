/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "Answers")
public class Answers {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "Answer", length = 2000, nullable = false)
    private String answerText;
    @Column(name = "Answer_Date", nullable = false)
    private Date date;
    @Column(name = "User_Email" , nullable = false, unique = false, length = 100)
    private String Email;
    @Column(name = "Quesion_Id")
    private int quesionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getQuesionId() {
        return quesionId;
    }

    public void setQuesionId(int quesionId) {
        this.quesionId = quesionId;
    }
    
    
    
}
