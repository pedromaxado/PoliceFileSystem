<%-- 
    Document   : miscreant-register
    Created on : Nov 11, 2014, 8:13:18 AM
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    </head>
    <body style="padding: 50px 0;">

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
                        <li class="active"><a href="mvc?logic=MiscreantRegister">Add Miscreant</a></li>
                        <li><a href="mvc?logic=MiscreantList">Full List</a></li>
                        <li><a href="mvc?logic=OutLawList">Outlaw List</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div><!--/.container-fluid -->
        </nav>

        <div class="container">
            <div class="row">
                <div class="col-sm-offset-1 col-md-offset-2 col-lg-offset-3 col-xs-12 col-sm-10 col-md-8 col-lg-6">
                    <h2 class="text-center">Miscreant Register</h2>
                    <form action="mvc" role="form">

                        <c:if test="${not empty isNew}">
                            <input type="hidden" name="logic" value="UpdateMiscreant">
                            <div class="form-group">
                                <label for="ID">ID</label>
                                <input type="number" class="form-control" id="ID" name="id" value="${mc.id}">
                            </div>
                        </c:if>
                        <c:if test="${empty isNew}">
                            <input type="hidden" name="logic" value="AddMiscreant">
                        </c:if>

                        <div class="form-group">
                            <label for="Name">Name</label>
                            <input type="text" class="form-control" id="Name" name="name" value="${mc.name}">
                        </div>
                        <div class="form-group">
                            <label for="CPF">CPF</label>
                            <input type="text" class="form-control" id="CPF" name="cpf" value="${mc.cpf}">
                        </div>
                        <div class="form-group">
                            <label for="Address">Address</label>
                            <input type="text" class="form-control" id="Address" name="addr" value="${mc.address}">
                        </div>
                        <div class="form-group">
                            <label for="Crime">Crime</label>
                            <input type="text" class="form-control" id="Crime" name="crime" value="${mc.crime}">
                        </div>
                        <div class="form-group">
                            <label for="CrimeLocation">Crime Location</label>
                            <input type="text" class="form-control" id="CrimeLocation" name="crimeLocation" value="${mc.crimeLocation}">
                        </div>
                        <div class="form-group">
                            <label for="CrimeDate">Crime Date</label>
                            <input type="date" class="form-control" id="CrimeDate" name="crimeDate" value="${mc.crimeDate}">
                        </div>
                        <div class="form-group">
                            <label for="CrimeTime">Crime Time</label>
                            <input type="time" class="form-control" id="CrimeTime" name="crimeTime" value="${mc.crimeTime}">
                        </div>
                        <div class="form-group">
                            <label for="State">State</label>
                            <select class="form-control" id="State" name="state" value="${mc.state}">
                                <option value="Preso">Preso</option>
                                <option value="Solto">Solto</option>
                                <option value="Foragido">Foragido</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="Picture">Picture</label>
                            <input type="text" class="form-control" id="Picture" name="picture" value="${mc.picture}">
                        </div>
                        
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>

    </body>
</html>
