package pages;

public class PaginaPrincipal extends BasePage {

    // Constructor
    public PaginaPrincipal() {
        super();
    }

    // Método para navegar a la página principal de OrangeHRM
    public void navigateToHomePage(String url) {
        navigateTo(url);
    }
    
}
