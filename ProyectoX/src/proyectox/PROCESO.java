package proyectox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;



public class PROCESO extends Thread{
  public Thread hilo;
  public String[] comando;
  private Runtime runtime;
  private Process process;
  private JTextArea texto;
  
  
  public PROCESO(String[] comando,Runtime runtime,JTextArea texto) throws IOException {
      this.comando = comando;  
      this.runtime=runtime;
      this.texto = texto;
      
  }
  
  @Override
  public void run(){
      try {
          process = runtime.exec(comando);
          BufferedReader buff=new BufferedReader(new InputStreamReader(process.getInputStream()));
          String aux="";
          aux=buff.readLine();
          while (aux!=null) {             
              texto.setText(texto.getText()+"\n"+aux);
              aux=buff.readLine();
          }
          buff.close();
          process.destroy();
       } catch (IOException ex) {
          Logger.getLogger(PROCESO.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
  public void start () {
      String id=String.valueOf(Math.random());   
      hilo = new Thread (this,id);
      hilo.start ();
  }
  
}
