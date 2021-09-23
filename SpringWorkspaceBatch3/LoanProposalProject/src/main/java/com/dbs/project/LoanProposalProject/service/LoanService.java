package com.dbs.project.LoanProposalProject.service;

import java.util.List;

import com.dbs.project.LoanProposalProject.exception.EntityNotFoundException;
import com.dbs.project.LoanProposalProject.model.Loan;



public class LoanService {



	public Loan findLoanById(String loanId) throws EntityNotFoundException
	{
		return null;
	}


	public boolean uploadCollateral(String loanId, List<String> collateralIds) 
	{


		return true;		

	}
	public Loan applyForLoan(String loanType, double loanAmount,
			double period, String email)
	{
		System.out.println("applying for loan");

		return null;
	}

}
