package pages;

public class BoxLateral extends BasePage {
    private final String selectBarra = "//span[normalize-space()='%s']";
    
    public void clickPIM() {
        // Reemplaza el marcador de posición en sectionLink con el nombre
        String xpathBarra = String.format(selectBarra, "PIM");
        // Llama al método clickElement para hacer clic en el enlace de la sección
        clickElement(xpathBarra);
    }

    
}
