<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
<div>
            <h3> Choose File to Upload in Server </h3>
            <form action="FileBrowse" method="post" enctype="multipart/form-data" >
                <input type="file" name="file" />
                  <input type="text" name="filename"  />  
                <!--<input type="hidden" name="filename1"> -->
                <input type="submit" value="upload" />
                <input type="text" name="majhifile">
            </form>          
        </div>
 <!-- enctype="multipart/form-data" -->
 
 
 <script type="text/javascript">
 $(document).ready(function(){
     $('input[type="file"]').change(function(e){
    	 const fileName = e.target.files[0].name;
         $("input[type=text] ").val(fileName);
         alert( fileName );
     });
 });

 </script>
</body>
</html>

  