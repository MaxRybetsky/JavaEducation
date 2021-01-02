package server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.commons.lang.StringEscapeUtils;

import java.io.IOException;
import java.io.OutputStream;

public class MyHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestParamValue = null;
        if ("GET".equals(exchange.getRequestMethod())) {
            requestParamValue = handleGetRequest(exchange);
        } else if ("POST".equals(exchange.getRequestMethod())) {
            requestParamValue = handlePostRequest(exchange);
        }
        handleResponse(exchange, requestParamValue);
    }

    private void handleResponse(HttpExchange exchange, String requestParamValue) throws IOException {
        OutputStream outputStream = exchange.getResponseBody();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html>")
                .append("<body>")
                .append("<h1>")
                .append("Hello ")
                .append(requestParamValue)
                .append("</h1>")
                .append("</body>")
                .append("</html>");
        String htmlResponse = StringEscapeUtils.escapeHtml(htmlBuilder.toString());
        exchange.sendResponseHeaders(200, htmlResponse.length());
        outputStream.write(htmlResponse.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    private String handlePostRequest(HttpExchange exchange) {
        return null;
    }

    private String handleGetRequest(HttpExchange exchange) {
        return exchange.getRequestURI()
                .toString()
                .split("\\?")[1]
                .split("=")[1];
    }


}
