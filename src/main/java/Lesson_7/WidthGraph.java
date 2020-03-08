package Lesson_7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class WidthGraph<T> {

    private class Vertex<T>{

        private int id;
        private T object;
        private boolean wasVisited;

        public Vertex(T object, int id) {
            this.object = object;
            wasVisited = false;
            this.id = id;
        }

        @Override
        public String toString() {
            return object.toString();
        }
    }

    private Vertex[] vertices;
    private int[][] adjMatrix;
    private int fullness;

    public WidthGraph(int maxSize) {
        vertices = new Vertex[maxSize];
        adjMatrix = new int[maxSize][maxSize];
        fullness = 0;
    }

    public void  addVertex(String object, int id){
        vertices[fullness++] = new Vertex(object, id);
    }

    public void addEdge(T start, T end){
        Vertex v1 = checkVertex(start);
        Vertex v2 = checkVertex(end);
        if (v1 == null || v2 == null) return;
        adjMatrix[v1.id][v2.id] = 1;
        adjMatrix[v2.id][v1.id] = 1;
    }

    public void showVertex(int value){
        System.out.println(vertices[value].object);
    }

    private void resetFlags(){
        for (int i = 0; i < fullness; i++) {
            vertices[i].wasVisited = false;
        }
    }

    private Vertex getUnVisitedVertex(Vertex vertex){
        for (int i = 0; i < fullness; i++) {
            if (adjMatrix[vertex.id][i] == 1 && !vertices[i].wasVisited){
                return vertices[i];
            }
        }
        return null;
    }

    public void removeVertex() {
        Stack<Vertex> stack = new Stack<>();
        vertices[0].wasVisited = true;
        stack.push(vertices[0]);
        while (!stack.isEmpty()) {
            Vertex vertex = getUnVisitedVertex(stack.peek());
            if (vertex == null) stack.pop();
            else {
                vertex.wasVisited = true;
                stack.push(vertex);
            }
        }
        resetFlags();
    }

    private Vertex checkVertex(T object){
        for (int i = 0; i < fullness; i++) {
            if(vertices[i].object.equals(object)) return vertices[i];
        }
        System.out.printf("Вершина не указана %s \n", object);
        return null;
    }

    public LinkedList<Vertex> findShortestPath(T start, T finish){
        Vertex beginning = checkVertex(start);
        Vertex end = checkVertex(finish);

        if (beginning == null || finish == null) return null;

        Queue<Vertex>  queue = new LinkedList<>();
        ArrayList<LinkedList<Vertex>> arrayList = new ArrayList<>();
        LinkedList<Vertex> linkedList = new LinkedList<>();

        linkedList.add(beginning);
        arrayList.add(linkedList);
        beginning.wasVisited = true;
        queue.offer(beginning);
        while (!queue.isEmpty()){
            Vertex current = queue.poll();
            Vertex next;
            int count = 0;

            while ((next = getUnVisitedVertex(current)) != null){
                next.wasVisited = true;
                queue.offer(next);
                for (int i = 0; i < arrayList.size(); i++) {
                    if ((arrayList.get(i)).peekLast() == current){
                        arrayList.get(i).add(next);
                        if (next == end) {
                            resetFlags();
                            return arrayList.get(i);
                        }
                        break;
                    }
                    ++count;
                }

                if (count >= arrayList.size()){
                    for (int i = 0; i < arrayList.size(); i++) {
                        if ((arrayList.get(i)).get(arrayList.get(i).size() - 2) == current){
                            LinkedList<Vertex> linked = new LinkedList<>(arrayList.get(i));
                            linked.set(linked.size() - 1, next);
                            if (next == end) {
                                resetFlags();
                                return linked;
                            }
                            arrayList.add(linked);
                            break;
                        }
                    }
                }
            }
        }
        resetFlags();
        return null;
    }
}
