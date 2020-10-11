package com.DigitalBank.error;

public class ValidationErrorDetails extends ErrorDetail {
    private String field;
    private String fieldMessage;

    public String getField() {
        return field;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }

    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private String developerMessage;
        private String field;
        private String fieldMessage;

        private Builder() {
        }

        public static ValidationErrorDetails.Builder newBuilder() {
            return new ValidationErrorDetails.Builder();
        }

        public ValidationErrorDetails.Builder field(String field) {
            this.field = field;
            return this;
        }

        public ValidationErrorDetails.Builder fieldMessage(String fieldMessage) {
            this.fieldMessage = fieldMessage;
            return this;
        }

        public ValidationErrorDetails.Builder title(String title) {
            this.title = title;
            return this;
        }

        public ValidationErrorDetails.Builder status(int status) {
            this.status = status;
            return this;
        }

        public ValidationErrorDetails.Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public ValidationErrorDetails.Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ValidationErrorDetails build() {
            ValidationErrorDetails validationErrorDetails = new ValidationErrorDetails();
            validationErrorDetails.setTitle(title);
            validationErrorDetails.setDetail(detail);
            validationErrorDetails.setDeveloperMessage(developerMessage);
            validationErrorDetails.setStatus(status);
            validationErrorDetails.fieldMessage = fieldMessage;
            validationErrorDetails.field = field;
            return validationErrorDetails;
        }
    }
}
