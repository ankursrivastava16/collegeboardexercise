package com.collegeboard.codeassignment;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class StudentUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String highSchoolGradDate = null;
		String givenDate = null;
		String userInput = null;
		while(true) {
	
		System.out.print("Enter the High School Grad Date (yyyy-MM-dd):");	
		highSchoolGradDate = scanner.nextLine();
		if(StringUtils.isEmpty(highSchoolGradDate) || null == highSchoolGradDate) {
			System.out.print("Pls Enter the High School Grad Date (yyyy-MM-dd).Null or space will not be accepted:");	
			System.exit(0);	
		}
		System.out.print("Enter the Given Date yyyy-MM-dd :");	
		givenDate = scanner.nextLine();
		if(StringUtils.isEmpty(givenDate) || null == givenDate) {
			Date date = new Date();
			givenDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
		}
		int compDateResult1 = getGradeOnGivenDate1(highSchoolGradDate, givenDate);
		if (compDateResult1 == 99) {
			System.out.println("Already Graduated Out Of High School");
		} else if (compDateResult1 != 0 && compDateResult1 > 0 && compDateResult1 <= 10) {
			System.out.println(compDateResult1 + " grade");
		} else if (compDateResult1 == 0) {
			System.out.println("Kindergarten grade");
		} else {
			System.out.println("Pre School");
		}
		
		
		System.out.println("Do you want to process more .Type yes else done to exit");	
		userInput = scanner.nextLine();
		if (userInput.equals("done")) {
			System.exit(0);	
			}
		
	}
		
	}

	public static int getGradeOnGivenDate1(String highSchoolGradDate, String givenDate) {
		int resultVal = 0;

		
		String kgStartDateStr = null;
		int checkIfGraduated = 0;

		
		LocalDate highSchoolGraduationDate = LocalDate.parse(highSchoolGradDate);
		LocalDate givenComparisonDate = LocalDate.parse(givenDate);

		/***
		 * 
		 * Check if already graduated
		 */
		checkIfGraduated = givenComparisonDate.compareTo(highSchoolGraduationDate);
		if (checkIfGraduated >= 1) {
			return 99;
		}

		LocalDate eduStartDateYear = highSchoolGraduationDate.minusYears(11);

		/**
		 * Based on Grad date we will calculate the KG and grade dates
		 * 
		 */

		kgStartDateStr = eduStartDateYear.getYear() + "-09-01";
		LocalDate kgStartDate = LocalDate.parse(kgStartDateStr);

		/*kgFinishedtDate = eduStartDateYear.plusDays(304);

		if (kgFinishedtDate.isLeapYear()) {
			System.out.println("Leap yearr");
			kgFinishedtDate = kgFinishedtDate.plusDays(1);
		}*/
		//System.out.println("kgFinishedDate " + kgFinishedtDate);

		
		int noOfYears = Period.between(kgStartDate, givenComparisonDate).getYears();

		//System.out.println(noOfYears + " noOfYears");
		if (noOfYears != 0 && noOfYears > 0 && noOfYears <= 10) {
		
			resultVal = noOfYears;

		} else if (noOfYears == 0) {

			resultVal = 0;
		} else {

			resultVal = -1;
		}

		return resultVal;
	}

}
