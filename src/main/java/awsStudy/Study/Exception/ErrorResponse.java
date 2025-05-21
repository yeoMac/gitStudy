package awsStudy.Study.Exception;

import lombok.Getter;

import java.util.List;

@Getter
public class ErrorResponse {
    private String code;
    private Object message;

    public ErrorResponse(String code, String message) {

        this.code = code;
        this.message = message;
    }
    public ErrorResponse(String code, List<String> messages) {

        this.code = code;
        this.message = messages;
    }


}
