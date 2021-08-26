<%@include file="user.jsp"%>
 <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #180B7A; margin-bottom: 15px">
    <a class="navbar-brand" href="/" style="color: white;"><strong>ARALASU KZ</strong></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="nav justify-content-end">
            <%
                if (ONLINE) {
            %>
                <li class="nav-item">
                    <a class="nav-link" href="/home" style="color: white;">Feed</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/" style="color: white;">My Friends</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/" style="color: white;">Groups</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/myposts" style="color: white;">My Posts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/" style="color: white;">Pictures</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/" style="color: white;">Videoes</a>
                </li>
            <%
                }else{
            %>
                <li class="nav-item">
                    <a class="nav-link" href="/register" style="color: white;">Register</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login" style="color: white;">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/" style="color: white;">FAQ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/" style="color: white;">About Aralasu</a>
                </li>
            <%
                }
            %>
        </ul>
    </div>
</nav>