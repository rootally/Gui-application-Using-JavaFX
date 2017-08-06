package Database_user;

public class cBranch_Master 
{
	String vbranch, vadr, vloc;

	public cBranch_Master(String vbranch, String vadr, String vloc) {
		super();
		this.vbranch = vbranch;
		this.vadr = vadr;
		this.vloc = vloc;
	}

	public String getVbranch() {
		return vbranch;
	}

	public void setVbranch(String vbranch) {
		this.vbranch = vbranch;
	}

	public String getVadr() {
		return vadr;
	}

	public void setVadr(String vadr) {
		this.vadr = vadr;
	}

	public String getVloc() {
		return vloc;
	}

	public void setVloc(String vloc) {
		this.vloc = vloc;
	}
}
