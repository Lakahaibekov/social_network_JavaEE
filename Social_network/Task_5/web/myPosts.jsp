<%@ page import="java.util.ArrayList" %>
<%@ page import="DB.Posts" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Posts page</title>
    <%@include file="includes/head.jsp" %>
    <link rel="stylesheet" href="/vendor/css/style.css">

    <script src="/vendor/tinymce/tinymce.min.js"></script>
    <script>tinymce.init({ selector:'textarea' });</script>

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
                Post added succesfully
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true"></span>
                </button>
            </div>
            <%
                }
            %>
            <%
                String error = request.getParameter("error");
                if (error!=null){;
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Post doesn't added
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true"></span>
                </button>
            </div>
            <%
                }
            %>

            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ADD">Add new</button>

            <div class="modal fade" id="ADD" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel1"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel1">Add New Post</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="/addpost" method="post">
                                <div class="form-group">
                                    <label class="col-form-label">TITLE:</label>
                                    <input type="text" class="form-control" name="title" required>
                                </div>
                                <div class="form-group">
                                    <label class="col-form-label">SHORT CONTENT:</label>
                                    <textarea name="short_content"></textarea>
                                </div>
                                <div class="form-group">
                                    <label class="col-form-label">CONTENT:</label>
                                    <textarea name="content"></textarea>
                                </div>
                                <div class="form-group">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-success float-right">Add League</button>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                        </div>
                    </div>
                </div>
            </div>

            <%
                ArrayList<Posts> posts = (ArrayList<Posts>)request.getAttribute("posts");
                if(posts != null){
                    for(Posts p : posts){
            %>


            <div class="card" style="margin-top: 20px">
                <div class="card-body">
                    <h5 class="card-title"><%=p.getTitle()%></h5>
                    <p class="card-text"><%=p.getShort_content()%></p>
                    <a href="/postdetails?post_id=<%=p.getId()%>" class="btn btn-primary">More --></a>
                </div>
                <div class="card-footer">
                    <p>Posted by <%=p.getAuthod_id().getFull_name()%> at <%=p.getPost_date()%></p>
                </div>
            </div>

            <%
                }
                }
            %>

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
