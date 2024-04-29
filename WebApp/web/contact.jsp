<%@ include file="jsp/header.jsp"%>




<section class="contact">

   <h1 class="title_contact">get in touch</h1>

   <form action="" method="POST" class="contact-form">
      <input type="text" name="name" class="box_contact" required placeholder="Name">
      <input type="email" name="email" class="box_contact" required placeholder="Email">
      <input type="tel" name="number" min="0" class="box_contact" required placeholder="Phone">
      <textarea name="msg" class="box_contact" required placeholder="TELL US..." cols="30" rows="10"></textarea>
      <input type="submit" value="send message" class="btn_contact" name="send">
   </form>

</section>










<%@ include file="jsp/footer.jsp"%>
