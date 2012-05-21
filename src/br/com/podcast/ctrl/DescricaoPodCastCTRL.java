/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podcast.ctrl;

import br.com.podcast.view.DescricaoPodCastVIEW;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author vpaz
 */
public class DescricaoPodCastCTRL implements HyperlinkListener {

    public DescricaoPodCastVIEW view;

    public DescricaoPodCastCTRL(DescricaoPodCastVIEW view) {
        this.view = view;
    }

    public void hyperlinkUpdate(HyperlinkEvent he) {

        HyperlinkEvent.EventType type = he.getEventType();

        if (type == HyperlinkEvent.EventType.ACTIVATED) {

            try {
                Desktop.getDesktop().browse(he.getURL().toURI());
            } catch (URISyntaxException ex) {
                Logger.getLogger(DescricaoPodCastVIEW.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DescricaoPodCastVIEW.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}