package model;
/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016 
 * @mail zgolliasma@gmail.com
 */
import java.util.Date;
import java.util.List;

public class Category {
	private int id;
	private String label;
	/* income / expence */
	private String type;
	private Date modifiedIn;
	private String description;
	private List<Record> records;

	/* modifiers */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getModifiedIn() {
		return modifiedIn;
	}

	public void setModifiedIn(Date modifiedIn) {
		this.modifiedIn = modifiedIn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	/* ToString */
	@Override
	public String toString() {
		return "Category : \n id = " + id + ", \n label = " + label + ", \n type = " + type + ", \n modifiedIn = "
				+ modifiedIn + ", \n description = " + description;
	}

}
