package quizkampen;


public class Fr�ga {
    
    private String question;
    private int r�ttR;
    private int r�ttK;
    private String a;
    private String b;
    private String c;
    private String d;
    
    public Fr�ga(String question, int r�ttR, int r�ttK, String a, String b, String c, String d){
        
        this.question = question;
        this.r�ttR = r�ttR;
        this.r�ttK = r�ttK;
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
        return r�ttR;
    }
    
    public int getK(){
        return r�ttK;
    }
    
}