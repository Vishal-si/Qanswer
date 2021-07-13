package model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Random;
public class Question {
	private String question_id;
	private String ques;
	private String topic;
	private String subTopic;
	private Date date;
	private Timestamp time;
	private UserModel umobj;
	private AnswerModel amobj;
	private CompanyModel cmobj;

	public Question() {
		
	}
	public Question(String ques, String topic, String question_id,String answer,String comment, String subTopic,Date date,Timestamp time,UserModel umobj,CompanyModel cmobj, AnswerModel amobj) {
		super();
	
		this.ques = ques;
		this.topic = topic;
		this.subTopic= subTopic;
		this.question_id=question_id;
		this.date =date;
		this.time=time;
		this.umobj = umobj;
		this.amobj = amobj;
		this.cmobj = cmobj;
	}

	public String getQues() {
		return ques;
	}
	public void setQues(String ques) {
		this.ques = ques;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}
	public String getSubTopic() {
		return subTopic;
	}
	public void setSubTopic(String subTopic) {
		this.subTopic = subTopic;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public UserModel getUmobj() {
		return umobj;
	}
	public void setUmobj(UserModel umobj) {
		this.umobj = umobj;
	}
	public AnswerModel getAmobj() {
		return amobj;
	}
	public void setAmobj(AnswerModel amobj) {
		this.amobj = amobj;
	}
	public CompanyModel getCmobj() {
		return cmobj;
	}
	public void setCmobj(CompanyModel cmobj) {
		this.cmobj = cmobj;
	}

	
	
	

}
