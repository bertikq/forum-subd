package ru.ulstu.model;

public class PaperStatistic {
    private String Name;

    private String body;

    public PaperStatistic(String name, String body) {
        Name = name;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
