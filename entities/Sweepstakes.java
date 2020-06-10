package br.com.imepac.site.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name="Sweepstakes")
public class Sweepstakes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo title é obrigatório!")
	private String title;
	
	@NotBlank(message = "O campo nome da description é obrigatório!")
	private String description;
	
	@NotBlank(message = "O campo nome do award é obrigatório!")
	private String award;
	
	@NotBlank(message = "O campo nome do creator é obrigatório!")
	private Long creator;
	
	@NotBlank(message = "O campo nome do date é obrigatório!")
	private Date date;
	
	@NotBlank(message = "O campo nome do type é obrigatório!")
	private Long type;
	
	private long winner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public long getWinner() {
		return winner;
	}

	public void setWinner(long winner) {
		this.winner = winner;
	}
	}
