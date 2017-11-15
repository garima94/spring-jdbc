package com.ca.bo;

public class CustomerBO {
	protected int cutomerNo;
	protected String firstNm;
	protected String lastNm;
	protected String contactNo;
	protected String emailAddress;

	public int getCutomerNo() {
		return cutomerNo;
	}

	public void setCutomerNo(int cutomerNo) {
		this.cutomerNo = cutomerNo;
	}

	public String getFirstNm() {
		return firstNm;
	}

	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}

	public String getLastNm() {
		return lastNm;
	}

	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "CustomerBO [cutomerNo=" + cutomerNo + ", firstNm=" + firstNm + ", lastNm=" + lastNm + ", contactNo="
				+ contactNo + ", emailAddress=" + emailAddress + "]";
	}

}
