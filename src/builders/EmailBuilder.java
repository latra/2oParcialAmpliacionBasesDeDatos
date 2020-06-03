package builders;

import models.Email;
import exceptions.EmailBuilderException;

import java.util.ArrayList;
import java.util.List;

public abstract class EmailBuilder {
    protected String from;
    protected List<String> to = new ArrayList<>();
    protected String subject;
    protected String body;
    protected List<String> ccTo = new ArrayList<>();

    public abstract Email make() throws EmailBuilderException;
    public abstract EmailBuilder from(String fromEmail) throws EmailBuilderException;
    public abstract EmailBuilder to(String fromEmail) throws EmailBuilderException;
    public abstract EmailBuilder subject(String fromEmail) throws EmailBuilderException;
    public abstract EmailBuilder body(String fromEmail) throws EmailBuilderException;
    public abstract EmailBuilder ccTo(String fromEmail) throws EmailBuilderException;
}
