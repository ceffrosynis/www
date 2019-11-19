<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

html, body {
  height: 100%;
  margin: 0%;
}

body {
  margin: 0;
  background-image: url("back.jpg");
  background-position: center;
  background-repeat: no-repeat;
  background-position; fixed;
  background-size: cover;
  height: 100%;
}

.box {
    position: absolute;
    top: 50%;
}

.a {
    margin: 20px;
}


.flex-container {
  justify-content: center;
  display: flex;
  position: absolute;
  top: 50%;
}

.flex-container > a {
  text-decoration: none;
  background-color: #f1f1f1;
  margin: 10px;
  padding: 10px;
  font-size: 30px;
  opacity: 0.7;
  color: black;
}

.flex-container > a:hover {
  opacity: 1;
}

</style>
</head>
<body> 


<% if (session.getAttribute("username")==null) { %>
        <div class="flex-container">
            <a href="login.html" class="button">Login</a>
            <a href="register.html" class="button">Register</a>
        </div>
<% } else {%>
        <div class="flex-container">
            <a href="Profile" class="button">Profile Info</a>
            <a href="Logout" class="button">Logout</a>
        </div>
<% } %>

</body>
</html> 

