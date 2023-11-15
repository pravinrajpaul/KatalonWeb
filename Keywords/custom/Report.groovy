package custom

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.util.Map.Entry

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

import com.katalon.org.apache.commons.io.FileUtils
import com.katalon.org.apache.commons.io.IOCase
import com.katalon.org.apache.commons.io.filefilter.DirectoryFileFilter
import com.katalon.org.apache.commons.io.filefilter.FileFilterUtils
import com.katalon.org.apache.commons.io.filefilter.NotFileFilter
import com.katalon.org.apache.commons.io.filefilter.TrueFileFilter
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Report {

	@Keyword
	def collectionConsolidatedReport(Boolean includeSteps) {

		File repDir = new File("Reports")
		def repFolders = FileUtils.listFilesAndDirs(repDir, TrueFileFilter.INSTANCE, null)
		Map<String, Long> folderTimeUnSorted = new HashMap<>()
		for (File repFolder : repFolders) {
			if(repFolder.getName().equals("Self-healing")||repFolder.getName().equals("Reports")) repFolders.remove(repFolder)
			else folderTimeUnSorted.put(repFolder.getName(), FileUtils.lastModified(repFolder))
		}
		List<Integer> unSortedTimeList = new ArrayList<>()
		for (Entry<String, Integer> entry : folderTimeUnSorted.entrySet()) unSortedTimeList.add(entry.getValue())
		Collections.sort(unSortedTimeList)
		unSortedTimeList = unSortedTimeList.reverse()
		long latestFolderTime = unSortedTimeList[0]
		String latestFolder = ""
		for (Entry<String, Integer> entry : folderTimeUnSorted.entrySet()) {
			if (entry.getValue() == latestFolderTime) {
				latestFolder = entry.getKey()
				break
			}
		}
		File latestRepDir = new File("Reports/"+latestFolder)
		def repFiles = FileUtils.listFilesAndDirs(latestRepDir, FileFilterUtils.suffixFileFilter(".html", IOCase.INSENSITIVE), DirectoryFileFilter.INSTANCE)
		def collectionReportPath = ""
		for (File repFile : repFiles) {
			Document document = null
			def repFileName = repFile.getName()
			println repFileName
			if (repFile.getName().startsWith("HTML_Report")) {
				collectionReportPath = repFile.getAbsolutePath()
			}
			else if (repFileName.length()>20) {
				println ">20"
				document = Jsoup.parse(repFile, "UTF-8")
				Elements heads
				Element envHead
				Element exeLog
				Elements envParams
				heads = document.select("html>body")
				println heads
				//				envHead = heads.get(0)
				//				exeLog = heads[1]
				//				envParams = envHead.selectXpath("//following-sibling::table/tbody/tr")
				//				for (Element envParam : envParams) {
				//					Elements envParamsDummy = envHead.selectXpath("//following-sibling::table/tbody/tr/td[2] | //h2/following-sibling::table/tbody/tr/td[4]")
				//					Elements envParamHead1 = envHead.selectXpath("//following-sibling::table/tbody/tr/td[1]")
				//					envParamHead1.tagName("th")
				//					envParamsDummy.remove()
				//				}
				//				println latestRepDir.getAbsolutePath()
				//				File rep = new File(latestRepDir.getAbsolutePath()+"\\rep.html")
				//				FileUtils.writeStringToFile(rep, document.outerHtml(), StandardCharsets.UTF_8)
				//				break
			}
		}
	}
}