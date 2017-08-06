package Database_user;

public class cEmployee {

	String fuid, vmob, vemail, vadr, vcity, vsal, cdesg, cbranch;

	public cEmployee(String fuid, String vmob, String vemail, String vadr, String vcity, String vsal, String cdesg,
			String cbranch) {
		super();
		this.fuid = fuid;
		this.vmob = vmob;
		this.vemail = vemail;
		this.vadr = vadr;
		this.vcity = vcity;
		this.vsal = vsal;
		this.cdesg = cdesg;
		this.cbranch = cbranch;
	}

	public String getFuid() {
		return fuid;
	}

	public void setFuid(String fuid) {
		this.fuid = fuid;
	}

	public String getVmob() {
		return vmob;
	}

	public void setVmob(String vmob) {
		this.vmob = vmob;
	}

	public String getVemail() {
		return vemail;
	}

	public void setVemail(String vemail) {
		this.vemail = vemail;
	}

	public String getVadr() {
		return vadr;
	}

	public void setVadr(String vadr) {
		this.vadr = vadr;
	}

	public String getVcity() {
		return vcity;
	}

	public void setVcity(String vcity) {
		this.vcity = vcity;
	}

	public String getVsal() {
		return vsal;
	}

	public void setVsal(String vsal) {
		this.vsal = vsal;
	}

	public String getCdesg() {
		return cdesg;
	}

	public void setCdesg(String cdesg) {
		this.cdesg = cdesg;
	}

	public String getCbranch() {
		return cbranch;
	}

	public void setCbranch(String cbranch) {
		this.cbranch = cbranch;
	}
	
}
