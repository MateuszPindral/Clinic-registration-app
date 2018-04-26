package pl.sda.clinic.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailExistsException extends Throwable {

    private String errorMsg;

    @Override
    public String toString() {
        return errorMsg;
    }
}