package com.selenium.demo4;

public class ReadExcelDemo1 {

	public static void main(String[] args) throws Exception {
		String excelReadPath = "data/mc-TestPlan.xlsx";
		String excelWritePath = "data/mc-TestPlan.xlsx";

		ReadWriteExcel g = new ReadWriteExcel();
		g.xlRead(excelReadPath, 0);

		for (int i = 0; i < g.xRows; i++) {
			for (int j = 0; j < g.xCols; j++) {
				System.out.println("\t" + g.xData[i][j]);
			}
			System.out.println("");
		}
		
//		g.xData[1][0] = "1";
//		g.xData[2][0] = "2";
		
		g.xlwrite(excelWritePath, g.xData);
		
		System.out.println("Done");
	}

}
