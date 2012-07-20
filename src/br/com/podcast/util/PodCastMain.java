package br.com.podcast.util;

import br.com.podcast.proxy.ProxyAuthenticator;
import br.com.podcast.view.PodCastVIEW;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Authenticator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vpaz
 */
public class PodCastMain {

    private static Properties configFile;

    static {
        try {

            File f = new File("proxyuser.properties");

            configFile = new Properties();
            configFile.load(new FileInputStream(f));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PodCastMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PodCastMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                new PodCastVIEW().setVisible(true);
                reloadProxyConfig();
            }
        });
    }

    public static Properties getProxyConfig() {
        return configFile;
    }

    public static void reloadProxyConfig() {

        Authenticator.setDefault(new ProxyAuthenticator(configFile.getProperty("user"), configFile.getProperty("password")));
        System.setProperty("http.proxyHost", configFile.getProperty("host"));
        System.setProperty("http.proxyPort", configFile.getProperty("port"));

    }
}
