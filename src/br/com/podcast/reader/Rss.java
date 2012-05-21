/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podcast.reader;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vpaz
 */

/*
 * Rss
 */
@XmlRootElement(name = "rss")
public class Rss implements Serializable {

    private PodCastChannel podCastChannel;

    @XmlElement(name = "channel")
    public PodCastChannel getPodCastChannel() {
        return podCastChannel;
    }

    public void setPodCastChannel(PodCastChannel podCastChannel) {
        this.podCastChannel = podCastChannel;
    }
}
