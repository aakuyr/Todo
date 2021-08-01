package app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class  Task {
    @Getter
    @Setter
    private int id;

    @JsonProperty(value = "task")
    @Getter
    @Setter
    public String task;

    @JsonProperty(value = "done")
    @Setter
    public boolean done;
}
