package model;

import java.util.Date;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.metamodel.relational.Size;


@Entity
public class Questions {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "Question" , nullable = false, unique = false, length = 2000)
    private String question;
    @Column(name = "Title" , nullable = false, unique = false, length = 500)
    private String title;
    @Column(name = "Vote")
    private int vote;
    @Column(name = "User_Email" , nullable = false, unique = false, length = 100)
    private String Email;
    @Column(name = "Question_Date" , nullable = false, unique = true)
    private Date date ;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }
    
    
    
    
    
    
}
