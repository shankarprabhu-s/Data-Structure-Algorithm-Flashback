package Graphs;

import java.util.*;

//
//
//
//
//  A --- B
//        | 
//        C
//
//
// 
// 
// 
// 
public class Graph {
    private HashMap<String , ArrayList<String>> adjList = new HashMap<>();

    public boolean addVertex(String vertex)
    {
        if(!adjList.containsKey(vertex))
        {
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public void printGraph()
    {
        System.out.println(adjList);
    }

    public boolean addEdge(String vertex1 , String vertex2)
    {
        if(adjList.containsKey(vertex1) && adjList.containsKey(vertex2))
        {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1 , String vertex2)
    {
        if(adjList.containsKey(vertex1) && adjList.containsKey(vertex2))
        {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex)
    {
        if (!adjList.containsKey(vertex)) {
            return false;
        }
        for(String s : adjList.get(vertex))
        {
            adjList.get(s).remove(vertex);
        }

        adjList.remove(vertex);
        return true;
    }
    }

