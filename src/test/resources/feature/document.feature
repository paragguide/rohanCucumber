Feature: Amazon Login and Shopping
  I want to use this senario to test amazon login and shopping
  @amazon
  Scenario: Validate userid 
    Given I open browser "chrome" with url "https://www.amazon.in" and reportname "AmazonLogin" testname "Login"
    And click signin button
    When I enter valid userid "paragguide@yahoo.co.in" 
    And click continue button
    Then error message should not come
  @amazon  
  Scenario: Validate password 
    Given userid is valid
    When i enter valid password "RMinfotech12#&&"
    And click submit
    Then i should login
    
   @amazon 
   Scenario Outline: Search Products 
    Given you are logged in
    When you search for product <products> in rage <price>
    Then results must come
   
   @data1 
   Examples: 
   | products | price |
   | Shirt | 850 |
   | pant | 1500 |
   | coat | 3000 |
   
   @data2
   Examples: 
   | products | price |
   | LCD | 8500 |
   | Mobile | 7500 |
   | Laptop | 36000 |
   
   @forget
   Scenario: Forget password
    Given i open website "https://www.amazon.in" on browser "chrome" with reportname "Forgetreport" and testname "Forget"
    And i click on sigin link on home page
    When i click help link and forget link
    And enter mobile number 
    Then send OTP
    
    @close
    Scenario: close browser
    When close browser end test
  