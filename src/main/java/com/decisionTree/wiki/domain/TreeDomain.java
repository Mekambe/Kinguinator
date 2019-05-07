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
@Table(name="tree", schema = "")
@ToString
public class TreeDomain {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idTree;

    private int root;
    private int left;
    private int right;

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
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}
