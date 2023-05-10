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

response = WS.sendRequest(findTestObject('GET/GET single user'))

value = WS.getElementPropertyValue(response, 'data.email')

println('value is :' + value)

GlobalVariable.email = value

response1 = WS.sendRequest(findTestObject('POST/POST register successful'))

WS.verifyResponseStatusCode(response1, 200)

WS.verifyElementText(response1, 'id', '2')

String jsonPass = '\n {\n  "$schema": "http://json-schema.org/draft-04/schema#",\n  "type": "object",\n  "properties": {\n    "id": {\n      "type": "integer"\n    },\n    "token": {\n      "type": "string"\n    }\n  },\n  "required": [\n    "id",\n    "token"\n  ]\n}\n'

'Verify Json schema'
boolean successful = WS.validateJsonAgainstSchema(response1, jsonPass)

