package models;

/**
 * Created by w6c on 17/08/2014.
 */
public class FieldErrorDTO {

    public final String field;

    public final String message;

    public FieldErrorDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
