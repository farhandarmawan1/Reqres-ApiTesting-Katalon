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

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementText(response, 'data.id', '2')

String jsonPass = '\n{\n  "$schema": "http://json-schema.org/draft-04/schema#",\n  "type": "object",\n  "properties": {\n    "data": {\n      "type": "object",\n      "properties": {\n        "id": {\n          "type": "integer"\n        },\n        "email": {\n          "type": "string"\n        },\n        "first_name": {\n          "type": "string"\n        },\n        "last_name": {\n          "type": "string"\n        },\n        "avatar": {\n          "type": "string"\n        }\n      },\n      "required": [\n        "id",\n        "email",\n        "first_name",\n        "last_name",\n        "avatar"\n      ]\n    },\n    "support": {\n      "type": "object",\n      "properties": {\n        "url": {\n          "type": "string"\n        },\n        "text": {\n          "type": "string"\n        }\n      },\n      "required": [\n        "url",\n        "text"\n      ]\n    }\n  },\n  "required": [\n    "data",\n    "support"\n  ]\n}\n'

'Verify Json schema'
boolean successful = WS.validateJsonAgainstSchema(response, jsonPass)

