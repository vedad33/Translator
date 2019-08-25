<%-- 
    Document   : index
    Created on : Jun 29, 2019, 8:15:58 PM
    Author     : Vedo
--%>

 <%@page contentType="text/html" pageEncoding="UTF-8"%>  
  <!DOCTYPE html>  
  <html>  
    <head>  
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
      <title>Translator index page</title>  
      <script type="text/javascript">  
        function go() {  
          url = 'http://localhost:8080/TranslatorAssingment/rest/TranslatorService/' + document.getElementById("word").value;  
          window.open(url, '_blank');  
        }  
      </script>  
    </head>  
    <body>  
      <h1>Hello Translator!</h1>  
      <br/>  
      <h2>English-Bosnian</h2>
      <form>  
        Your word:  
        <input type="text" name="word" id="word"/>  
      </form>  
      <button onclick="go()">Translate</button> 
      <h2>Bosnian - English</h2>
      <form>  
        Unijeti rijec:  
        <input type="text" name="word" id="word"/>  
      </form>  
      <button onclick="go()">Prevedi</button>  
    </body>  
  </html>  