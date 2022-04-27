package exe.np.springhibernate.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class BookUserViewId implements Serializable {

	private static final long serialVersionUID = -7737524637398028358L;

	private UUID bookUid;
	private UUID userUid;

	public BookUserViewId(UUID bookUid, UUID userUid) {
		super();
		this.bookUid = bookUid;
		this.userUid = userUid;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(bookUid, userUid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookUserViewId other = (BookUserViewId) obj;
		return Objects.equals(bookUid, other.bookUid) && Objects.equals(userUid, other.userUid);
	}

}
