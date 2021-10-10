package com.greatlearning.main;

import java.util.ArrayList;

public class LongestPath{
	
// Binary tree node
static class Node
{
	Node left,right;
	int data;
};

// Function to create a new Binary node
static Node newNode(int data)
{
	Node temp = new Node();

	temp.data = data;
	temp.left =temp.right = null;

	return temp;
}

// Function to find and return the longest path
public static ArrayList<Integer> longestPath(Node root)
{
	
	// If root is null means there is no binary tree so return a empty vector
	if(root == null)
	{
		ArrayList<Integer> output = new ArrayList<>();
		return output;
	}
		
	// Recursive call on root.left
	ArrayList<Integer> left = longestPath(root.left);
	
	// Recursive call on root.right
	ArrayList<Integer> right = longestPath(root.right);
	
	// Compare the size of the two ArrayList and insert current node accordingly
	if(left.size() > right.size() )
	{
		left.add(root.data);
	}
	else
	{
		right.add(root.data);
	}
	
	// Return the appropriate ArrayList
	return (left.size() > right.size() ? left :right);
}

// Driver Code
public static void main(String[] args)
{
	//Construct binary tree 
	
	Node root = newNode(100);
	root.left = newNode(20);
	root.left.left = newNode(10);
	root.left.left.left = newNode(5);
	root.left.right = newNode(50);
	root.right = newNode(130);
	root.right.left= newNode(110);
	root.right.right = newNode(140);
	
	ArrayList<Integer> output = longestPath(root);
	int n = output.size();
	System.out.print("Longest Path: ");
	
	System.out.print(output.get(n - 1));
	
	for(int i = n - 2; i >= 0; i--)
	{
		System.out.print(" -> " + output.get(i));
	}
}
}
