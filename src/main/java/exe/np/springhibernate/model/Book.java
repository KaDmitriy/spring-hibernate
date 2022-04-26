/**
 * 
 */
package exe.np.springhibernate.model;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * Book
 * 
 * @author Kartashov Dmitriy
 *
 */

@Entity
@Table(name = "book", schema = "public")
public class Book {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Type(type = "pg-uuid")
	private UUID uid;
	private String name;
	private String descr;
	private Date release;
	private Integer pages;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "book_user", schema = "public", 
     joinColumns = @JoinColumn(name = "`bookid`"),
     inverseJoinColumns = @JoinColumn(name = "`userid`"))
	private Set<User> users;

	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "book_author", schema = "public",
     joinColumns = @JoinColumn(name = "`bookid`"),
     inverseJoinColumns = @JoinColumn(name = "`authorid`"))
	private Set<Author> authors;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getUid() {
		return uid;
	}

	public void setUid(UUID uid) {
		this.uid = uid;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Book [uid=" + uid + ", name=" + name + ", descr=" + descr + ", release=" + release + ", pages=" + pages
				+ ", users=" + users + ", authors=" + authors + "]";
	}

}
