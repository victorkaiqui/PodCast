/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podcast.reader;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author vpaz
 */

/*
 * enclosure
 */
@Entity
public class Enclosure implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String url;
    @OneToOne(mappedBy = "enclosure")
    private PodCast podCast;

    @XmlAttribute(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PodCast getPodCast() {
        return podCast;
    }

    public void setPodCast(PodCast podCast) {
        this.podCast = podCast;
    }
}
