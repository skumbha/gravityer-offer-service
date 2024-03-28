package com.gravityer.offer.exception;

public class ErrorMessage {
        private int code;
        private String message;

        public ErrorMessage(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
}