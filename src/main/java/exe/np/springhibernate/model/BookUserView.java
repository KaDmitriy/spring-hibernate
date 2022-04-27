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
	@Column(name = "bookuid")
	private UUID bookUid;

	@Id
	@Column(name = "useruid")
	private UUID userUid;

	public UUID getBookUid() {
		return bookUid;
	}

	public void setBookUid(UUID bookUid) {
		this.bookUid = bookUid;
	}

	public UUID getUserUid() {
		return userUid;
	}

	public void setUserUid(UUID userUid) {
		this.userUid = userUid;
	}

}
