package FGA;

public class casting {
    public byte a= (byte) 128;
    public byte b= (byte) 127;
    public short s=128;


    public byte getA() {
        return a;
    }

    public void setA(byte a) {
        this.a = a;
    }

    public short getS() {
        return s;
    }

    public void setS(short s) {
        this.s = s;
    }

    public void castShortToAByte(){
        byte sB= (byte) s;
        System.out.println(sB);
    }

    public void causedError() {
        int n1= 53;
        int n2= 47;
//        byte problem= (n1+n2); caused error
        int solution1= (n1+n2);
        byte solution2 =(byte) (n1+n2);
        System.out.println(solution1+solution2);

        short a=1,b=2,c;
//        problem =a+b; samething as above you should casting the value as short or casting c as int




    }
}
