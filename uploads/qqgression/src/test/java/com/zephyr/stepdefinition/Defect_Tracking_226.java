package com.zephyr.stepdefinition;
import org.testng.asserts.SoftAssert;
import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_226 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	CreateTestCasePage ctc;
	DefectTracking dt;
	RequirementsPage req;
	boolean[] actual=new boolean[68];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_226";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Release_1");
	
	@Given("^DEFECTTRACKING Page is Launched BY User$")
	public void defecttracking_Page_is_Launched_BY_User() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ep=new ExecutionPage(driver);
			req=new RequirementsPage(driver);
			dt=new DefectTracking(driver);
			actual[0]=pp.selectProject(project);
			actual[1]=pp.selectRelease(release);
			actual[2]=pp.clickOnDefectTracking();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }  
	}

	@When("^user Searches defects by component Contains long name$")
	public void user_Searches_defects_by_component_Contains_long_name() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 58, 5);
			bp.waitForElement();
		    actual[3]=dt.advancedSearch(jql, value);
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }  
	}

	@Then("^Should able to search defects by Component contains long name$")
	public void should_able_to_search_defects_by_Component_contains_long_name() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[4]=req.verifySearchRequirementCount();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	}

	@When("^User Searches defects by component contain Long name in TestExecution Page$")
	public void user_Searches_defects_by_component_contain_Long_name_in_TestExecution_Page() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 58, 5);
			bp.waitForElement();
			actual[5]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[6]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[7]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[8]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[9]=ep.clickOnDefectButton(testcase1);
		    actual[10]=ep.defectSearch(jql, value);
		}
		catch(Exception e)
		{
			 lb=new LaunchBrowser();
             lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
		}             
	}

	@Then("^In Test Execution Page,Defects should search by Component$")
	public void in_Test_Execution_Page_Defects_should_search_by_Component() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[11]=ep.verifySearchedDefectCount();
			bp.waitForElement();
			actual[12]=ep.clickOnCancelDefectWindow();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    } 
	}

	@When("^user Searches defects by component contains number In Defect Tracking$")
	public void user_Searches_defects_by_component_contains_number_In_Defect_Tracking() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 59, 5);
			actual[13]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[14]=dt.advancedSearch(jql, value);
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    } 
	}

	@Then("^Should able to search defects by Component contains number$")
	public void should_able_to_search_defects_by_Component_contains_number() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[15]=req.verifySearchRequirementCount();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	}

	@When("^User Searches defects by component contain number in TestExecution Page$")
	public void user_Searches_defects_by_component_contain_number_in_TestExecution_Page() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 59, 5);
			actual[16]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[17]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[18]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[19]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[20]=ep.clickOnDefectButton(testcase1);
		    actual[21]=ep.defectSearch(jql, value);
		}
		catch(Exception e)
		{
			 lb=new LaunchBrowser();
             lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
		}               
	}

	@Then("^In Test Execution Page,Defects should search by component contains number$")
	public void in_Test_Execution_Page_Defects_should_search_by_component_contains_number() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[22]=ep.verifySearchedDefectCount();
			bp.waitForElement();
			actual[23]=ep.clickOnCancelDefectWindow();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }    
	}

	@When("^user Searches defects by component contain special chars In defectTracking page$")
	public void user_Searches_defects_by_component_contain_special_chars_In_defectTracking_page() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 61, 5);
			actual[24]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[25]=dt.advancedSearch(jql, value);
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    } 
	}

	@Then("^Should able to search defects by Component contains special chars$")
	public void should_able_to_search_defects_by_Component_contains_special_chars() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[26]=req.verifySearchRequirementCount();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	}

	@When("^User Searches defects by component contain special chars in TestExecution Page$")
	public void user_Searches_defects_by_component_contain_special_chars_in_TestExecution_Page() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 61, 5);
			bp.waitForElement();
			actual[27]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[28]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[29]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[30]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[31]=ep.clickOnDefectButton(testcase1);
		    actual[32]=ep.defectSearch(jql, value);
		}
		catch(Exception e)
		{
			 lb=new LaunchBrowser();
             lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
		}              
	}

	@Then("^In Test Execution Page,Defects should search by component consists special chars$")
	public void in_Test_Execution_Page_Defects_should_search_by_component_consists_special_chars() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[33]=ep.verifySearchedDefectCount();
			bp.waitForElement();
			actual[34]=ep.clickOnCancelDefectWindow();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    } 
	}

	@When("^user Searches defects by component contain  white spaces in defect tracking$")
	public void user_Searches_defects_by_component_contain_white_spaces_in_defect_tracking() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 62, 5);
			actual[35]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[36]=dt.advancedSearch(jql, value);
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    } 
	}

	@Then("^Should able to search defects by Component contains  white spaces$")
	public void should_able_to_search_defects_by_Component_contains_white_spaces() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[37]=req.verifySearchRequirementCount();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	}

	@When("^User Searches defects by component contain  white spaces in TestExecution Page$")
	public void user_Searches_defects_by_component_contain_white_spaces_in_TestExecution_Page() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 62, 5);
			bp.waitForElement();
			actual[38]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[39]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[40]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[41]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[42]=ep.clickOnDefectButton(testcase1);
		    actual[43]=ep.defectSearch(jql, value);
		}
		catch(Exception e)
		{
			 lb=new LaunchBrowser();
             lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
		}              
	}

	@Then("^In Test Execution Page,Defects should search by component contains  white spaces$")
	public void in_Test_Execution_Page_Defects_should_search_by_component_contains_white_spaces() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[44]=ep.verifySearchedDefectCount();
			bp.waitForElement();
			actual[45]=ep.clickOnCancelDefectWindow();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }  
	}

	@When("^In Defect Tracking page,user Searches defects by component contain alpha numeric chars$")
	public void in_Defect_Tracking_page_user_Searches_defects_by_component_contain_alpha_numeric_chars() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 63, 5);
			actual[46]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[47]=dt.advancedSearch(jql, value);
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	}

	@Then("^Should able to search defects by Component contains alpha numeric chars$")
	public void should_able_to_search_defects_by_Component_contains_alpha_numeric_chars() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[48]=req.verifySearchRequirementCount();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	}

	@When("^User Searches defects by component contain alpha numeric chars in TestExecution Page$")
	public void user_Searches_defects_by_component_contain_alpha_numeric_chars_in_TestExecution_Page() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 63, 5);
			bp.waitForElement();
			actual[49]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[50]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[51]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[52]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[53]=ep.clickOnDefectButton(testcase1);
		    actual[54]=ep.defectSearch(jql, value);
		}
		catch(Exception e)
		{
			 lb=new LaunchBrowser();
             lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
		}               
	}

	@Then("^In Test Execution Page,Defects should search by component consists Alpha numeric chars$")
	public void in_Test_Execution_Page_Defects_should_search_by_component_consists_Alpha_numeric_chars() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[55]=ep.verifySearchedDefectCount();
			bp.waitForElement();
			actual[56]=ep.clickOnCancelDefectWindow();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    } 
	}

	@When("^user Searches defects by component contain international chars in Defect Tracking Page$")
	public void user_Searches_defects_by_component_contain_international_chars_in_Defect_Tracking_Page() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 64, 5);
			actual[57]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[58]=dt.advancedSearch(jql, value);
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    } 
	}

	@Then("^should able to search defects by Component contains International chars$")
	public void should_able_to_search_defects_by_Component_contains_International_chars() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[59]=req.verifySearchRequirementCount();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	}

	@When("^User Searches defects by component contain international chars in TestExecution Page$")
	public void user_Searches_defects_by_component_contain_international_chars_in_TestExecution_Page() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 64, 5);
			bp.waitForElement();
			actual[60]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[61]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[62]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[63]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[64]=ep.clickOnDefectButton(testcase1);
		    actual[65]=ep.defectSearch(jql, value);
		}
		catch(Exception e)
		{
			 lb=new LaunchBrowser();
             lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
		}              
	}

	@Then("^In Test Execution Page,Defects should search by Component Consists International chars$")
	public void in_Test_Execution_Page_Defects_should_search_by_Component_Consists_International_chars() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[66]=req.verifySearchRequirementCount();
		bp.waitForElement();
		actual[67]=ep.clickOnCancelDefectWindow();
		for(int k=0;k<=actual.length-1;k++)
		{
			soft.assertEquals(actual[k], true);
		}
		soft.assertAll();
		}		
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	}



}
