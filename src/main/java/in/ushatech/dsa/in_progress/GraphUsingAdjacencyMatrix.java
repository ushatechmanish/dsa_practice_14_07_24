package in.ushatech.dsa.in_progress;

import java.util.ArrayList;
import java.util.List;

// TODO complete the implementation after the queue and stack expertise
public class GraphUsingAdjacencyMatrix 
{
    private List<GraphNodeForAdjacencyMatrix> listOfNodes = new ArrayList<>();
    int[][] adjacencyMatrix;
    public GraphUsingAdjacencyMatrix(List<GraphNodeForAdjacencyMatrix> listOfNodes)
    {
        this.listOfNodes=listOfNodes;
        adjacencyMatrix=new int[listOfNodes.size()][listOfNodes.size()];
    }

    public void addUndirectedEdge(int i , int j)
    {
        adjacencyMatrix[i][j]=1;
        adjacencyMatrix[j][i]=1;
    }

    

}
