package examples.types;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App2 {
    public static void main(String[] args) {
        StringBuilder query = new StringBuilder();
        query.append("insert into ")
                .append("tableName")
                .append("(item_id, name) values (")
                .append("item.getId()")
                .append(",")
                .append("item.getName()")
                .append(")");
        if (true) {
            StringBuilder creating = new StringBuilder();
            creating.append("create table ")
                    .append("tableName")
                    .append(";");
            query.insert(0, creating);
        }
        System.out.println(query);
    }
}
