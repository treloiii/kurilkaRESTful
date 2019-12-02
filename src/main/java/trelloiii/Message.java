package trelloiii;

public class Message {

    private int id;
    private String name;
    private String message;
    private String img;
    private String img_message;

    public Message(int id, String name, String message, String img, String img_message) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.img = img;
        this.img_message = img_message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setImg_message(String img_message) {
        this.img_message = img_message;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getImg() {
        return img;
    }

    public String getImg_message() {
        return img_message;
    }
}
