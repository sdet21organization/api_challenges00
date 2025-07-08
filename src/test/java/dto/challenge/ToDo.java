package dto.challenge;

public class ToDo {
    public int id;
    public String title;
    public boolean doneStatus;
    public String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDoneStatus() {
        return doneStatus;
    }

    public void setDoneStatus(boolean doneStatus) {
        this.doneStatus = doneStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
