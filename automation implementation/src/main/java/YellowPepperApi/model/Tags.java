package YellowPepperApi.model;

public class Tags {

    double id;
    String name;

    public Tags(double id, String name) {
        this.id = id;
        this.name = name;
    }

    public Tags() {
    }


    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
