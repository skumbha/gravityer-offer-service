package com.gravityer.offer.exception;

public class OfferServiceRuntimeException extends RuntimeException implements IServiceError{

    private int errorCode;

    public OfferServiceRuntimeException(int errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
    }

    @Override
    public int getErrorCode() {
        return errorCode;
    }
}
