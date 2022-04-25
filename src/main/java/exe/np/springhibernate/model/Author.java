/**
 * 
 */
package exe.np.springhibernate.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * Book author
 * 
 * @author Kartashov Dmitriy
 *
 */

@Entity
@Table(name = "author", schema = "public")
public class Author {
	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Type(type = "pg-uuid")
	private UUID uid;
	private String name;

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

	@Override
	public String toString() {
		return "Author [uid=" + uid + ", name=" + name + "]";
	}

}
