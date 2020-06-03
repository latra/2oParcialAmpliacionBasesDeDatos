package utils;

import java.util.HashMap;

public class Texts {
    private HashMap<String, String> texts = new HashMap<>();
    public Texts() {
        texts.put("UndefinedSender","No sender has been declared");
        texts.put("UndefinedSubject","No email subject has been declared");
        texts.put("UndefinedBody","No email body has been declared");
        texts.put("UndefinedDestination","No destination address has been declared. At least one is required");
        texts.put("FormatErrorSource","You has been introduced a wrong-format source email");
        texts.put("FormatErrorDestination","You has been introduced a wrong-format destination email");
        texts.put("ErrorEmptySubject","Email subject can not be empty");
        texts.put("ErrorTooLongSubject","The maximum subject size is limited to 998 characters.");
        texts.put("ErrorEmptyBody","Email body can not be empty");
        texts.put("AlreadyDefinedSender", "Sender has already defined");
        texts.put("AlreadyDefinedSubject", "Subject has been already defined");
        texts.put("AlreadyDefinedBody", "Body has been already defined");


    }
    public String getText(String key) {
        return this.texts.getOrDefault(key, "Undefined message");
    }
}
