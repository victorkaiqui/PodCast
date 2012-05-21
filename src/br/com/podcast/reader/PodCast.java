/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podcast.reader;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author vpaz
 */
@Entity
public class PodCast implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String link;
    @Transient
    private String pubDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPublicacao;
    @Lob
    private String encoded;
    @Lob
    private String description;
    @Transient
    private Boolean selecionadoParaDownload = false;
    @Transient
    private Boolean novoPodCast = false;
    private Boolean downloadConcluido = false;
    @OneToOne(cascade = CascadeType.ALL)
    private Enclosure enclosure;
    @ManyToOne
    private PodCastChannel podCastChannel;

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @XmlElement(namespace = "http://purl.org/rss/1.0/modules/content/")
    public String getEncoded() {
        return encoded;
    }

    public Boolean isNovoPodCast() {
        return novoPodCast;
    }

    public void setNovoPodCast(Boolean novoPodCast) {
        this.novoPodCast = novoPodCast;
    }

    public void setEncoded(String encoded) {
        this.encoded = encoded;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public Boolean getSelecionadoParaDownload() {
        return selecionadoParaDownload;
    }

    public void setSelecionadoParaDownload(Boolean selecionadoParaDownload) {
        this.selecionadoParaDownload = selecionadoParaDownload;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PodCastChannel getPodCastChannel() {
        return podCastChannel;
    }

    public void setPodCastChannel(PodCastChannel podCastChannel) {
        this.podCastChannel = podCastChannel;
    }

    public Boolean getDownloadConcluido() {
        return downloadConcluido;
    }

    public void setDownloadConcluido(Boolean downloadConcluido) {
        this.downloadConcluido = downloadConcluido;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PodCast other = (PodCast) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
}
