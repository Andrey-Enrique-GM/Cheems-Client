
package mx.itson.cheems.entities;

// @author Andrey

public class Novel 
{

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    
    
    public Novel(int id, String title, String description, String editorial) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.editorial = editorial;
    }

    
    
    public Novel() {
    }
    
    
    
    private int id;
    private String title;
    private String description;
    private String editorial;
    
}
