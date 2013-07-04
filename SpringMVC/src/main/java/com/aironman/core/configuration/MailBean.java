package com.aironman.core.configuration;

public class MailBean {

	private String userMail;
	private String passMail;
	private String emailTo;

	public MailBean() {

	}

	public MailBean(String userMail, String passMail) {
		super();
		this.userMail = userMail;
		this.passMail = passMail;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getPassMail() {
		return passMail;
	}

	public void setPassMail(String passMail) {
		this.passMail = passMail;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	@Override
	public String toString() {
		return "MailBean [userMail=" + userMail + ", passMail=" + passMail
				+ ", emailTo=" + emailTo + "]";
	}

}
