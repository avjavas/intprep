package com.avj.tree;


import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static Node root = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data....");
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("done")) {
                break;
            }
            Node node = Node.builder().data(Integer.valueOf(line)).left(null).right(null).build();
            if (root == null) {
                root = node;
                continue;
            }
            Node temp = root;
            while (true) {
                if (node.getData() < temp.getData()) {
                    if (temp.getLeft() == null) {
                        temp.setLeft(node);
                        break;
                    } else {
                        temp = temp.getLeft();
                    }
                } else if (node.getData() > temp.getData()) {
                    if (temp.getRight() == null) {
                        temp.setRight(node);
                        break;
                    } else {
                        temp = temp.getRight();
                    }
                }
            }


        }

        System.out.println("Inorder...");
        inorder(root);
        System.out.println("======================================================");
        levelorder();
    }

    private static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.getLeft());
        System.out.println(root.getData());
        inorder(root.getRight());
    }

    private static void levelorder() {

        LinkedList<Node> nodeq = new LinkedList<>();

        nodeq.add(root);
        nodeq.add(null);
        // GPLRG ==> get, print, left(add), right(add), get
        while (true) {
            if (nodeq.isEmpty()) {
                break;
            }
            Node temp = nodeq.remove();
            while (temp != null) {
                System.out.print("\t" + temp.getData());
                if (temp.getLeft() != null) {
                    nodeq.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    nodeq.add(temp.getRight());
                }
                temp = nodeq.remove();
            }
            if (!nodeq.isEmpty()) {
                nodeq.add(null);
                System.out.println("\n");
            }


        }


    }
}
