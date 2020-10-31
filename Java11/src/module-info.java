module Java11 {
    requires java.net.http;
    requires javafx.fxml;
    requires javafx.controls;
    requires org.json;
    requires sqlite.jdbc;

    opens br.desafio;
}