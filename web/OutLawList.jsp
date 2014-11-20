<%-- 
    Document   : OutLawList
    Created on : Nov 13, 2014, 8:36:00 AM
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    </head>
    <body style="padding-top: 50px;">
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
                        <li ><a href="mvc?logic=MiscreantList">Full List</a></li>
                        <li class="active"><a href="mvc?logic=OutLawList">Outlaw List</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">

            <div class="row">

                <div class="col-xs-12">
                    <h2 class="text-center">Miscreant List</h2>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <td>Picture</td>
                                    <td>ID</td>
                                    <td>Name</td>
                                    <td>CPF</td>
                                    <td>Address</td>
                                    <td>Crime</td>
                                    <td>Crime Date</td>
                                    <td>Crime Time</td>
                                    <td>Crime Location</td>
                                    <td>State</td>
                                    <td>Alter</td>
                                    <td>Remove</td>
                                </tr>
                            </thead>

                            <c:forEach var="mc" items="${mclist}">

                                <tr>
                                    <td><img class="img-thumbnail" src="${mc.picture}" style="max-height: 150px;" /></td>
                                    <td>${mc.id}</td>
                                    <td>${mc.name}</td>
                                    <td>${mc.cpf}</td>
                                    <td>${mc.address}</td>
                                    <td>${mc.crime}</td>
                                    <td>${mc.crimeDate}</td>
                                    <td>${mc.crimeTime}</td>
                                    <td>${mc.crimeLocation}</td>
                                    <td>${mc.state}</td>
                                    <td><a class="btn btn-primary center-block" href="mvc?logic=AlterMiscreant&id=${mc.id}">Alter</a></td>
                                    <td><a class="btn btn-danger center-block" href="mvc?logic=RemoveMiscreant&id=${mc.id}">Remover</a></td>
                                </tr>

                            </c:forEach>

                        </table>
                    </div>
                </div>

            </div>

        </div>
    </body>
</html>
