/**
 * 
 */
package exe.np.springhibernate.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author Kartashov Dmitriy
 *
 */

@Entity
@Table(name = "book_user", schema = "public")
@IdClass(BookUserViewId.class)
public class BookUserView {
	@Id
	@Column(name = "userid")
	private UUID userid;
	@Id
	@Column(name = "bookid")
	private UUID bookid;

	public UUID getUserid() {
		return userid;
	}

	public void setUserid(UUID userid) {
		this.userid = userid;
	}

	public UUID getBookid() {
		return bookid;
	}

	public void setBookid(UUID bookid) {
		this.bookid = bookid;
	}

}
