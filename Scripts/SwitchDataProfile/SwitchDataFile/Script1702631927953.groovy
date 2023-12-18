import java.nio.file.Paths

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testdata.ExcelData
import com.kms.katalon.core.testdata.reader.ExcelFactory

import internal.GlobalVariable as GlobalVariable

def dataFileName = "TestData/MasterData-" + GlobalVariable.Environment + ".xlsx"
def dataFilePath = Paths.get(RunConfiguration.getProjectDir(), dataFileName).toString()
ExcelData ed = ExcelFactory.getExcelDataWithDefaultSheet(dataFilePath, "ContactDetails", true);


List<List<Object>> data = ed.getAllData()

println data.get(0).get(0)