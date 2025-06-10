package pages;

public class BoxLateral extends BasePage {
    private final String selectPIM = "//span[normalize-space()='PIM']";
    
    public void clickPIM() {
        // Hacer clic en el elemento PIM en la barra lateral
        find(selectPIM).click();
    }

    
}
