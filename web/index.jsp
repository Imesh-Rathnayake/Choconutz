<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Untitled Document</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap-4.4.1.css" rel="stylesheet">
        <link href="admin1.css" rel="stylesheet" type="text/css">



        <style>


            .align-begin {
                text-align:left;
            }

            .colour-blue{
                color:blue;


            }

            .colour-red{
                color: red;
            }

            .align-end {
                text-align:right;
            }

            .navbar-nav .nav-item.active #dashboard {
                height: 60px;
            }

            .card {
                width: 350px;
                height: 200px;
                background: rgba(255, 255, 255, 0.5);
                border-radius: 10px;

                margin-bottom: 20px;
                padding: 10px;
                flex-wrap: wrap;
            }

            .shadow {
                box-shadow: inset 0 -3em 3em rgba(0,0,0,0.1),
                    0 0  0 2px rgb(190, 190, 190),
                    0.3em 0.3em 1em rgba(0,0,0,0.3);
            }

            .container {
                display: flex;
                flex-wrap: wrap;
                justify-content:center;
                gap: 30px;/* Distribute items evenly along the row */
            }
            .nvbtn {
                color: #4B3C3C;
                background-image: -webkit-linear-gradient(270deg,rgba(198,248,248,1.00) 0%,rgba(141,152,224,1.00) 100%);
                background-image: -moz-linear-gradient(270deg,rgba(198,248,248,1.00) 0%,rgba(141,152,224,1.00) 100%);
                background-image: -o-linear-gradient(270deg,rgba(198,248,248,1.00) 0%,rgba(141,152,224,1.00) 100%);
                background-image: linear-gradient(180deg,rgba(198,248,248,1.00) 0%,rgba(141,152,224,1.00) 100%);
                border-style: none;
                margin-left: 7px;
                margin-right: 7px;
                width: 100px;
                height: 40px;
                margin-top: 25px;
                border-top-right-radius: 15px;
            }




        </style>


        <script>

            function clicked()
            {


                var form = document.getElementById('products');
                var confirmation = window.confirm("Do you want to update product?");

                if (confirmation)
                {
                    form.submit();
                } else
                {
                    event.preventDefault();
                }
            }


        </script>





    </head>

    <body style="background-color:#e1f1fd">

        <div class="container-fluid">


            <nav class="navbar navbar-expand-lg navbar-light" style="background-color: transparent !important;">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent3"
                        aria-controls="navbarSupportedContent3" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-center align-items-center" id="navbarSupportedContent3">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <form action="Manage_Orders">
                                <input type="submit" value="Orders" id="hm" class="nvbtn" />
                            </form>
                        </li>
                        <li class="nav-item active">
                            <input type="button" value="Products" id="prd" class="nvbtn" onclick="window.location.href = 'index.jsp'">
                        </li>
                        <li class="nav-item active">
                            <form action="feedback">
                                <input type="submit" value="Feedbacks" id="feed" class="nvbtn" />
                            </form>
                        </li>
                        <li class="nav-item active">
                            <input type="button" value="Other"  class="nvbtn">
                        </li>
                        <li class="nav-item active">
                            <input type="button" value="Dashboard" id="dashboard" class="nvbtn">
                        </li>
                    </ul>
                </div>
            </nav><br><br>


            <div class="container">

<!--                total pendings-->

                <div class="card shadow">
                    <br>
                    <center>
                        
                        <h4 style="margin-top:15px;">$130/-</h4>
                        
                        <span style="margin-bottom:15px; margin-top:15px;   display: inline-block;  padding: 10px; width: 320px;" class="alert alert-info">Total Pendings</span>
                        <br>
                        <input type="submit" value="See Orders" style="margin-bottom:20px; display: inline-block; padding: 10px; width: 320px;" class="btn btn-outline-info" />
                        
                    </center>
                </div>

<!--                completed orders-->
                
                <div class="card shadow">
                    <br>
                    <center>
                        
                        <h4 style="margin-top:15px;">$30/-</h4>
                        
                        <span style="margin-bottom:15px; margin-top:15px;   display: inline-block;  padding: 10px; width: 320px;" class="alert alert-info">Completed Orders</span>
                        <br>
                        <input type="submit" value="See Orders" style="margin-bottom:20px; display: inline-block; padding: 10px; width: 320px;" class="btn btn-outline-info" />
                        
                    </center>
                </div>

<!--                placed orders-->
                
                <div class="card shadow">
                    <br>
                    <center>
                        
                        <h4 style="margin-top:15px;">3</h4>
                        
                        <span style="margin-bottom:15px; margin-top:15px;   display: inline-block;  padding: 10px; width: 320px;" class="alert alert-info">Orders Placed</span>
                        <br>
                        <input type="submit" value="See Orders" style="margin-bottom:20px; display: inline-block; padding: 10px; width: 320px;" class="btn btn-outline-info" />
                        
                    </center>
                </div>
                
<!--                products added-->

                <div class="card shadow">
                    <br>
                    <center>
                        
                        <h4 style="margin-top:15px;">3</h4>
                        
                        <span style="margin-bottom:15px; margin-top:15px;   display: inline-block;  padding: 10px; width: 320px;" class="alert alert-info">Products Added</span>
                        <br>
                        <input type="submit" value="See Products" style="margin-bottom:20px; display: inline-block; padding: 10px; width: 320px;" class="btn btn-outline-info" />
                        
                    </center>
                </div>

<!--                total users-->
                
                <div class="card shadow">
                    <br>
                    <center>
                        
                        <h4 style="margin-top:15px;">10</h4>
                        
                        <span style="margin-bottom:15px; margin-top:15px;   display: inline-block;  padding: 10px; width: 320px;" class="alert alert-info">Total Users</span>
                        <br>
                        <input type="submit" value="See Accounts" style="margin-bottom:20px; display: inline-block; padding: 10px; width: 320px;" class="btn btn-outline-info" />
                        
                    </center>
                </div>

<!--                total admins-->
                
                <div class="card shadow">
                    <br>
                    <center>
                        
                        <h4 style="margin-top:15px;">1</h4>
                        
                        <span style="margin-bottom:15px; margin-top:15px;   display: inline-block;  padding: 10px; width: 320px;" class="alert alert-info">Total Admins</span>
                        <br>
                        <input type="submit" value="See Accounts" style="margin-bottom:20px; display: inline-block; padding: 10px; width: 320px;" class="btn btn-outline-info" />
                        
                    </center>
                </div>

            </div>




        </div>









        <script src="js/jquery-3.4.1.min.js"></script>



        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap-4.4.1.js"></script>
    </body>

</html>