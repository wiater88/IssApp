package API.PeopleInSpace;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PeopleInSpace {

    @JsonProperty("message")
    private String message;

    @JsonProperty("number")
    private String numberPeoplesInSpace;

    @JsonProperty("people")
    private List<People> peopleList;

    public PeopleInSpace() {
    }

    public PeopleInSpace(String message, String numberPeoplesInSpace, List<People> peopleList) {
        this.message = message;
        this.numberPeoplesInSpace = numberPeoplesInSpace;
        this.peopleList = peopleList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNumberPeoplesInSpace() {
        return numberPeoplesInSpace;
    }

    public void setNumberPeoplesInSpace(String numberPeoplesInSpace) {
        this.numberPeoplesInSpace = numberPeoplesInSpace;
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }

    @Override
    public String toString() {
        return
                "Number of People in space now : " + numberPeoplesInSpace + "\n" +
                "People in Space right now : " + "\n" +

                peopleList;

    }
}
