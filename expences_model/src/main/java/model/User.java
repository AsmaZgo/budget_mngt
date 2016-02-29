package model;
/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016 
 * @mail zgolliasma@gmail.com
 */
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private int id;
	private String fname;
	private String lname;
	private int tel;
	private String login;
	private String passwd;
	private String mail;
	private String role;

	private String membership;

	@XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlAttribute
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@XmlAttribute
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@XmlAttribute
	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	@XmlAttribute
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@XmlAttribute
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@XmlAttribute
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@XmlAttribute
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@XmlAttribute
	public String getMembership() {
		return membership;
	}

	@XmlAttribute
	public void setMembership(String membership) {
		this.membership = membership;
	}

	@Override
	public String toString() {
		return "User :\n id = " + id + ",\n fname = " + fname + ",\n lname = " + lname + ",\n tel = " + tel
				+ ",\n login = " + login + ",\n passwd = " + passwd + ",\n mail = " + mail + ",\n role = " + role
				+ ",\n membership = " + membership;
	}

}
