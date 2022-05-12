package exe.np.springhibernate.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "book", schema = "public")
public class BookView {

	@Id
	@Type(type = "pg-uuid")
	private UUID uid;
	private String name;
	private String descr;
	private Integer pages;
	private Date release;

	public UUID getUid() {
		return uid;
	}

	public void setUid(UUID uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	@Override
	public String toString() {
		return "BookView [uid=" + uid + ", name=" + name + ", descr=" + descr + ", pages=" + pages + ", release="
				+ release + "]";
	}

}
