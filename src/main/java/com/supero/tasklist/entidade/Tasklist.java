package com.supero.tasklist.entidade;

/**
 * Created by christian.tusset on 12/03/2018.
 */

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.supero.tasklist.persistencia.EntityPersistListener;

@Entity
@EntityListeners(EntityPersistListener.class)
public class Tasklist {

	private @Id @GeneratedValue Long id;
	private String title;
	private String description;
	private boolean done;
	private String key1;
	private String createDate;
	private String editDate;
	private String doneDate;

	public Tasklist() {}

	public Tasklist(String title, String description) {
		this.title = title;
		this.description = description;
		this.done = true;
	}

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

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getKey1() {
		return id.toString();
	}

	public String getEditDate() {
		return editDate;
	}

	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}

	public String getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(String doneDate) {
		this.doneDate = doneDate;
	}

	@Override
	public String toString() {
		return "Tasklist [id=" + id + ", titulo=" + title + ", descricao=" + description + ", feito="
				+ done + "]";
	}
}
