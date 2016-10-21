package com.bakkenbaeck.token.network.ws.model;

public class WebSocketError {

    public WebSocketError() {
        this.payload = new Internals();
    }

    private Internals payload;

    public WebSocketErrors getCode() {
        return this.payload.code;
    }

    private static class Internals {
        private Internals() {
            this.code = WebSocketErrors.unexpected_error;
        }
        private WebSocketErrors code;
    }
}
