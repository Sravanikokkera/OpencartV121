package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException 
	{
		String path =".\\testData\\OpenCart_LoginData.xlsx"; // taking xl file from TestData folder
		ExcelUtility xlutil = new ExcelUtility(path);// creating an object for XLtility file to invoke
		
		int totalRows = xlutil.getRowCount("Sheet1");
		int totalCols =  xlutil.getCellCount("Sheet1", 1);
		
		String loginData[][] = new String[totalRows][totalCols]; // created for two dimensional array
		
		for(int i=1;i<=totalRows;i++)
		{
			for(int j=0;j<totalCols;j++)
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);  //1,0  two dimensional array should be in same excel utility dimensions
			}
		}
		
		return loginData;
		
	 }
	
}
