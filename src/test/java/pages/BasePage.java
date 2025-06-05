package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    // Inicializacion controlada del WebDriver
    public BasePage() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--disable-password-manager-reauthentication");
            options.addArguments("--disable-save-password-bubble");

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
            driver.manage().window().maximize(); // Opcional
            wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        }
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebElement find(String locator) {
     
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    // Metodo para encontrar un elemento en la pagina usando un localizador XPath
    public void clickElement(String locator) {
        WebElement element = find(locator);
        // Espera hasta que el elemento sea visible y clickeable
        element.click();
    }

    public void write(String locator, String text) {
        WebElement element = find(locator);
        // Limpia el campo de texto antes de escribir
        element.clear();
        // Escribe el texto en el campo de texto
        element.sendKeys(text);
    }

    public String getText(String locator) {
        WebElement element = find(locator);
        // Devuelve el texto del elemento
        return element.getText();
    }

    public String convertToXpath(String product) {
        // Convierte un texto a un formato de XPath
        return product.toLowerCase().replace(" ", "-");
    }
    
    // Metodo para seleccionar una opción de un dropdown
    public void selectFromDropdownByValue(String locator, String value) {
        Select dropdown = new Select(find(locator));
        // Espera hasta que el dropdown sea visible y selecciona la opción por su valor
        dropdown.selectByValue(value);
    }

    public void selectFromDropdownByIndex(String locator, int index) {
        Select dropdown = new Select(find(locator));
        // Espera hasta que el dropdown sea visible y selecciona la opción por su indice
        dropdown.selectByIndex(index);
    }
    
    
    public List<String> getDropdownOptions(String locator) {
        Select dropdown = new Select(find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> optionsText = new ArrayList<>();
        for (WebElement option : dropdownOptions) {
            optionsText.add(option.getText());
        }
        return optionsText;
    }


}