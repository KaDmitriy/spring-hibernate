package exe.np.springhibernate.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * System user
 * 
 * @author Kartashov Dmitriy
 *
 */

@Entity
@Table(name = "user", schema = "public")
public class User {

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
		return "User [uid=" + uid + ", name=" + name + "]";
	}
}
