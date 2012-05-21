/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podcast.view.model;

import br.com.podcast.persistencia.PodCastChannelDAO;
import br.com.podcast.reader.PodCastChannel;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author vpaz
 */
public class PodCastListModel extends AbstractListModel<PodCastChannel> {

    PodCastChannelDAO pccDao = new PodCastChannelDAO();
    private List<PodCastChannel> podCastChannels;

    public PodCastListModel() {
        podCastChannels = pccDao.selecionarPodCastChannel();
    }

    public int getSize() {
        return podCastChannels.size();
    }

    public PodCastChannel getElementAt(int index) {
        return podCastChannels.get(index);
    }
    
    public void atualizarConteudo(){
        podCastChannels = pccDao.selecionarPodCastChannel();
        fireContentsChanged(this, 0, podCastChannels.size());
    }
    
}
