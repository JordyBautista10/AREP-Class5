package org.escuelaing;

import static java.lang.Math.*;
import static spark.Spark.port;
import static spark.Spark.get;
import static spark.Spark.*;

public class SparkWebServer {

    public static void main(String[] args){
        port(getPort());

        staticFileLocation( "public");

        get("cliente", (req,res) -> {
            res.type("text/html");
            return page();
        });

        get("sin", (req,res) -> {
            String path = req.contextPath();
            Float x = Float.parseFloat(req.queryParams("id"));
            res.type("text/html");
            return "Sin(" + x + ") = " + sin(x);
        });

        get("cos", (req,res) -> {
            String path = req.contextPath();
            Float x = Float.parseFloat(req.queryParams("id"));
            res.type("text/html");
            return "Cos(" + x + ") = " + cos(x);
        });

        get("palindromo", (req,res) -> {
            String palabra = req.queryParams("word");
            res.type("text/html");
            return palabra + " es palindromo: " + palindromo(palabra);
        });

        get("magnitud", (req,res) -> {
            Double x = Double.valueOf(req.queryParams("x"));
            Double y = Double.valueOf(req.queryParams("y"));
            res.type("text/html");
            return " La magnitud de (" + x + ", " + y +") es: " + sqrt( (x*x)  +(y*y));
        });

        after((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Request-Method", "GET, POST, PUT, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers", "Content-Type,Authorization");
        });

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    public static boolean palindromo(String word) {
        int left = 0;
        int right = word.length() - 1;

        word = word.toLowerCase();
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private static String page(){
        return "<html>\n" +
                "    <head>\n" +
                "        <title>Form Example</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>Sin</h1>\n" +
                "        <form action=\"/hello\">\n" +
                "            <label for=\"name\">Value:</label><br>\n" +
                "            <input type=\"number\" id=\"x\" name=\"name2\" value=\"1.570796325\"><br><br>\n" +
                "            <input type=\"button\" value=\"Submit\" onclick=\"loadGetMsgSin()\">\n" +
                "        </form> \n" +
                "        <div id=\"getrespmsg\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetMsgSin() {\n" +
                "                let nameVar = document.getElementById(\"x\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsg\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/sin?id=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "\n" +
                "        <h1>Cos</h1>\n" +
                "        <form action=\"/hello\">\n" +
                "            <label for=\"name\">Value:</label><br>\n" +
                "            <input type=\"text\" id=\"x2\" name=\"name2\" value=\"1.570796325\"><br><br>\n" +
                "            <input type=\"button\" value=\"Submit\" onclick=\"loadGetMsgCos()\">\n" +
                "        </form> \n" +
                "        <div id=\"getrespmsg1\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetMsgCos() {\n" +
                "                let nameVar = document.getElementById(\"x2\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsg1\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/cos?id=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "\n" +
                "        <h1>Determinar si la cadena es palíndromo</h1>\n" +
                "        <form action=\"/hello\">\n" +
                "            <label for=\"name\">Palabra:</label><br>\n" +
                "            <input type=\"text\" id=\"word\" name=\"name2\" value=\"kayak\"><br><br>\n" +
                "            <input type=\"button\" value=\"Submit\" onclick=\"loadGetMsgPali()\">\n" +
                "        </form> \n" +
                "        <div id=\"getrespmsg2\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetMsgPali() {\n" +
                "                let nameVar = document.getElementById(\"word\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsg2\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/palindromo?word=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "\n" +
                "        <h1>Magnitud de vector 2D</h1>\n" +
                "        <form action=\"/hello\">\n" +
                "            <label for=\"name\">X:</label><br>\n" +
                "            <input type=\"number\" id=\"x3\" name=\"name3\" value=\"kayak\"><br><br>\n" +
                "            <label for=\"name\">Y:</label><br>\n" +
                "            <input type=\"number\" id=\"y3\" name=\"name4\" value=\"kayak\"><br><br>\n" +
                "            <input type=\"button\" value=\"Submit\" onclick=\"loadGetMsgMagn()\">\n" +
                "        </form> \n" +
                "        <div id=\"getrespmsg3\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetMsgMagn() {\n" +
                "                let nameVar1 = document.getElementById(\"x3\").value;\n" +
                "                let nameVar2 = document.getElementById(\"y3\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsg3\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/magnitud?x=\"+nameVar1+\"&y=\"+nameVar2);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "    </body>\n" +
                "</html>";
    }

}
