/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podcast.ctrl;

import br.com.podcast.util.PodCastMain;
import br.com.podcast.view.ProxyUserVIEW;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vpaz
 */
public class ProxyUserCTRL implements ActionListener {

    ProxyUserVIEW view;

    public ProxyUserCTRL(ProxyUserVIEW view) {
        this.view = view;
    }

    private void salvarProxy() throws Exception {
        PodCastMain.getProxyConfig().setProperty("host", view.getEnderecotTextField().getText());
        PodCastMain.getProxyConfig().setProperty("port", view.getPortaTextField().getText());
        PodCastMain.getProxyConfig().setProperty("user", view.getUsuarioTextField().getText());
        PodCastMain.getProxyConfig().setProperty("password", new String(view.getPasswordField().getPassword()));

        PodCastMain.getProxyConfig().store(new FileOutputStream(new File("proxyuser.properties")), "proxyuser");

        PodCastMain.reloadProxyConfig();

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view.getSalvarToggleButton()) {
            try {

                salvarProxy();
                view.dispose();

            } catch (Exception ex) {
                Logger.getLogger(ProxyUserCTRL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
