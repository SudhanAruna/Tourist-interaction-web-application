<%--
    Document   : index
    Created on : Jun 2, 2019, 8:59:41 PM
    Author     : sudhan
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" href="Styles/index-css.css">
        <style>

        </style>
     
    </head>
    <body>
      <div class="pageDiv">
          
        <div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="container">
            <img src="Images/bg-img-1.jpg" class="images-in-slide" style="height: auto; width: 100%;">
            
            
<!--            <div class="text-block">
                    <div id="container">
                        	  <div id="text"></div>
                                  <h2 id="text" style="color:black;"></h2>
                    </div>
                </div>    -->
            <div class="text-image-container">
                <!--<div class="test-container">-->
          
                <h2 class="text" id="text" style="color:black;
                    position:absolute;
                    right: 10%;
                    top: 10%;
                    font-size: 54px;
                    font-family: 'Raleway', sans-serif;
                    " > Names here</h2>
            <!--</div>-->
                    <br><br><br><br><br><br><br><br><br><br>
                    
                  <h1>Travel with culture and heritage</h1>
                  <p>
                      Visit attactive places with locals <br>
                      Experiance the taste of foods and life style
                  </p>
                  <div class="main-btn-container">
                  <br>
                  <br>
                  <br>
                  <a href="Signup-tourist.jsp"
                  <button class="tourist-signup-btn">Signup as Tourist</button>
                  </a>
                  <br>
                  <br>
                  <br>
                  <br>
                  <a href="Signup-business.jsp"
                  <button class="tourist-signup-btn">Signup as Business</button>
                  </a>
                  </div>
              </div>
                   <script type="text/javascript">
            
                    var _CONTENT = ["Ampara", "Anuradhapura","Badulla","Batticaloa","Colombo","Galle","Gampaha","Hambantota","Jaffna","Kalutara","Kandy","Kilinochchi","Kurunegala","Manner","Matale","Monaragala","Mullaitivu","Nuwara Eliya","Polonnaruwa","Puttalam","Ratnapura","Trincomalee","Vavuniya"];

                    var _PART = 0;
                    var _PART_INDEX = 0;

                    var _INTERVAL_VAL;

                    var _ELEMENT = document.querySelector("#text");

                    function Type() {
                      var text = _CONTENT[_PART].substring(0, _PART_INDEX + 1);
                      _ELEMENT.innerHTML = text;
                      _PART_INDEX++;

                      if (text === _CONTENT[_PART]) {
                        clearInterval(_INTERVAL_VAL);
                        setTimeout(function () {
                          _INTERVAL_VAL = setInterval(Delete, 50);
                        }, 1000);
                      }
                    }

                    function Delete() {
                      var text = _CONTENT[_PART].substring(0, _PART_INDEX - 1);
                      _ELEMENT.innerHTML = text;
                      _PART_INDEX--;

                      if (text === '') {
                        clearInterval(_INTERVAL_VAL);

                        if (_PART == (_CONTENT.length - 1))
                          _PART = 0;
                        else
                          _PART++;
                        _PART_INDEX = 0;

                        setTimeout(function () {
                          _INTERVAL_VAL = setInterval(Type, 100);
                        }, 200);
                      }
                    }

                    _INTERVAL_VAL = setInterval(Type, 100);
            </script>
        </div>
        <div class="footer">
        <%@include file="footer.jsp" %>
        </div>
      </div>
    </body>

</html>
