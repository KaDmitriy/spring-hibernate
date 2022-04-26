package exe.np.springhibernate.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "book", schema = "public")
public class BookView {

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Type(type = "pg-uuid")
	private UUID uid;
	private String name;
	private String descr;
	private Date release;
	private Integer pages;

	/**
	 * @Formula prohibited from using @Query in DAO
	 * 
	 * uncomment BookViewDAO List<BookView> findAllQuery();
	 */
	/*
	@Transient
	@Column(name = "count_user")
	//@Formula("(select count(*) from public.book_user bu where bu.bookid = uid and bu.userid='b47d48df-c10b-445a-b1d2-471526b480c9')")
	private Integer countUser;
	*/
	
	//@ManyToOne(optional=false)
	//@JoinColumn (name="bookid", insertable=false, updatable=false)
	//private BookUserView countUser;

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


}
