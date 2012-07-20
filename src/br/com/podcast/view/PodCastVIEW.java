package br.com.podcast.view;

import br.com.podcast.ctrl.PodCastCTRL;
import br.com.podcast.view.Renderer.PodCastTableCellRenderer;
import br.com.podcast.view.model.PodCastListModel;
import br.com.podcast.view.model.PodCastTableModel;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author vpaz
 */
public class PodCastVIEW extends javax.swing.JFrame {

    /**
     * Creates new form PodCastVIEW
     */
    private PodCastCTRL controle;
    private PodCastTableModel tableModel;
    private PodCastListModel listModel;
    private JFileChooser localDownload;

    public PodCastVIEW() {

        initComponents();

        setTitle("PodCast - ");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        controle = new PodCastCTRL(this);
        this.lerFeedjButton.addActionListener(controle);
        this.downloadjButton.addActionListener(controle);
        this.atualizaButton.addActionListener(controle);

        this.proxyjMenuItem.addActionListener(controle);
        this.downloadMenuItem.addActionListener(controle);

        this.jList.addMouseListener(controle);
        this.jTable.addMouseListener(controle);

        tableModel = new PodCastTableModel();
        jTable.setModel(tableModel);
        jTable.setDefaultRenderer(Object.class, new PodCastTableCellRenderer());

        listModel = new PodCastListModel();
        jList.setModel(listModel);

        localDownload = new JFileChooser();
        localDownload.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        defineRenderers();

    }

