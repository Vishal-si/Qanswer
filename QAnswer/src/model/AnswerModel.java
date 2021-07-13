package model;

public class AnswerModel {

	private String ansid;
	private String answer;
	private CompanyModel cmobj;
	private Question qobj;
	public AnswerModel(String ansid, String answer, CompanyModel cmobj, Question qobj) {
		super();
		this.ansid = ansid;
		this.answer = answer;
		this.cmobj = cmobj;
		this.qobj = qobj;
	}
	public AnswerModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAnsid() {
		return ansid;
	}
	public void setAnsid(String ansid) {
		this.ansid = ansid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public CompanyModel getCmobj() {
		return cmobj;
	}
	public void setCmobj(CompanyModel cmobj) {
		this.cmobj = cmobj;
	}
	public Question getQobj() {
		return qobj;
	}
	public void setQobj(Question qobj) {
		this.qobj = qobj;
	}
	
	
	
	
}
