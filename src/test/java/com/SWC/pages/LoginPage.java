package com.SWC.pages;

import com.SWC.utilities.BaseFunctions;

public class LoginPage {
	
	//login
			String usernameTextBox="//*[@id='user_email']";
			String passwordTextBox="//*[@id='frmLogin']/div/div[2]/input";
			String loginButton="//*[@id='frmLogin']/div/div[3]/input";
			String forgetPasswordLabel="//*[@id='frmLogin']/div/div[2]/div[2]/span/a";
			
	//homePage validate
			String homePageExpectedResult="Last logged in";
			String lastLoginLabel="//*[@id='sticky']/div[1]/div[2]/h5";
			
	//register
			String signupEmailTextBox="//*[@id='user_emails']";
			String signupPasswordTextBox="//*[@id='user_passwords']";
			String signupConfirmPasswordTextBox="//*[@id='user_confirm_password']";
			String agreeBox="//*[@id='terms_conditions']";
			String signUpButton="//*[@id='frmUserRegister']/input";
			
	//register validate
			String afterRegistrationNameLabel = "//*[@id='sticky']/div[1]/div[2]/h3/a";
			
	//login footer link
			String landingPageFooterLink = "html/body/div[1]/div[4]/footer/div/div/div[1]/ul";
			
			BaseFunctions seleniumFunc = new BaseFunctions();
		
		public void textField(String input){
			if(input.contains("Username")){
			String userName = seleniumFunc.readConfig("username"); 
			seleniumFunc.enterData(usernameTextBox, userName);
			}else{
				if(input.equals("Password")){
					String password = seleniumFunc.readConfig("password");
					seleniumFunc.enterData(passwordTextBox, password);
				}else{
					if(input.contains("Email")){
						String email = seleniumFunc.readConfig("email");
						seleniumFunc.enterData(signupEmailTextBox, email);
					}else{
						if(input.equals("Reg. Password")){
							String regPassword = seleniumFunc.readConfig("regPassword");
							seleniumFunc.enterData(signupPasswordTextBox, regPassword);
						}else{
							if(input.equals("Confirm Password")){
								String confirmPassword = seleniumFunc.readConfig("regPassword");
								seleniumFunc.enterData(signupConfirmPasswordTextBox, confirmPassword);
							}
						}
					}
				}
			}
		}
		
		public void clickElement(String input){
			if(input.contains("Login button")){
				seleniumFunc.click(loginButton);
			}else{
				if(input.contains("I agree box")){
					seleniumFunc.click(agreeBox);
				}else{
					if(input.contains("Submit button")){
						seleniumFunc.click(signUpButton);
					}
				}
			}
		}
		
		public boolean validateText(String input){
			boolean rtype = false;
			if(input.contains("Logout")){
				if(seleniumFunc.validate(lastLoginLabel, homePageExpectedResult)){
					rtype = true;
				}
			}else{
				if(input.contains("Name Label")){
					String [] email = (seleniumFunc.readConfig("email")).split("@");
					if(seleniumFunc.validate(afterRegistrationNameLabel, email[0])){
						rtype = true;
					}
				}
			}
			
			return rtype;
		}
}
