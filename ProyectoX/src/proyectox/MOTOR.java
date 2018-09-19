/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectox;

import java.util.List;

/**
 *
 * @author root
 * 
 * 
 * VERSION 1.0
 */
public interface MOTOR {
    public PROCESO quickscan(String Target);
    public PROCESO fullscan(String Target);
    public PROCESO arpspoof(String Interface, String Target, String Host);
    public PROCESO dnsspoof(String Interface,String HostFile);
    public void ip_forward();
    public List<String> get_NETIF();
}
