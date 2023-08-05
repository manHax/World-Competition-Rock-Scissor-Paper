package JFo_7;

public class Cell {
    private String cellName;
    private boolean isDoorOpen;
    private String securityKey;
    public Cell(String cellName,boolean isDoorOpen, String privateKey){
        this.securityKey =privateKey;
        this.cellName=cellName;
        this.isDoorOpen =isDoorOpen;
    }

    public void modifyDoor(String securityKey){
        if (!this.securityKey.equalsIgnoreCase(securityKey)){
            System.out.println("cant open the door");return;
        }
        if (isDoorOpen) {isDoorOpen=false;
            System.out.println("door is closed");return;}
        System.out.println("door is opened");
        isDoorOpen=true;

    }
}
