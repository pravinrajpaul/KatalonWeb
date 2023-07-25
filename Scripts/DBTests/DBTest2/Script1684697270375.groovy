import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.katalon.plugin.keyword.connection.DBType as DBType
import java.sql.Connection as Connection
import java.sql.ResultSet as ResultSet
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Connection connection = null

connection = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection'(DBType.postgresql, 
    '192.168.1.133', '5432', 'rental', 'rentaladmin', 'cmVudGFsYWRtaW4=')

actorDataS = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 'select * from rentalsch.address order by address_id asc;')

actorDataT = CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery'(connection, 'select * from rentalsch.address order by address_id asc;')

actorDataSRowCount = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getRowCount'(actorDataS)

actorDataTRowCount = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getRowCount'(actorDataT)

actorDataSColumnCount = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getColumnCount'(actorDataS)

actorDataTColumnCount = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getColumnCount'(actorDataT)

fail = []

if ((actorDataSRowCount == actorDataTRowCount) && (actorDataSColumnCount == actorDataTColumnCount)) {
    for (int i = 1; i <= 5; i++) { //actorDataSRowCount
        for (int j = 1; j <= 5; j++) { //actorDataSColumnCount
            sValue = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorDataS, 
                i, j)

            tValue = CustomKeywords.'com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue'(actorDataT, 
                i, j)

            if (sValue != tValue) {
                fail.add((((((('Source value in cell ' + i) + ',') + j) + ':') + sValue) + '; mismatch target value :') + 
                    tValue)
            }
        }
    }
} else {
    fail.add('Source Target Row/column count mismatch')
}

if (fail.size() > 0) {
    KeywordUtil.markFailed(fail.toString())
} else if (fail.size() <= 0) {
    KeywordUtil.markPassed('Source and target data matched')
}

CustomKeywords.'com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection'(connection)

