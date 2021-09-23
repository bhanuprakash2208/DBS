package com.dbs.web.service;

import java.util.List;

import com.dbs.web.beans.Loan;
import com.dbs.web.exception.EntityNotFoundException;

public class LoanService {


	
	
	public Loan findLoanById(String loanId) throws EntityNotFoundException
	{
		return null;
	}
	
	
	public boolean uploadCollateral(String loanId, List<String> collateralIds) 
	{
		
		return true;		
	}
	public Loan applyForLoan(String loanType,
			double loanAmount,
			double period, String email)
	{
		
		return null;
	}
}
