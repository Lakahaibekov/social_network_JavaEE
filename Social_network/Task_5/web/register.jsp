<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<div class ="container">
    <div class="row mt-5">
        <div class="col-md-6 offset-3">
            <h4 style="text-align: center">
                Create new Account
            </h4>
            <%
                String success = request.getParameter("success");
                if (success!=null){;
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                User added succesfully
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true"></span>
                </button>

            </div>
            <%
                }
            %>
            <%
                String passError = request.getParameter("passworderror");
                if (passError!=null){;
            %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    Password are not same
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true"></span>
                    </button>

                </div>
            <%
                }
            %>
            <%
                String emailError = request.getParameter("emailerror");
                if (emailError!=null){;
            %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    Email exists
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true"></span>
                    </button>

                </div>
            <%
                }
            %>
            <form action="/toregister" method="post">
                <div class="form-group">
                    <label>Email address : </label>
                    <input type="email" required class="form-control" name="email">
                </div>
                <div class="form-group">
                    <label>Password : </label>
                    <input type="password" required class="form-control" name="password">
                </div>
                <div class="form-group">
                    <label>Re-Password : </label>
                    <input type="password" required class="form-control" name="re_password">
                </div>
                <div class="form-group">
                    <label>Full Name : </label>
                    <input type="text" required class="form-control" name="full_name">
                </div>
                <div class="form-group">
                    <label>Birthdate : </label>
                    <input type="date" required class="form-control" name="birthdate">
                </div>
                <div class="form-group">
                    <label>Picture url : </label>
                    <input type="text" required class="form-control" name="picture_url">
                </div>
                <div class="form-group">
                    <button class="btn btn-success">Sign In</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!--<footer>
    <div style="color: white; padding: 15px; text-align: center; background-color: black">
        <p>Copyright @ aralasu.kz 2020 </p>
    </div>
</footer>-->
</body>
</html>
