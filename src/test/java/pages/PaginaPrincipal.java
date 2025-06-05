package pages;

import org.openqa.selenium.WebElement;

public class PaginaPrincipal extends BasePage {
    private final String inputNameContactForm = "//input[@placeholder='Username']";
    private final String inputPasswordContactForm = "//input[@placeholder='Password']";
    private final String buttonLogin = "//button[@type='submit']";
    // Constructor
    public PaginaPrincipal() {
        super();
    }

    // Método para navegar a la página principal de OrangeHRM
    public void navigateToHomePage(String url) {
        navigateTo(url);
    }

    public void completeLogin() {
        // Completar el campo de nombre de usuario
        WebElement inputName = find(inputNameContactForm);
        inputName.sendKeys("Admin");

        // Completar el campo de contraseña
        WebElement inputPassword = find(inputPasswordContactForm);
        inputPassword.sendKeys("admin123");

        // Hacer clic en el botón de inicio de sesión
        WebElement loginButton = find(buttonLogin);
        loginButton.click();
    }
    
}
