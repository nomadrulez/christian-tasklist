package com.supero.tasklist.persistencia;

/**
 * Created by christian.tusset on 12/03/2018.
 */

import java.util.Date;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import com.supero.tasklist.entidade.Tasklist;
import com.supero.tasklist.utils.DateUtils;

public class EntityPersistListener {

	   @PrePersist
	   public void beforeCreate(final Tasklist reference) {
		   Date date = DateUtils.getCurrentDate();
		   String dateToString = DateUtils.dateTimeToString(date);
		   
		   reference.setCreateDate(dateToString);

		   if (reference.isDone() && (reference.getDoneDate() == null || reference.getDoneDate().isEmpty())) {
			   reference.setDoneDate(dateToString);
		   }
	   }	

	   @PreUpdate
	   public void beforeUpdate(final Tasklist reference) {
		   Date now = DateUtils.getCurrentDate();
		   String nowAsString = DateUtils.dateTimeToString(now);

		   reference.setEditDate(nowAsString);

		   if (reference.isDone() && (reference.getDoneDate() == null || reference.getDoneDate().isEmpty())) {
			   reference.setDoneDate(nowAsString);
		   }
	   }
}
