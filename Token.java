
import java.io.Serializable;
import java.time.LocalTime;

public class Token implements Serializable{
    private String IP;
    private int p_esc;
    private int p_env;
    private String id_pros;
    private LocalTime h_servicio;
    private LocalTime ultima_hora;
    
    public Token(){
        
    }
    
    public Token(String ip,int pS,int pE,String id,LocalTime hS,LocalTime uH){
        IP = ip;
        p_esc = pS;
        p_env = pE;
        id_pros = id;
        h_servicio = hS;
        ultima_hora = uH;
    }
    
    @Override
    public String toString(){
        return "IP: "+IP+
                "\nPuerto al que escucha: "+p_esc+
                "\nPuerto al que envia: "+p_env+
                "\nID de proceso: "+id_pros+
                "\nHora inico servicio: "+h_servicio+
                "\nHora de funcionamiento del servicio: "+ultima_hora;
    }
}
