<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
    <%@include file="includes/head.jsp" %>
    <link rel="stylesheet" href="/vendor/css/style.css">
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<div class="container">
    <div class="row ">
        <div class="col-3">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRLxuEp2RMcROGdzfQTVqjFJx_O1gsAp_92_w&usqp=CAU" class="card-img-top" alt="..." height="250 px">
            <div class="card">
                <div class="card-body">
                    <%
                        int age = 2020 - Integer.parseInt(currentUser.getBirth_date().substring(0,4));
                    %>
                    <h5 class="card-title"><%=currentUser.getFull_name()%> <br> <%=age%> years</h5>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><a href="/profile">My Profile</a></li>
                    <li class="list-group-item">Settings</li>
                    <li class="list-group-item"><a href="/logout">logout</a></li>
                </ul>
            </div>
        </div>
        <div class="col-6">
            <%
                String success = request.getParameter("success");
                if (success!=null){;
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                User update succesfully
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true"></span>
                </button>
            </div>
            <%
                }
            %>
            <%
                String newPassError = request.getParameter("newpasserror");
                if (newPassError!=null){;
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                New password are not same
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true"></span>
                </button>
            </div>
            <%
                }
            %>
            <%
                String oldPassError = request.getParameter("oldpasserror");
                if (oldPassError!=null){;
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Old password doesn't same
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true"></span>
                </button>
            </div>
            <%
                }
            %>
            <h4>
                EDIT PROFILE
            </h4>
            <form action="/updateprofile" method="post">
                <div class="form-group">
                    <label>Email address : </label>
                    <input type="email" class="form-control" value="<%=currentUser.getEmail()%>" name="email" readonly>
                </div>
                <div class="form-group">
                    <label>Full Name : </label>
                    <input type="text" class="form-control" value="<%=currentUser.getFull_name()%>" name="full_name">
                </div>
                <div class="form-group">
                    <label>Birthdate : </label>
                    <input class="form-control" type="date" value="<%=currentUser.getBirth_date()%>" name="birthdate">
                </div>
                <div class="form-group">
                    <button class="btn btn-success">Update PROFILE</button>
                </div>
            </form>
            <hr>
            <h4>
                EDIT PICTURE
            </h4>
            <form action="/updateurl" method="post">
                <div class="form-group">
                    <label>Picture url : </label>
                    <input type="text" required class="form-control" value="<%=currentUser.getPicture_url()%>" name="picture_url">
                </div>
                <div class="form-group">
                    <button class="btn btn-success">Update URL</button>
                </div>
            </form>
            <hr>
            <h4>
                UPDATE PASSWORD
            </h4>
            <form action="/updatepassword" method="post">
                <div class="form-group">
                    <label>Old Password : </label>
                    <input type="password" required class="form-control" name="old_password">
                </div>
                <div class="form-group">
                    <label>New Password : </label>
                    <input type="password" required class="form-control" name="new_password">
                </div>
                <div class="form-group">
                    <label>Re-New Password : </label>
                    <input type="password" required class="form-control" name="re_new_password">
                </div>
                <div class="form-group">
                    <button class="btn btn-success">Update Password</button>
                </div>
            </form>
        </div>
        <div class="col-3">
            <div class="card text-white bg-info mb-3">
                <div class="card-header">Latest birthdays</div>
                <div class="card-body">
                    <h6 class="card-title">Musa Uatbayev, tomorrow</h6>
                    <h6 class="card-title">Azamat Tolegenov, 02 October</h6>
                    <h6 class="card-title">Yerik Utemuratov, 05 October</h6>
                    <h6 class="card-title">Aybek Bagit, 10 October</h6>
                </div>
            </div>
            <div class="card text-white bg-info mb-3">
                <div class="card-header">My Games</div>
                <div class="card-body">
                    <h6 class="card-title">FOOTBALL ONLINE</h6>
                    <h6 class="card-title">PING PONG ONLINE</h6>
                    <h6 class="card-title">CHESS MASERS</h6>
                    <h6 class="card-title">RACES ONLINE</h6>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
