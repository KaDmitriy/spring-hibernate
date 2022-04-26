/**
 * 
 */
package exe.np.springhibernate.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author KDA
 *
 */

public class MultiTableId implements Serializable {

	private static final long serialVersionUID = -2143797043879690411L;
	
	private String f1;
	private String f2;

	public MultiTableId(String f1, String f2) {
		this.f1 = f1;
		this.f2 = f2;
	}

	public String getF1() {
		return f1;
	}

	public void setF1(String f1) {
		this.f1 = f1;
	}

	public String getF2() {
		return f2;
	}

	public void setF2(String f2) {
		this.f2 = f2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(f1, f2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MultiTableId other = (MultiTableId) obj;
		return Objects.equals(f1, other.f1) && Objects.equals(f2, other.f2);
	}

}
