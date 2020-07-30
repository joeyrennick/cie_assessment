package cie.assessment.pages;

import cie.assessment.base.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage  extends WebPage {

    @FindBy(id = "some-element-id")
    private WebElement someElement;

    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getSomeElement(){
        return this.someElement;
    }
}
