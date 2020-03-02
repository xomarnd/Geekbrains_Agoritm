package Lesson_7;
import java.util.LinkedList;

/**
 * Реализовать программу, в которой задается граф из 10 вершин.
 * Задать ребра и найти кратчайший путь с помощью поиска в ширину.
 */
public class Main {
    public static void main(String[] args) {
        WidthGraph<String> widthGraph = new WidthGraph<> (32);
        //таганско-краснопресненская
        widthGraph.addVertex("Полежаевская", 0);
        widthGraph.addVertex("Беговая", 1);
        widthGraph.addVertex("Улица 1905 года", 2);
        widthGraph.addVertex("Баррикадная", 3);
        widthGraph.addVertex("Пушкинская", 4);
        widthGraph.addVertex("Кузнецкий Мост", 5);
        widthGraph.addVertex("Китай-город", 6);
        widthGraph.addVertex("Таганская", 7);
        widthGraph.addVertex("Пролетарская", 8);
        //кольцевая
        widthGraph.addVertex("Белорусская", 9 );
        widthGraph.addVertex("Добрынинская", 10);
        widthGraph.addVertex("Киевская", 11);
        widthGraph.addVertex("Комсомольская", 12);
        widthGraph.addVertex("Краснопресненская", 13);
        widthGraph.addVertex("Курская", 14);
        widthGraph.addVertex("Новослободская", 15);
        widthGraph.addVertex("Октябрьская", 16);
        widthGraph.addVertex("Павелецкая", 17);
        widthGraph.addVertex("Парк Культуры", 18);
        widthGraph.addVertex("Проспект Мира", 19);
        widthGraph.addVertex("Таганская-кольцевая", 20);

        widthGraph.addEdge("Полежаевская", "Беговая");
        widthGraph.addEdge("Беговая", "Улица 1905 года");
        widthGraph.addEdge("Улица 1905 года", "Баррикадная");
        widthGraph.addEdge("Баррикадная", "Пушкинская");
        widthGraph.addEdge("Кузнецкий Мост", "Китай-город");
        widthGraph.addEdge("Таганская", "Пролетарская");

        widthGraph.addEdge("Белорусская", "Краснопресненская");
        widthGraph.addEdge("Краснопресненская", "Киевская");
        widthGraph.addEdge("Киевская", "Парк Культуры");
        widthGraph.addEdge("Парк Культуры", "Октябрьская");
        widthGraph.addEdge("Октябрьская", "Добрынинская");
        widthGraph.addEdge("Добрынинская", "Павелецкая");
        widthGraph.addEdge("Павелецкая", "Таганская-кольцевая");
        widthGraph.addEdge("Таганская-кольцевая", "Курская");
        widthGraph.addEdge("Курская", "Комсомольская");
        widthGraph.addEdge("Комсомольская", "Проспект Мира");
        widthGraph.addEdge("Проспект Мира", "Новослободская");
        widthGraph.addEdge("Новослободская", "Белорусская");

        widthGraph.addEdge("Краснопресненская", "Баррикадная");
        widthGraph.addEdge("Таганская", "Таганская-кольцевая");

        LinkedList trip = widthGraph.findShortestPath("Полежаевская", "Павелецкая");
        if (trip != null){
            for (int i = 0; i < trip.size(); i++) {
                System.out.print(trip.get(i) + " - ");
            }
            System.out.print("место назначения.");
        }
    }
}
