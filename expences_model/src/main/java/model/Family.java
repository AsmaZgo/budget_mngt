package model;
/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016 
 * @mail zgolliasma@gmail.com
 */
public class Family {
	private String ref;
	private int budget;
	private Users members;
	private int Home_tel;

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getHome_tel() {
		return Home_tel;
	}

	public void setHome_tel(int home_tel) {
		Home_tel = home_tel;
	}

	public Users getMembers() {
		return members;
	}

	public void setMembers(Users members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Family : \n ref=" + ref + ", \n budget=" + budget + ", \n members=" + members;
	}

}
