<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Untitled Document</title>
  <!-- Bootstrap -->
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
            <a id="hm" class="nav-link" href="orders.jsp">Orders<span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="index.html" style="color: blue;"><b>Products</b><span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="order.html">Customers<span class="sr-only">(current)</span></a>
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
    <form  action="updateCard" method="POST" enctype="multipart/form-data">
      <center>
        <table border="1">
          <tr>
            <th>Select Card No :</th>
            <td><select id="crdNo" name="crdNo" >
                <option value="0">Select Card</option>
                <option value="1">Card 01</option>
                <option value="2">Card 02</option>
                <option value="3">Card 03</option>
                <option value="4">Card 04</option>
                <option value="5">Card 05</option>
                <option value="6">Card 06</option>
              </select></td>
          </tr>

          <tr>
            <th>Set card title :</th>
            <td><input type="text" name="Title" id="Title" placeholder="new title" ></td>
          </tr>

          <tr>
            <th>Set Price :</th>
            <td><input type="text" name="crdPrice" id="crdPrice" placeholder="new price" ></td>
          </tr>

          <tr>
            <th>Set Discription:</th>
            <td><textarea id="discript" name="discript" rows="4" cols="50" placeholder="new discription"
                ></textarea></td>
          </tr>

          <tr>
            <th>Select Card Image:</th>
            <td><input type="file" name="file1" ></td>
          </tr>

          <tr>

            <td colspan="2"><input type="reset" name="clear" id="clear" value="Clear" class="btn-primary"
                style="width: 70px;">&nbsp;&nbsp;<input type="submit" name="setTitle" id="setTitle" value="Update"
                class="btn-primary" style="width: 70px;"></td>
          </tr>

        </table>

      </center>
    </form>

  </div>





  <!-- body code goes here -->



  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="js/jquery-3.4.1.min.js"></script>

  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap-4.4.1.js"></script>
</body>

</html>