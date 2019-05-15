/*
 * Developed by Jan Misiorny
 * February A.D. 2019
 */

package com.decisionTree.wiki.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@NoArgsConstructor
@Entity
@ToString
public class TreeDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTree;

    private Integer root;

    private Integer lefty;

    private Integer righty;

    public Integer getIdTree() {
        return idTree;
    }

    public void setIdTree(Integer idTree) {
        this.idTree = idTree;
    }

    public Integer getRoot() {
        return root;
    }

    public void setRoot(Integer root) {
        this.root = root;
    }

    public Integer getLefty() {
        return lefty;
    }

    public void setLefty(Integer lefty) {
        this.lefty = lefty;
    }

    public Integer getRighty() {
        return righty;
    }

    public void setRighty(Integer righty) {
        this.righty = righty;
    }
}
