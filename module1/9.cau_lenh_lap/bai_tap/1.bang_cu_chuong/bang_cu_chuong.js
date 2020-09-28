
document.write("<table border=1 width=100%>")
for (i = 1; i < 10; i++){
    document.write("<tr>")
    for (j = 2; j < 10; j++ ){
            document.write("<td>" + j + "x" + i + "=" + (j*i) );
        document.write("</td>");
    }
    document.write("</tr>");
}
document.write("</tr></table>");

