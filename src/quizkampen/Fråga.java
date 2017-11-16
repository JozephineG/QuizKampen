package quizkampen;


public class Fråga {
    
    private String question;
    private int rättR;
    private int rättK;
    private String a;
    private String b;
    private String c;
    private String d;
    
    public Fråga(String question, int rättR, int rättK, String a, String b, String c, String d){
        
        this.question = question;
        this.rättR = rättR;
        this.rättK = rättK;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        
    }
    
    public String getQuestion(){
        return question;
    }
    
    public String getAnswerA(){
        return a;
    }
    
    public String getAnswerB(){
        return b;
    }
    
    public String getAnswerC(){
        return c;
    }
    
    public String getAnswerD(){
        return d;
    }
    
    public int getR(){
        return rättR;
    }
    
    public int getK(){
        return rättK;
    }
    
}