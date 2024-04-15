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
    
    .navbar-nav .nav-item.active #prd {
    height: 60px;
}


    
  </style>
  
  
   <script>
      
      function clicked()
      {
          
          
          var form = document.getElementById('products');
          var confirmation = window.confirm("Do you want to update product?");
          
          if(confirmation)
          {
              form.submit();
          }
          else
          {
              event.preventDefault();
          }
      }
      
      
  </script>
  
  
 
  
  
</head>

<body style="background-color:#e1f1fd">
  <br><br><br>
<div class="container-fluid">
    <br><br><br>

    <nav class="navbar navbar-expand-lg navbar-light fixed-top" style="background-color: transparent !important;">
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
          <input type="button" value="Products" id="prd" class="nvbtn" onclick="window.location.href='index.jsp'">
      </li>
      <li class="nav-item active">
        <form action="feedback">
          <input type="submit" value="Feedbacks" id="feed" class="nvbtn" />
        </form>
      </li>
      <li class="nav-item active">
        <input type="button" value="Other" class="nvbtn">
      </li>
      <li class="nav-item active">
        <input type="button" value="Web" class="nvbtn">
      </li>
    </ul>
  </div>
</nav>
    
     <%
      for(int i=0;i<3;i++)
      {
      out.println("hello\n");
  }
      
      %>
    
  
    <form  action="updateCard" method="POST" enctype="multipart/form-data" id="products">
      <center>
        <table>
          <tr>
            <th >Select Category :</th>
            <td id="1"><select id="crdNo" name="crdNo" >
                
                
               <%
              
              for(int i=0;i<3;i++)
              {
                    String id=(String) request.getAttribute("selectID"+i);
                    
                    
              
                    out.println("<option value="+i+">"+id+"</option>");
                
               }

              %>            
                
              </select></td>
          </tr>

          <tr>
            <th>Set card title :</th>
            <td id="2"><input type="text" name="Title" id="Title" placeholder="new title" ></td>
          </tr>

          <tr>
            <th>Set Price :</th>
            <td id="3"><input type="text" name="crdPrice" id="crdPrice" placeholder="new price" ></td>
          </tr>

          <tr>
            <th>Set Discription:</th>
            <td id="4"><textarea id="discript" name="discript" rows="4" cols="50" placeholder="new discription"
                ></textarea></td>
          </tr>

          <tr>
            <th>Select Card Image:</th>
            <td><input type="file" name="file1" ></td>
          </tr>

          <tr>

            <td colspan="2">
            <button type="reset" class="btn btn-warning">Clear</button>
            <button class="btn btn-success" onclick="clicked()" >Update</button>   </td>
          </tr>

        </table>

      </center>
    </form>

  </div>





  



  
  <script src="js/jquery-3.4.1.min.js"></script>

  
  
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap-4.4.1.js"></script>
</body>

</html>