package model;
/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016 
 * @mail zgolliasma@gmail.com
 */
import java.util.Date;

public class Record {
	private int id;
	private String label;
	private int ammont;
	/* join */
	private String category;
	private Date CreatedIn;
	private String description;

	/* modifiers */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String type) {
		this.category = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getAmmont() {
		return ammont;
	}

	public void setAmmont(int ammont) {
		this.ammont = ammont;
	}

	public Date getCreatedIn() {
		return CreatedIn;
	}

	public void setCreatedIn(Date createdIn) {
		CreatedIn = createdIn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Record : \n id=" + id + ", \n label=" + label + ", \n ammont=" + ammont + ", \n category=" + category
				+ ", \n CreatedIn=" + CreatedIn + ", \n description=" + description;
	}

}
