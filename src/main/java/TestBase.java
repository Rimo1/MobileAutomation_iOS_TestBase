//import com.tests.qa.testbase.extensions.ConfigSupportedElementLocatorFactory;
//import org.openqa.selenium.support.PageFactory;


import extensions.ConfigSupportedElementLocatorFactory;
import org.openqa.selenium.support.PageFactory;

public class TestBase {

  public TestBase()
   {
       PageFactory.initElements(new ConfigSupportedElementLocatorFactory(), this);
   }


}
