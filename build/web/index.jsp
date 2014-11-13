<%-- 
    Document   : index
    Created on : Nov 11, 2014, 7:49:57 AM
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    </head>

    <body style="padding-top: 70px;">

        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="./">Delegation</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="mvc?logic=MiscreantRegister">Add Miscreant</a></li>
                        <li><a href="mvc?logic=MiscreantList">Full List</a></li>
                        <li><a href="mvc?logic=OutLawList">Outlaw List</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div><!--/.container-fluid -->
        </nav>

        <div class="container">

            <div class="jumbotron">
                <h1>Calangolandia Delegation</h1>
                <p>Miscreant registering section</p>
                <p>
                    <a class="btn btn-lg btn-primary" href="MiscreantRegister.jsp" role="button">Register</a>
                </p>
            </div>

        </div>

        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>

    </body>
</html>
