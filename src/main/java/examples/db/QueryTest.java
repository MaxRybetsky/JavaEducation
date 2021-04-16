package examples.db;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QueryTest {
    private static final String allQuery = "SELECT Books.Price, Books.Title FROM Books";

    private static final String authorPublisherQuery = "SELECT Books.Price, Books.Title " +
            "FROM Books, BooksAuthors, Authors, Publisher " +
            "WHERE Authors.Author_Id = BooksAuthors.Author_id " +
            "AND BooksAuthors.ISBN = Books.ISBN " +
            "AND Books.Publisher_ID = Publisher.Publisher_ID " +
            "AND Authors.Name = ? AND Publisher.Name = ?";

    private static final String authorQuery = "SELECT Books.Price, Books.Title " +
            "FROM Books, BooksAuthors, Authors, Publisher " +
            "WHERE Authors.Author_Id = BooksAuthors.Author_id " +
            "AND BooksAuthors.ISBN = Books.ISBN " +
            "AND Books.Publisher_ID = Publisher.Publisher_ID " +
            "AND Authors.Name = ?";

    private static final String publisherQuery = "SELECT Books.Price, Books.Title " +
            "FROM Books, BooksAuthors, Authors, Publisher " +
            "WHERE Authors.Author_Id = BooksAuthors.Author_id " +
            "AND BooksAuthors.ISBN = Books.ISBN " +
            "AND Books.Publisher_ID = Publisher.Publisher_ID " +
            "AND Publisher.Name = ?";

    private static final String priceUpdate = "UPDATE Books " +
            "SET Price = Price + ? " +
            "WHERE Books.Publisher_id = " +
            "(SELECT Publisher_ID FROM Publisher WHERE Name = ?)";

    private static Scanner in;
    private static ArrayList<String> authors = new ArrayList<>();
    private static ArrayList<String> publishers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (Connection conn = ExecSQL.getConnection()) {
            in = new Scanner(System.in);
            authors.add("Any");
            publishers.add("Any");
            try (Statement stat = conn.createStatement()) {
                String query = "SELECT Name FROM Authors";
                try (ResultSet resultSet = stat.executeQuery(query)) {
                    while (resultSet.next()) {
                        authors.add(resultSet.getString(1));
                    }
                }
                query = "SELECT Name FROM Publisher";
                try (ResultSet resultSet = stat.executeQuery(query)) {
                    while (resultSet.next()) {
                        publishers.add(resultSet.getString(1));
                    }
                }
            }
            while (true) {
                System.out.print("Q)ery C)hange prices E)xit:");
                String input = in.next().toUpperCase();
                if ("Q".equals(input)) {
                    executeQuery(conn);
                } else if ("C".equals(input)) {
                    changePrices(conn);
                } else {
                    return;
                }
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                System.out.println(t.getMessage());
            }
        }
    }

    public static void changePrices(Connection conn) throws SQLException {
        String publisher = select("Publishers: ", publishers.subList(1, publishers.size()));
        System.out.println("Change prices by: ");
        double priceChange = Double.parseDouble(in.next());
        PreparedStatement stat = conn.prepareStatement(priceUpdate);
        stat.setDouble(1, priceChange);
        stat.setString(2, publisher);
        int r = stat.executeUpdate();
        System.out.println(r + " records updated.");
    }

    private static void executeQuery(Connection conn) throws SQLException {
        String author = select("Authors: ", authors);
        String publisher = select("Publishers: ", publishers);
        PreparedStatement stat;
        if (!"Any".equals(author) && !"Any".equals(publisher)) {
            stat = conn.prepareStatement(authorPublisherQuery);
            stat.setString(1, author);
            stat.setString(2, publisher);
        } else if (!"Any".equals(author)) {
            stat = conn.prepareStatement(authorQuery);
            stat.setString(1, author);
        } else if (!"Any".equals(publisher)) {
            stat = conn.prepareStatement(publisherQuery);
            stat.setString(1, publisher);
        } else {
            stat = conn.prepareStatement(allQuery);
        }
        try (ResultSet resultSet = stat.executeQuery()) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1)
                        + ", "
                        + resultSet.getString(2));
            }
        }
    }

    private static String select(String prompt, List<String> options) {
        while (true) {
            System.out.println(prompt);
            for (int i = 0; i < options.size(); i++) {
                System.out.printf("%2d) %s%n", i + 1, options.get(i));
            }
            int sel = in.nextInt();
            if (sel > 0 && sel <= options.size()) {
                return options.get(sel - 1);
            }
        }
    }
}
