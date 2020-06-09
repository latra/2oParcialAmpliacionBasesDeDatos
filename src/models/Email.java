package models;

import builders.EmailBuilder;
import builders.NewEmailBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase del objeto Email
 */
public final class Email {
    private final String from;
    private final List<String> to;
    private final String subject;
    private final String body;
    private final List<String> ccTo;
    public Email(String from, List<String> to, String subject, String body) {
        this(from, to, subject, body, new ArrayList<>());
    }
    public Email(String from, List<String> to, String subject, String body, List<String> ccTo   ) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.ccTo = ccTo;
    }

    public static EmailBuilder builder() {
        return new NewEmailBuilder();
    }
}