    private void defineRenderers() {

        JTableHeader header = getjTable().getTableHeader();
        header.setPreferredSize(new Dimension(0, 35));
        TableColumnModel modeloDaColuna = getjTable().getColumnModel();

        modeloDaColuna.getColumn(0).setMinWidth(50);
        modeloDaColuna.getColumn(1).setMinWidth(75);
        modeloDaColuna.getColumn(1).setMaxWidth(75);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        urlFeedjTextField = new javax.swing.JTextField();
        lerFeedjButton = new javax.swing.JButton();
        urlFeedjLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        downloadjButton = new javax.swing.JButton();
        statusDownloadjLabel = new javax.swing.JLabel();
        bibliotecaPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList();
        atualizaButton = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        arquivojMenu = new javax.swing.JMenu();
        preferenciajMenu = new javax.swing.JMenu();
        proxyjMenuItem = new javax.swing.JMenuItem();
        configuracaoMenu = new javax.swing.JMenu();
        downloadMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        urlFeedjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlFeedjTextFieldActionPerformed(evt);
            }
        });

        lerFeedjButton.setText("Ler");

        urlFeedjLabel.setText("Url do feed:");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable);

        downloadjButton.setText("Download");
        downloadjButton.setPreferredSize(new java.awt.Dimension(40, 23));

        statusDownloadjLabel.setText("Status:");

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(urlFeedjLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(urlFeedjTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lerFeedjButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addComponent(statusDownloadjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(downloadjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urlFeedjLabel)
                    .addComponent(urlFeedjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lerFeedjButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(statusDownloadjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(downloadjButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        getContentPane().add(Panel, java.awt.BorderLayout.CENTER);

        bibliotecaPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setViewportView(jList);

        atualizaButton.setText("Atualizar");

        javax.swing.GroupLayout bibliotecaPanelLayout = new javax.swing.GroupLayout(bibliotecaPanel);
        bibliotecaPanel.setLayout(bibliotecaPanelLayout);
        bibliotecaPanelLayout.setHorizontalGroup(
            bibliotecaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addGroup(bibliotecaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(atualizaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        bibliotecaPanelLayout.setVerticalGroup(
            bibliotecaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bibliotecaPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(atualizaButton)
                .addContainerGap())
        );

        getContentPane().add(bibliotecaPanel, java.awt.BorderLayout.WEST);

        arquivojMenu.setText("Arquivo");
        jMenuBar.add(arquivojMenu);

        preferenciajMenu.setText("Preferência");

        proxyjMenuItem.setText("Proxy");
        preferenciajMenu.add(proxyjMenuItem);

        configuracaoMenu.setText("Configuração");

        downloadMenuItem.setText("local download");
        configuracaoMenu.add(downloadMenuItem);

        preferenciajMenu.add(configuracaoMenu);

        jMenuBar.add(preferenciajMenu);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void urlFeedjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlFeedjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urlFeedjTextFieldActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JMenu arquivojMenu;
    private javax.swing.JButton atualizaButton;
    private javax.swing.JPanel bibliotecaPanel;
    private javax.swing.JMenu configuracaoMenu;
    private javax.swing.JMenuItem downloadMenuItem;
    private javax.swing.JButton downloadjButton;
    private javax.swing.JList jList;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JButton lerFeedjButton;
    private javax.swing.JMenu preferenciajMenu;
    private javax.swing.JMenuItem proxyjMenuItem;
    private javax.swing.JLabel statusDownloadjLabel;
    private javax.swing.JLabel urlFeedjLabel;
    private javax.swing.JTextField urlFeedjTextField;
    // End of variables declaration//GEN-END:variables

    //<editor-fold defaultstate="collapsed" desc="//Getters and Setters">
    public JPanel getPanel() {
        return Panel;
    }

    public void setPanel(JPanel Panel) {
        this.Panel = Panel;
    }

    public JPanel getBibliotecaPanel() {
        return bibliotecaPanel;
    }

    public void setBibliotecaPanel(JPanel bibliotecaPanel) {
        this.bibliotecaPanel = bibliotecaPanel;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public PodCastTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(PodCastTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public JButton getAtualizaButton() {
        return atualizaButton;
    }

    public void setAtualizaButton(JButton atualizaButton) {
        this.atualizaButton = atualizaButton;
    }

    public JList getjList() {
        return jList;
    }

    public void setjList(JList jList) {
        this.jList = jList;
    }

    public JMenu getConfiguracaoMenu() {
        return configuracaoMenu;
    }

    public PodCastListModel getListModel() {
        return listModel;
    }

    public void setListModel(PodCastListModel listModel) {
        this.listModel = listModel;
    }

    public JFileChooser getLocalDownload() {
        return localDownload;
    }

    public void setLocalDownload(JFileChooser localDownload) {
        this.localDownload = localDownload;
    }

    public void setConfiguracaoMenu(JMenu configuracaoMenu) {
        this.configuracaoMenu = configuracaoMenu;
    }

    public PodCastCTRL getControle() {
        return controle;
    }

    public void setControle(PodCastCTRL controle) {
        this.controle = controle;
    }

    public JMenuItem getDownloadMenuItem() {
        return downloadMenuItem;
    }

    public void setDownloadMenuItem(JMenuItem downloadMenuItem) {
        this.downloadMenuItem = downloadMenuItem;
    }

    public JPanel getjPanel1() {
        return Panel;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.Panel = jPanel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JMenu getArquivojMenu() {
        return arquivojMenu;
    }

    public void setArquivojMenu(JMenu arquivojMenu) {
        this.arquivojMenu = arquivojMenu;
    }

    public JMenuBar getjMenuBar() {
        return jMenuBar;
    }

    public void setjMenuBar(JMenuBar jMenuBar) {
        this.jMenuBar = jMenuBar;
    }

    public JButton getLerFeedjButton() {
        return lerFeedjButton;
    }

    public void setLerFeedjButton(JButton lerFeedjButton) {
        this.lerFeedjButton = lerFeedjButton;
    }

    public JMenu getPreferenciajMenu() {
        return preferenciajMenu;
    }

    public void setPreferenciajMenu(JMenu preferenciajMenu) {
        this.preferenciajMenu = preferenciajMenu;
    }

    public JLabel getUrlFeedjLabel() {
        return urlFeedjLabel;
    }

    public void setUrlFeedjLabel(JLabel urlFeedjLabel) {
        this.urlFeedjLabel = urlFeedjLabel;
    }

    public JTextField getUrlFeedjTextField() {
        return urlFeedjTextField;
    }

    public void setUrlFeedjTextField(JTextField urlFeedjTextField) {
        this.urlFeedjTextField = urlFeedjTextField;
    }

    public PodCastTableModel getModel() {
        return tableModel;
    }

    public void setModel(PodCastTableModel model) {
        this.tableModel = model;
    }

    public JTable getjTable() {
        return jTable;
    }

    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }

    public JButton getDownloadjButton() {
        return downloadjButton;
    }

    public void setDownloadjButton(JButton downloadjButton) {
        this.downloadjButton = downloadjButton;
    }

    public JLabel getStatusDownloadjLabel() {
        return statusDownloadjLabel;
    }

    public void setStatusDownloadjLabel(JLabel statusDownloadjLabel) {
        this.statusDownloadjLabel = statusDownloadjLabel;
    }

    public JMenuItem getProxyjMenuItem() {
        return proxyjMenuItem;
    }

    public void setProxyjMenuItem(JMenuItem proxyjMenuItem) {
        this.proxyjMenuItem = proxyjMenuItem;
    }
    //</editor-fold>
}
