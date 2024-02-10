package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
public Homepage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(partialLinkText = "Log in")
private WebElement Loginlink;

@FindBy(className =   "ico-logout")
private WebElement logoutlink;

@FindBy(linkText = "COMPUTERS")
private WebElement computerLink;

@FindBy(partialLinkText = "ELECTRONICS")
private WebElement electronicsLink;

@FindBy(partialLinkText = "APPAREL")
private WebElement apparelshoesLink;



public WebElement getLoginlink() {
	return Loginlink;
}
public WebElement getLogoutlink() {
	return logoutlink;
}
}
