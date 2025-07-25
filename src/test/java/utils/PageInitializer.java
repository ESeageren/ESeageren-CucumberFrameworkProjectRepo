//create and store static instances of page classes
package utils;

import pages.AddEmployeePage;
import pages.LoginPage;
import pages.SearchEmployeePage;

public class PageInitializer {

    public static LoginPage loginPage;
    public static AddEmployeePage addEmployeePage;
    public static SearchEmployeePage searchEmployeePage;


    public static void initializePageObjects(){
        loginPage = new LoginPage();
        addEmployeePage = new AddEmployeePage();
        searchEmployeePage = new SearchEmployeePage();
    }

}

