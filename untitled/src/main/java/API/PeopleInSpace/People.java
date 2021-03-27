package API.PeopleInSpace;

import com.fasterxml.jackson.annotation.JsonProperty;

public class People {


    @JsonProperty("name")
    private String name;

    @JsonProperty("craft")
    private String spaceShipName;

    public People(String name, String spaceShipName) {
        this.name = name;
        this.spaceShipName = spaceShipName;
    }

    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpaceShipName() {
        return spaceShipName;
    }

    public void setSpaceShipName(String spaceShipName) {
        this.spaceShipName = spaceShipName;
    }

    @Override
    public String toString() {
        return this.name + "\n";
    }
}
