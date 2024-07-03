package SharedData.browser;

import java.util.Map;

public interface BrowserService {
    //aceasta interfata are ca rol sa defineasca actiunile pe care le putem face cu un browser
    void openBrowser (Map<String, String> testData);

    Object getBrowserOptions (Map<String,String> testData);
}
