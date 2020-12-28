<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/23/2020
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Contract Detail Management Application</title>
</head>
<body>
<center>
    <h1>Contract Detail Management</h1>
    <h2>
        <a href="/contractDetails?action=contracts">List All Contracts Detail</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Contract Detail</h2>
            </caption>
            <tr>
                <th>Contract Id:</th>
                <td>
                    <input type="text" name="contract_id" id="contract_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Attach Service Id:</th>
                <td>
                    <input type="text" name="attach_service_id" id="attach_service_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="text" name="quantity" id="quantity" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
