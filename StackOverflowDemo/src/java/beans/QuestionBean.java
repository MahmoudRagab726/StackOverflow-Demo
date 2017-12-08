package beans;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import model.Answers;
import model.Questions;
import user.service.QuestionService;
import userservice.Interfaces.IQuestionService;

@ManagedBean
@RequestScoped
public class QuestionBean {
    @ManagedProperty(value = "#{userBean}") 
    private UserBean userBean;
    private String question;
    private String title;
    private int vote ;
    private String Email;
    private Date date;
    private int id;
    private Questions editQuestion;
    IQuestionService questionService;
   
    
    public String addQuestion(){
        try{
            Questions q=new Questions();
            q.setQuestion(question);
            q.setTitle(title);
            q.setEmail(userBean.getEmail());
            q.setDate(new Date());
            getQuestionService().addQuestion(q);
        }catch(Exception e){
           e.printStackTrace();
        }
        return "Show";
    }
    
    public List<Questions> getAllQuestions(){
        return getQuestionService().getAllQuestions();
       
        
    }
    public List<Questions> getQuestionsByEmail(){
        return getQuestionService().getQuestionsByEmail(userBean.getEmail());
       
        
    }
    public void deleteQuestion(int id){
        try{
            getQuestionService().deleteQuestion(id);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public void updateQuestion(Questions question){
        getQuestionService().updateQuestion(question);
        getQuestionService().getQuestionsByEmail(Email);
        
    }
    public List<Questions> getOneQuestion(int id){
        if(id>0)
            AnswerBean.setQuestion_id(id);
            return getQuestionService().getOneQuestion(id);
        
    }
    
//    public void submitUserResponse() throws IOException{
//        System.out.println("UUUUUUUUUUU");
//    String uri = "Controller";
//    FacesContext.getCurrentInstance().getExternalContext().dispatch(uri);
//}  
    

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

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public Questions getEditQuestion() {
        return editQuestion;
    }

    public void setEditQuestion(Questions editQuestion) {
        this.editQuestion = editQuestion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    
    
     public IQuestionService getQuestionService() {
		if(questionService==null){
                    questionService=new QuestionService();
                }
                return questionService;
	}
    
}
