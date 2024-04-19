<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Untitled Document</title>

        <link href="css/bootstrap-4.4.1.css" rel="stylesheet">
        <link href="admin.css" rel="stylesheet" type="text/css">

        <style>
            td {
                border: 1px solid black;
                padding: 8px;
                text-align: right;

            }

            th {
                border: 1px solid black;
                padding: 8px;


            }

            .align-end {
                text-align: right;
            }
        </style>
    </head>

    <body>

        <div class="container-fluid">


            <nav class="navbar navbar-expand-lg navbar-light navbar fixed-top">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent3"
                        aria-controls="navbarSupportedContent3" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-center align-items-center" id="navbarSupportedContent3">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a id="hm" class="nav-link" href="orders.jsp" style="color: blue;"><b>Orders</b><span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="index.jsp" >Products<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="orders.jsp">Customers<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Other<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="signAdmin.html">Web<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">Language</a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown1">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>


            <br><br><br><br>


        </div>






        <!-- body code goes here -->



        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery-3.4.1.min.js"></script>

        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap-4.4.1.js"></script>
    </body>

</html>






//table of manage orders





out.println("<table align=\"center\" border=\"1\">");
            out.println("<tr><th><center>Product</center></th><th><center>Quantity</center></th><th><center>Price</center></th><th><center>Customer</center></th><th><center>Address</center></th><th><center>Email</center></th><th><center>Payment method</center></th><th><center>Order Status</center></th><th><center>Action</center></th></tr>");
            
            while (result.next()) {
                
                out.println("<tr>");
                
                out.println("<td><center>" + result.getString("name") + "</center></td>");
                out.println("<td><center>" + result.getInt("quantity") + "</td>");
                out.println("<td><center>" + result.getBigDecimal("total_price") + "</center></td>");
                out.println("<td><center>" + result.getString("username") + "</td>");
                out.println("<td><center>" + result.getString("shipping_address") + "</center></td>");
                out.println("<td><center>" + result.getString("email") + "</center></td>");
                out.println("<td><center>" + result.getString("payment_method") + "</center></td>");
                out.println("<td><center>" + result.getString("order_status") + "</center></td>");
                out.println("<td><form method='POST' id='delete_order' action='Complete_Order'><input type='hidden' name='record_id' value='" + result.getInt("id") + "'><input type='button' value='C' title='complete order' onclick=\"clicked()\" class=\"btn btn-danger\"></form></td>");
                out.println("</tr>");
                
                
                
                
            }

            out.println("</table>");