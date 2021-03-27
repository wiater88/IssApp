package API.FuturePosition;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Message {


    @JsonProperty("message")
    private String message;
    @JsonProperty("request")
    private Request request;
    @JsonProperty("response")
    private List<Response> responseList;

    public Message(String message, Request request, List<Response> responseList) {
        this.message = message;
        this.request = request;
        this.responseList = responseList;
    }

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public List<Response> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Response> responseList) {
        this.responseList = responseList;
    }

    @Override
    public String toString() {
        return responseList.toString();
    }
}
