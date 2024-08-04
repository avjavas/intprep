package com.avj.tree;


import lombok.*;


@ToString
@Builder
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Node {

    private Integer data;
    private Node left;
    private Node right;
}
