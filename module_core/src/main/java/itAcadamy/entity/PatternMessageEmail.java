package itAcadamy.entity;

import lombok.Data;

@Data
public class PatternMessageEmail {
    private OrderHotel orderHotel;
    private String message;

    public PatternMessageEmail(OrderHotel orderHotel) {
        this.orderHotel = orderHotel;
        createMessage();
    }

    private void createMessage() {
        message = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "  <title>Оплата заказа</title>\n" +
                "  <style>\n" +
                "    body {\n" +
                "      font-family: Arial, sans-serif;\n" +
                "      background-color: #f5f5f5;\n" +
                "      color: #333;\n" +
                "    }\n" +
                "    .container {\n" +
                "      max-width: 600px;\n" +
                "      margin: 0 auto;\n" +
                "      padding: 20px;\n" +
                "      background-color: #fff;\n" +
                "      border: 1px solid #ccc;\n" +
                "      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
                "    }\n" +
                "    .header {\n" +
                "      text-align: center;\n" +
                "      margin-bottom: 20px;\n" +
                "    }\n" +
                "    .message {\n" +
                "      margin-bottom: 20px;\n" +
                "    }\n" +
                "    .order-details {\n" +
                "      border-collapse: collapse;\n" +
                "      width: 100%;\n" +
                "      margin-bottom: 20px;\n" +
                "    }\n" +
                "    .order-details th,\n" +
                "    .order-details td {\n" +
                "      padding: 10px;\n" +
                "      text-align: left;\n" +
                "      border-bottom: 1px solid #ccc;\n" +
                "    }\n" +
                "    .order-total {\n" +
                "      text-align: right;\n" +
                "      font-weight: bold;\n" +
                "    }\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <div class=\"container\">\n" +
                "    <div class=\"header\">\n" +
                "      <h1>Оплата заказа</h1>\n" +
                "    </div>\n" +
                "    <div class=\"message\">\n" +
                "      <p>Уважаемый " + orderHotel.getClient().getName() + "</p>\n" +
                "      <p>Мы рады сообщить вам, что ваш текущий заказ был успешно оплачен.</p>\n" +
                "    </div>\n" +
                "    <table class=\"order-details\">\n" +
                "      <thead>\n" +
                "        <tr>\n" +
                "          <th>Идентификатор заказа</th>\n" +
                "          <th>Цена</th>\n" +
                "        </tr>\n" +
                "      </thead>\n" +
                "      <tbody>\n" +
                "        <tr>\n" +
                "          <td>" + orderHotel.getId() + "</td>\n" +
                "          <td>" + orderHotel.getPrice() + "</td>\n" +
                "        </tr>\n" +
                "      </tbody>\n" +
                "      <tfoot>\n" +
                "        <tr>\n" +
                "          <td colspan=\"3\" class=\"order-total\">Итого:</td>\n" +
                "          <td class=\"order-total\">" + orderHotel.getPrice() + "</td>\n" +
                "        </tr>\n" +
                "      </tfoot>\n" +
                "    </table>\n" +
                "  </div>\n" +
                "</body>\n" +
                "</html>";
    }
}
