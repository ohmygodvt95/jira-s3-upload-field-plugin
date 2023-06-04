package net.runsystem.s3field;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.customfields.impl.GenericTextCFType;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.fields.TextFieldCharacterLengthValidator;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.plugin.spring.scanner.annotation.imports.JiraImport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S3UploadField extends GenericTextCFType {

    private static final Logger LOGGER = LoggerFactory.getLogger(S3UploadField.class);

    protected S3UploadField(
            @JiraImport CustomFieldValuePersister customFieldValuePersister,
            @JiraImport GenericConfigManager genericConfigManager,
            @JiraImport TextFieldCharacterLengthValidator textFieldCharacterLengthValidator,
            @JiraImport JiraAuthenticationContext jiraAuthenticationContext
    ) {
        super(customFieldValuePersister, genericConfigManager, textFieldCharacterLengthValidator, jiraAuthenticationContext);
        LOGGER.error("S3 start");
    }

    @Override
    public void updateValue(CustomField customField, Issue issue, String value) {
        super.updateValue(customField, issue, value);
        LOGGER.error("S3 update value");
    }
}