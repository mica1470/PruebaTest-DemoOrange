package steps;

import io.cucumber.java.en.*;

import pages.PaginaPrincipal;

public class OrangeSteps {
    PaginaPrincipal paginaPrincipal = new PaginaPrincipal();

    @Given("que estoy en la página de {string}")
    public void i_am_on_the_OrangeHRM_login_page(String url) {
        paginaPrincipal.navigateToHomePage(url);
        paginaPrincipal.completeLogin();
    }
}
