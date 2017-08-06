package Database_user;

public class TDonorRecord {
	String vuid, vmob, vadr, vcity, vdate;
	
	TDonorRecord(){
		
	}
	
	
	public TDonorRecord(String vuid, String vmob, String vadr, String vcity, String vdate) {
		super();
		this.vuid = vuid;
		this.vmob = vmob;
		this.vadr = vadr;
		this.vcity = vcity;
		this.vdate = vdate;
	}


	public String getVuid() {
		return vuid;
	}

	public void setVuid(String vuid) {
		this.vuid = vuid;
	}

	public String getVmob() {
		return vmob;
	}

	public void setVmob(String vmob) {
		this.vmob = vmob;
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

	public String getVdate() {
		return vdate;
	}

	public void setVdate(String vdate) {
		this.vdate = vdate;
	}
	
}
