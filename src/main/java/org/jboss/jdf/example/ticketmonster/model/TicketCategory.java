package org.jboss.jdf.example.ticketmonster.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>
 * A lookup table containing the various ticket categories. E.g. Adult, Child,
 * Pensioner, etc.
 * </p>
 */

@SuppressWarnings("serial")
@Entity
public class TicketCategory implements Serializable {
	/* Declaration of fields */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * <p>
	 * The description of the of ticket category.
	 * </p>
	 * 
	 * <p>
	 * The description forms the natural id of the ticket category, and so must
	 * be unique.
	 * </p>
	 * 
	 * <p>
	 * The description must not be null and must be one or more characters, the
	 * Bean Validation constraint <code>@NotEmpty</code> enforces this.
	 * </p>
	 * 
	 */
	@Column(unique = true)
	@NotEmpty
	private String description;

	/* Boilerplate getters and setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketCategory other = (TicketCategory) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
}
