package model;

public class Feedback {
	
	private String likeid;
	private boolean like;
	private boolean dislike;
	private String comment;
	private AnswerModel amobj;
	private UserModel umobj;
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feedback(String likeid,boolean like, boolean dislike, String comment, AnswerModel amobj, UserModel umobj) {
		super();
		this.likeid = likeid;
		this.like = like;
		this.dislike = dislike;
		this.comment = comment;
		this.amobj = amobj;
		this.umobj = umobj;
	}
	
	
	public String getLikeid() {
		return likeid;
	}
	public void setLikeid(String likeid) {
		this.likeid = likeid;
	}
	public boolean getLike() {
		return like;
	}
	public void setLike(boolean like) {
		this.like = like;
	}
	public boolean getDislike() {
		return dislike;
	}
	public void setDislike(boolean dislike) {
		this.dislike = dislike;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public AnswerModel getAmobj() {
		return amobj;
	}
	public void setAmobj(AnswerModel amobj) {
		this.amobj = amobj;
	}
	public UserModel getUmobj() {
		return umobj;
	}
	public void setUmobj(UserModel umobj) {
		this.umobj = umobj;
	}
	
	

}
