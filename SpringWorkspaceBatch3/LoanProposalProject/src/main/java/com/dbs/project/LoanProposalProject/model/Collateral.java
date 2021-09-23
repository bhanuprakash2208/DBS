package com.dbs.project.LoanProposalProject.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Collateral  implements Serializable{
	@Id
	private String collateralId;
	private String collateralType;
	
	@ManyToOne
	@JoinColumn(name="loanId")
	private Loan loan;
	
	


	public Collateral() {
		System.out.println("entity created");
	}

	public Collateral(String collateralId, String collateralType) {
		super();
		this.collateralId = collateralId;
		this.collateralType = collateralType;
	}

	public String getCollateralId() {
		return collateralId;
	}

	public void setCollateralId(String collateralId) {
		this.collateralId = collateralId;
	}

	public String getCollateralType() {
		return collateralType;
	}

	public void setCollateralType(String collateralType) {
		this.collateralType = collateralType;
	}
	
	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	@Override
	public String toString() {
		return "Collateral [collateralId=" + collateralId + ", collateralType=" + collateralType + "]";
	}
	
}
