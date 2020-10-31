module Java11 {
    requires org.json;
    requires java.net.http;
    requires javafx.fxml;
    requires javafx.controls;
    requires sqlite.jdbc;

    opens br.desafio;
}