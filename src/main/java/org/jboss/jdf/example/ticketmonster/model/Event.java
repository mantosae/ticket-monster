package org.jboss.jdf.example.ticketmonster.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
public class Event implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "id", updatable = false, nullable = false)
	private Long id = null;

	@Column
	@NotNull
	@Size(message = "Must be > 5 and < 50", min = 5, max = 50)
	private String name;

	@Column
	@Size(message = "Must be > 20 and < 1000", min = 20, max = 1000)
	private String description;

	/**
	 * <p>
	 * The category of the event
	 * </p>
	 * 
	 * <p>
	 * Event categories are used to ease searching of available of events, and
	 * hence this is modeled as a relationship
	 * </p>
	 * 
	 * <p>
	 * The Bean Validation constraint <code>@NotNull</code> indicates that the
	 * event category must be specified.
	 */
	@ManyToOne
	@NotNull
	private EventCategory category;

	/**
	 * <p>
	 * A media item, such as an image, which can be used to entice a browser to
	 * book a ticket.
	 * </p>
	 * 
	 * <p>
	 * Media items can be shared between events, so this is modeled as a
	 * <code>@ManyToOne</code> relationship.
	 * </p>
	 * 
	 * <p>
	 * Adding a media item is optional, and the view layer will adapt if none is
	 * provided.
	 * </p>
	 * 
	 */
	@ManyToOne
	private MediaItem mediaItem;

	public MediaItem getMediaItem() {
		return mediaItem;
	}

	public void setMediaItem(MediaItem picture) {
		this.mediaItem = picture;
	}

	public EventCategory getCategory() {
		return category;
	}

	public void setCategory(EventCategory category) {
		this.category = category;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Event event = (Event) o;
		if (name != null ? !name.equals(event.name) : event.name != null)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}

	@Override
	public String toString() {
		return name;
	}
}