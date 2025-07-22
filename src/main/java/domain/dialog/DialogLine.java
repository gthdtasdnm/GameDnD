package domain.dialog;

public class DialogLine implements InfoElement{
    private String id;
    private String text;

    public DialogLine(String id, String text){
        this.id = id;
        this.text = text;
    }

    public String getId(){return id;}

    public String getText(){return text;}

    @Override
    public void execute() {
        System.out.println(text);
    }
}
