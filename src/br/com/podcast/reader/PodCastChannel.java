/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podcast.reader;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author vpaz
 */
@Entity
public class PodCastChannel implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany(mappedBy = "podCastChannel", cascade = CascadeType.ALL)
    @OrderBy(value = "dataPublicacao desc")
    private List<PodCast> itens;
    private String name;
    private String link;
    private String description;
    private String url;

    @Override
    public String toString() {
        return name;
    }

    @XmlElement(name = "title")
    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "item")
    public List<PodCast> getItens() {
        return itens;
    }

    public void setItens(List<PodCast> itens) {
        this.itens = itens;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
