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
    private int idTree;

    private int root;

    private int lefty;

    private int righty;

    public int getIdTree() {
        return idTree;
    }

    public void setIdTree(int idTree) {
        this.idTree = idTree;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public int getLeft() {
        return lefty;
    }

    public void setLeft(int left) {
        this.lefty = left;
    }

    public int getRight() {
        return righty;
    }

    public void setRight(int right) {
        this.righty = right;
    }
}
