package lamda.gmailRichFilters;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}

