
package mx.itson.cheems.entities;

// @author Andrey

public class Result 
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
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    
    
    public Result(int id, boolean success, String message) {
        this.id = id;
        this.success = success;
        this.message = message;
    }

    
    
    public Result() {
    }
    
    
    
    private int id;
    private boolean success;
    private String message;
    
}
