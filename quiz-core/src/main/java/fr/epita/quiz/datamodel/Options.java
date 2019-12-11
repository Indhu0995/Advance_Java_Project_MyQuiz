package fr.epita.quiz.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OPTIONS")
public class Options {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	
	@Column(name="qReference")
	private Integer qReference;
	
	@Column(name="valid")
	private boolean valid;
	
	@Column(name="mcqChoice")
	private String mcqChoice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getqReference() {
		return qReference;
	}

	public void setqReference(Integer qReference) {
		this.qReference = qReference;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getMcqChoice() {
		return mcqChoice;
	}

	public void setMcqChoice(String mcqChoice) {
		this.mcqChoice = mcqChoice;
	}

	public Options(Integer id, Integer qReference, boolean valid, String mcqChoice) {
		this.id = id;
		this.qReference = qReference;
		this.valid = valid;
		this.mcqChoice = mcqChoice;
	}

	public Options() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	

}
