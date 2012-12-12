package br.com.podcast.ctrl;

import br.com.podcast.persistencia.PodCastChannelDAO;
import br.com.podcast.persistencia.PodCastDAO;
import br.com.podcast.reader.PodCast;
import br.com.podcast.reader.PodCastChannel;
import br.com.podcast.reader.Rss;
import br.com.podcast.util.PodCastComparator;
import br.com.podcast.util.PodCastMain;
import br.com.podcast.view.DescricaoPodCastVIEW;
import br.com.podcast.view.PodCastVIEW;
import br.com.podcast.view.ProxyUserVIEW;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author vpaz
 */
public class PodCastCTRL implements ActionListener, MouseListener {

    private PodCastVIEW view;
    private static Unmarshaller um;
    private PodCastChannelDAO pccDao;
    private PodCastDAO pcDao;
    private String localDownload;

    public PodCastCTRL(PodCastVIEW view) {
        this.view = view;
    }

    // <editor-fold defaultstate="collapsed" desc="MouseListener">
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == view.getjTable()) {
            if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {

                DescricaoPodCastVIEW d = new DescricaoPodCastVIEW(view, true);

                d.getjTextPane1().setText(view.getModel().getPodCast(view.getjTable().getSelectedRow()).getEncoded());

                d.setVisible(true);

            }
        }
        if (e.getSource() == view.getjList()) {
            if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {

                PodCastChannel pcc = view.getListModel().getElementAt(view.getjList().getSelectedIndex());

                view.getModel().setPodCastsList(pcc.getItens());
                view.setTitle("PodCast - " + pcc.getName());

            }
        }
        if (e.getSource() == view.getjTable()) {
            if (e.getButton() == MouseEvent.BUTTON3) {
            }
        }


    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
    // </editor-fold>

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view.getLerFeedjButton()) {
            readerFeed();
        }

        if (e.getSource() == view.getDownloadjButton()) {
            startDownload();
        }

        if (e.getSource() == view.getProxyjMenuItem()) {
            configProxy();
        }

        if (e.getSource() == view.getDownloadMenuItem()) {
            fileDownload();
        }
        if (e.getSource() == view.getAtualizaButton()) {
            updatePodCast();
        }
    }

    private void defineLocalDownload() {
        localDownload = PodCastMain.getProxyConfig().getProperty("localDownload");
        localDownload += System.getProperty("file.separator");

        if (localDownload == null || localDownload.equals("")) {
            localDownload = System.getProperty("user.home") + System.getProperty("file.separator");
        } else {
            localDownload += System.getProperty("file.separator");
        }
    }

    private void fileDownload() throws HeadlessException {

        int returnVal = view.getLocalDownload().showOpenDialog(view);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {

                File file = view.getLocalDownload().getSelectedFile();

                PodCastMain.getProxyConfig().setProperty("localDownload", file.getAbsolutePath());

                PodCastMain.getProxyConfig().store(new FileOutputStream(new File("proxyuser.properties")), "proxyuser");

            } catch (IOException ex) {
                Logger.getLogger(PodCastCTRL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void configProxy() {

        ProxyUserVIEW proxyView = new ProxyUserVIEW(view, true);

        proxyView.getEnderecotTextField().setText(PodCastMain.getProxyConfig().getProperty("host"));
        proxyView.getPortaTextField().setText(PodCastMain.getProxyConfig().getProperty("port"));
        proxyView.getUsuarioTextField().setText(PodCastMain.getProxyConfig().getProperty("user"));
        proxyView.getPasswordField().setText(PodCastMain.getProxyConfig().getProperty("password"));

        proxyView.setVisible(true);
    }

    private void readerFeed() {
        PodCastChannel pc = null;
        try {

            String podCastXml = view.getUrlFeedjTextField().getText();
            pccDao = new PodCastChannelDAO();

            if (!pccDao.existePodCastChannelComUrl(podCastXml)) {

                Rss rss = unmarshalFeed(podCastXml);
                pccDao.salvarPodCastChannel(rss.getPodCastChannel());

            }
            pc = pccDao.buscaPodCastChannelComUrl(podCastXml);

            view.setTitle("PodCast - " + pc.getName());
            view.getModel().setPodCastsList(pc.getItens());


        } catch (Exception ex) {
            Logger.getLogger(PodCastCTRL.class.getName()).log(Level.SEVERE, null, ex);
        }

        view.getListModel().atualizarConteudo();
        view.getUrlFeedjTextField().setText("");
    }

    private Rss unmarshalFeed(String podCastXml) throws MalformedURLException, JAXBException {

        JAXBContext context = JAXBContext.newInstance(Rss.class);
        um = context.createUnmarshaller();
        Rss rss = (Rss) um.unmarshal(new URL(podCastXml));
        rss.getPodCastChannel().setUrl(podCastXml);

        for (PodCast podCast : rss.getPodCastChannel().getItens()) {
            Date pubDate = null;
            try {
                pubDate = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.US).parse(podCast.getPubDate());
                podCast.setDataPublicacao(pubDate);
            } catch (ParseException ex) {
                Logger.getLogger(PodCast.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rss;

    }

    private void startDownload() {
        for (PodCast podCast : view.getModel().getPodCastsList()) {

            if (podCast.getSelecionadoParaDownload()) {
                try {

                    String podCastNome = podCast.getEnclosure().getUrl().substring(podCast.getEnclosure().getUrl().lastIndexOf("/") + 1);
                    URLConnection conn = new URL(podCast.getEnclosure().getUrl()).openConnection();
                    InputStream is = conn.getInputStream();

                    defineLocalDownload();

                    File file = new File(localDownload + podCast.getPodCastChannel().getName());
                    OutputStream outstream = null;
                    String pathDownload = localDownload + podCast.getPodCastChannel().getName() + System.getProperty("file.separator") + podCastNome;
                            
                    if (file.exists() && file.isDirectory()) {
                        outstream = new FileOutputStream(new File(pathDownload));
                    } else {
                        file.mkdir();
                        outstream = new FileOutputStream(new File(pathDownload));
                    }

                    byte[] buffer = new byte[4096];
                    int len;

                    while ((len = is.read(buffer)) > 0) {

                        outstream.write(buffer, 0, len);

                    }

                    outstream.close();

                    pcDao = new PodCastDAO();
                    podCast.setDownloadConcluido(Boolean.TRUE);
                    pcDao.alterarPodCast(podCast);

                    podCast.setSelecionadoParaDownload(Boolean.FALSE);

                } catch (Exception ex) {
                    Logger.getLogger(PodCastCTRL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        view.getModel().fireTableDataChanged();
    }

    private void updatePodCast() {
        try {

            PodCastChannel pcc = view.getListModel().getElementAt(view.getjList().getSelectedIndex());
            Rss rss = unmarshalFeed(pcc.getUrl());

            for (PodCast podCastUrl : rss.getPodCastChannel().getItens()) {
                if (!pcc.getItens().contains(podCastUrl)) {
                    podCastUrl.setNovoPodCast(Boolean.TRUE);
                    podCastUrl.setPodCastChannel(pcc);
                    pcc.getItens().add(podCastUrl);


                }
            }
            Collections.sort(pcc.getItens(), new PodCastComparator());

            pccDao = new PodCastChannelDAO();
            pccDao.salvarPodCastChannel(pcc);
            view.getModel().fireTableDataChanged();

        } catch (MalformedURLException ex) {
            Logger.getLogger(PodCastCTRL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(PodCastCTRL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PodCastCTRL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
