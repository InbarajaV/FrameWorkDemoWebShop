package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
public Loginpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(id = "Email")
private WebElement emailtxtfield;

@FindBy(id = "Password")
private WebElement passwordtxtfield;

@FindBy(css = "[value='Log in']")
private WebElement loginbutton;

public WebElement getEmailtxtfield() {
	return emailtxtfield;
}

public WebElement getPasswordtxtfield() {
	return passwordtxtfield;
}

public WebElement getLoginbutton() {
	return loginbutton;
}
}
