package robot

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static java.awt.event.KeyEvent.*;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Action
import org.openqa.selenium.interactions.Actions
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory;
import com.kms.katalon.core.webui.common.WebUiCommonHelper;
import com.kms.katalon.core.testobject.TestObjectProperty


public class Keywords {

	private Robot robot;

	public Keywords() throws AWTException {
		this.robot = new Robot();
	}

	public Keywords(Robot robot) {
		this.robot = robot;
	}

	@Keyword
	public void typeString(CharSequence characters) {
		int length = characters.length();
		for (int i = 0; i < length; i++) {
			char character = characters.charAt(i);
			type(character);
		}
	}

	//mouseClickType : "Left Button Down/Up", "Right Button Down/Up", "Left Click", "Right Click", "Double Click"
	@Keyword
	public void mouseClick(String mouseClickType) {
		switch (mouseClickType) {
			case "Left Button Down" : robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);break;
			case "Left Button Up" : robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);break;
			case "Double Click" : robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			case "Left Click" : robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);break;
			case "Right Button Down" : robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);break;
			case "Right Button Up" : robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);break;
			case "Right Click" : robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);break;
			default : robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		}
	}

	@Keyword
	public void mouseMove(int x, int y) {
		robot.mouseMove(x, y)
	}

	@Keyword
	public void mouseWheelRoll(String mouseRollType) {
		robot.mouseWheel(InputEvent.MOUSE_WHEEL_EVENT_MASK)
	}

	public void type(char character) {
		switch (character) {
			case 'a': doType(VK_A); break;
			case 'b': doType(VK_B); break;
			case 'c': doType(VK_C); break;
			case 'd': doType(VK_D); break;
			case 'e': doType(VK_E); break;
			case 'f': doType(VK_F); break;
			case 'g': doType(VK_G); break;
			case 'h': doType(VK_H); break;
			case 'i': doType(VK_I); break;
			case 'j': doType(VK_J); break;
			case 'k': doType(VK_K); break;
			case 'l': doType(VK_L); break;
			case 'm': doType(VK_M); break;
			case 'n': doType(VK_N); break;
			case 'o': doType(VK_O); break;
			case 'p': doType(VK_P); break;
			case 'q': doType(VK_Q); break;
			case 'r': doType(VK_R); break;
			case 's': doType(VK_S); break;
			case 't': doType(VK_T); break;
			case 'u': doType(VK_U); break;
			case 'v': doType(VK_V); break;
			case 'w': doType(VK_W); break;
			case 'x': doType(VK_X); break;
			case 'y': doType(VK_Y); break;
			case 'z': doType(VK_Z); break;
			case 'A': doType(VK_SHIFT, VK_A); break;
			case 'B': doType(VK_SHIFT, VK_B); break;
			case 'C': doType(VK_SHIFT, VK_C); break;
			case 'D': doType(VK_SHIFT, VK_D); break;
			case 'E': doType(VK_SHIFT, VK_E); break;
			case 'F': doType(VK_SHIFT, VK_F); break;
			case 'G': doType(VK_SHIFT, VK_G); break;
			case 'H': doType(VK_SHIFT, VK_H); break;
			case 'I': doType(VK_SHIFT, VK_I); break;
			case 'J': doType(VK_SHIFT, VK_J); break;
			case 'K': doType(VK_SHIFT, VK_K); break;
			case 'L': doType(VK_SHIFT, VK_L); break;
			case 'M': doType(VK_SHIFT, VK_M); break;
			case 'N': doType(VK_SHIFT, VK_N); break;
			case 'O': doType(VK_SHIFT, VK_O); break;
			case 'P': doType(VK_SHIFT, VK_P); break;
			case 'Q': doType(VK_SHIFT, VK_Q); break;
			case 'R': doType(VK_SHIFT, VK_R); break;
			case 'S': doType(VK_SHIFT, VK_S); break;
			case 'T': doType(VK_SHIFT, VK_T); break;
			case 'U': doType(VK_SHIFT, VK_U); break;
			case 'V': doType(VK_SHIFT, VK_V); break;
			case 'W': doType(VK_SHIFT, VK_W); break;
			case 'X': doType(VK_SHIFT, VK_X); break;
			case 'Y': doType(VK_SHIFT, VK_Y); break;
			case 'Z': doType(VK_SHIFT, VK_Z); break;
			case '`': doType(VK_BACK_QUOTE); break;
			case '0': doType(VK_0); break;
			case '1': doType(VK_1); break;
			case '2': doType(VK_2); break;
			case '3': doType(VK_3); break;
			case '4': doType(VK_4); break;
			case '5': doType(VK_5); break;
			case '6': doType(VK_6); break;
			case '7': doType(VK_7); break;
			case '8': doType(VK_8); break;
			case '9': doType(VK_9); break;
			case '-': doType(VK_MINUS); break;
			case '=': doType(VK_EQUALS); break;
			case '~': doType(VK_SHIFT, VK_BACK_QUOTE); break;
			case '!': doType(VK_EXCLAMATION_MARK); break;
			case '@': doType(VK_AT); break;
			case '#': doType(VK_NUMBER_SIGN); break;
			case '$': doType(VK_DOLLAR); break;
			case '%': doType(VK_SHIFT, VK_5); break;
			case '^': doType(VK_CIRCUMFLEX); break;
			case '&': doType(VK_AMPERSAND); break;
			case '*': doType(VK_ASTERISK); break;
			case '(': doType(VK_LEFT_PARENTHESIS); break;
			case ')': doType(VK_RIGHT_PARENTHESIS); break;
			case '_': doType(VK_UNDERSCORE); break;
			case '+': doType(VK_PLUS); break;
			case '\t': doType(VK_TAB); break;
			case '\n': doType(VK_ENTER); break;
			case '[': doType(VK_OPEN_BRACKET); break;
			case ']': doType(VK_CLOSE_BRACKET); break;
			case '\\': doType(VK_BACK_SLASH); break;
			case '{': doType(VK_SHIFT, VK_OPEN_BRACKET); break;
			case '}': doType(VK_SHIFT, VK_CLOSE_BRACKET); break;
			case '|': doType(VK_SHIFT, VK_BACK_SLASH); break;
			case ';': doType(VK_SEMICOLON); break;
			case ':': doType(VK_COLON); break;
			case '\'': doType(VK_QUOTE); break;
			case '"': doType(VK_QUOTEDBL); break;
			case ',': doType(VK_COMMA); break;
			case '<': doType(VK_SHIFT, VK_COMMA); break;
			case '.': doType(VK_PERIOD); break;
			case '>': doType(VK_SHIFT, VK_PERIOD); break;
			case '/': doType(VK_SLASH); break;
			case '?': doType(VK_SHIFT, VK_SLASH); break;
			case ' ': doType(VK_SPACE); break;
			default:
				throw new IllegalArgumentException("Cannot type character " + character);
		}
	}

	@Keyword
	public void pressSpecialKey(String key) {
		switch (key) {
			case 'TAB': doType(VK_TAB); break;
			case 'ENTER': doType(VK_ENTER); break;
			case 'BACK SLASH': doType(VK_BACK_SLASH); break;
			case 'SHIFT': doType(VK_SHIFT); break;
			case 'Single QUOTE': doType(VK_QUOTE); break;
			default:
				throw new IllegalArgumentException("Cannot type character " + key);
		}
	}


	private void doType(int... keyCodes) {
		doType(keyCodes, 0, keyCodes.length);
	}

	private void doType(int[] keyCodes, int offset, int length) {
		if (length == 0) {
			return;
		}

		robot.keyPress(keyCodes[offset]);
		doType(keyCodes, offset + 1, length - 1);
		robot.keyRelease(keyCodes[offset]);
	}

	@Keyword
	public void dragAndDropToElement(List<TestObject> tObj) {
		WebDriver wd = DriverFactory.getWebDriver();
		wd.manage().window().fullscreen();
		WebElement fromElement = WebUiCommonHelper.findWebElement(tObj[0], 30);
		WebElement toElement = WebUiCommonHelper.findWebElement(tObj[1], 30);
		Point pnt = toElement.getLocation();
		robot.mouseMove(pnt.getX()+50, pnt.getY()+50);
		Actions builder = new Actions(wd);
		Action dragAndDrop = builder.clickAndHold(fromElement)
				.moveToElement(toElement)
				.release(toElement)
				.build();
		dragAndDrop.perform();
		mouseAction("");
	}

	@Keyword
	public void dragAndDropToElementWait(List<TestObject> tObj) {
		WebDriver wd = DriverFactory.getWebDriver();
		WebElement fromElement = WebUiCommonHelper.findWebElement(tObj[0], 30);
		WebElement toElement = WebUiCommonHelper.findWebElement(tObj[1], 30);
		Actions builder = new Actions(wd);
		Action dragAndDrop = builder
				.moveToElement(fromElement)
				.pause(Duration.ofSeconds(1))
				.clickAndHold(fromElement)
				.pause(Duration.ofSeconds(3))
				.moveByOffset(10, 10)
				.moveToElement(toElement)
				.moveByOffset(10, 10)
				.pause(Duration.ofSeconds(3))
				.release(toElement)
				.build();
		dragAndDrop.perform();
	}

	@Keyword
	public void dragAndDrop(List<TestObject> tObj) {


		String jsScript = '''(function( $ ) {
        $.fn.simulateDragDrop = function(options) {
                return this.each(function() {
                        new $.simulateDragDrop(this, options);
                });
        };
        $.simulateDragDrop = function(elem, options) {
                this.options = options;
                this.simulateEvent(elem, options);
        };
        $.extend($.simulateDragDrop.prototype, {
                simulateEvent: function(elem, options) {
                        /*Simulating drag start*/
                        var type = 'dragstart';
                        var event = this.createEvent(type);
                        this.dispatchEvent(elem, type, event);

                        /*Simulating drop*/
                        type = 'drop';
                        var dropEvent = this.createEvent(type, {});
                        dropEvent.dataTransfer = event.dataTransfer;
                        this.dispatchEvent($(options.dropTarget)[0], type, dropEvent);

                        /*Simulating drag end*/
                        type = 'dragend';
                        var dragEndEvent = this.createEvent(type, {});
                        dragEndEvent.dataTransfer = event.dataTransfer;
                        this.dispatchEvent(elem, type, dragEndEvent);
                },
                createEvent: function(type) {
                        var event = document.createEvent("CustomEvent");
                        event.initCustomEvent(type, true, true, null);
                        event.dataTransfer = {
                                data: {
                                },
                                setData: function(type, val){
                                        this.data[type] = val;
                                },
                                getData: function(type){
                                        return this.data[type];
                                }
                        };
                        return event;
                },
                dispatchEvent: function(elem, type, event) {
                        if(elem.dispatchEvent) {
                                elem.dispatchEvent(event);
                        }else if( elem.fireEvent ) {
                                elem.fireEvent("on"+type, event);
                        }
                }
        	});
		})(jQuery);
					
		''';

		WebDriver wd = DriverFactory.getWebDriver();
		WebElement fromElement = WebUiCommonHelper.findWebElement(tObj[0], 30);

		WebElement toElement = WebUiCommonHelper.findWebElement(tObj[1], 30);
		((JavascriptExecutor) wd).executeScript(jsScript+"simulateDragDrop(arguments[0], arguments[1]);", fromElement, toElement);
	}

	private String getLocator(TestObject tobj) {
		TestObjectProperty[] properties = tobj.getActiveProperties();
		String defaultLocator = "";
		for (TestObjectProperty property : properties) {
			if (property.isDefault()) {
				defaultLocator = property.getValue();
				break;
			}
		}
		return defaultLocator;
	}
}
