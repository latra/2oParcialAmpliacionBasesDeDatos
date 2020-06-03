package builders;

import builders.EmailBuilder;
import exceptions.EmailBuilderException;
import models.Email;
import utils.Check;
import utils.Texts;

public class NewEmailBuilder extends EmailBuilder {
    Texts texts = new Texts();

    @Override
    public Email make() throws EmailBuilderException {
        // Revisión de que los campos obligatorios hayan sido introducidos
        if (Check.isNullOrEmpty(this.from))
            throw new EmailBuilderException(texts.getText("UndefinedSender"));
        if (Check.isNullOrEmpty(this.subject))
            throw new EmailBuilderException(texts.getText("UndefinedSubject"));
        if (Check.isNullOrEmpty(this.body))
            throw new EmailBuilderException(texts.getText("UndefinedBody"));
        if (!Check.hasElements(this.to))
            throw new EmailBuilderException(texts.getText("UndefinedDestination"));
        // Construcción del Email en función de si se han declarados CC en copia o no.
        if (Check.hasElements(this.ccTo))
            return new Email(from, to, subject, body, ccTo);
        else
            return new Email(from, to, subject, body);
    }

    public NewEmailBuilder from(String fromEmail) throws EmailBuilderException {
        // Se revisa que from no haya sido definido anteriormente
        if (Check.isValidEmail(this.from))
            throw new EmailBuilderException(texts.getText("AlreadyDefinedSender"));
        // Se revisa que el email sea válido.
        if (Check.isValidEmail(fromEmail)) {
            // De serlo, se asigna.
            this.from = fromEmail;
        } else {
            throw new EmailBuilderException(texts.getText("FormatErrorSource"));
        }
        return this;
    }

    public NewEmailBuilder to(String toEmail) throws EmailBuilderException {
        // Se revisa que el email sea válido.
        if (Check.isValidEmail(toEmail)) {
            // De serlo, se añade a la lista de destinatarios, ya inicializada en el constructor
            this.to.add(toEmail);
        } else {
            throw new EmailBuilderException(texts.getText("FormatErrorDestination"));
        }
        return this;
    }

    public NewEmailBuilder subject(String subjectEmail) throws EmailBuilderException {
        // Se revisa que asunto no haya sido definido anteriormente
        if (!Check.isNullOrEmpty(this.subject))
            throw new EmailBuilderException(texts.getText("AlreadyDefinedSubject"));
        // Se revisa tanto que el subject no esté empty como que no supere los 998 (Máximo permitido en los subjects de email)
        if (!Check.isNullOrEmpty(subjectEmail) && subjectEmail.length() < 998) {
            this.subject = subjectEmail;
        } else if (Check.isNullOrEmpty(subjectEmail))
            throw new EmailBuilderException(texts.getText("ErrorEmptySubject"));
        else
            throw new EmailBuilderException(texts.getText("ErrorTooLongSubject"));
        return this;
    }

    public NewEmailBuilder body(String body) throws EmailBuilderException {
        // Se revisa que body no haya sido definido anteriormente
        if (!Check.isNullOrEmpty(this.body))
            throw new EmailBuilderException(texts.getText("AlreadyDefinedBody"));
        if (!Check.isNullOrEmpty(body)) {
            this.body = body;
        } else
            throw new EmailBuilderException(texts.getText("ErrorEmptyBody"));
        return this;
    }

    public NewEmailBuilder ccTo(String ccToEmail) throws EmailBuilderException {
        // Se revisa que el email sea válido.
        if (Check.isValidEmail(ccToEmail)) {
            // De serlo, se añade a la lista de destinatarios en copia, ya inicializada en el constructor
            this.to.add(ccToEmail);
        } else {
            throw new EmailBuilderException(texts.getText("FormatErrorDestination"));
        }
        return this;
    }
}
