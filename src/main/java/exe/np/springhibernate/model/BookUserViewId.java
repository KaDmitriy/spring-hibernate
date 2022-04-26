package exe.np.springhibernate.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class BookUserViewId  implements Serializable {

	private static final long serialVersionUID = -7737524637398028358L;

	private UUID bookid;
	private UUID userid;
	

	public BookUserViewId(UUID bookid, UUID userid) {
		this.userid = userid;
		this.bookid = bookid;
	}

	@Override
	public String toString() {
		return "BookUserViewId [userid=" + userid + ", bookid=" + bookid + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookid, userid);
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
		return Objects.equals(bookid, other.bookid) && Objects.equals(userid, other.userid);
	}

}
