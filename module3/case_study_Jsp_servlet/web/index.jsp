<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/17/2020
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>FURAMA RESORT</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link href='http://fonts.googleapis.com/css?family=Lobster+Two' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Arizonia' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
  <script src="https://kit.fontawesome.com/a076d05399.js"></script>
  <link rel="stylesheet" href="cssFile.css">
</head>
<body>
<!-- Header -->
<div style="position: fixed;z-index: 9;margin: 0 ;width: 100%">
  <nav class="navbar navbar-light" style="background-color: whitesmoke; height : 100px">
    <a class="navbar-brand" style="margin-left: 20px" href="#">
      <img src="https://furamavietnam.com/wp-content/uploads/2018/10/logo.png" width="65" height="80"
           class="d-inline-block align-top" alt="1">
    </a>
    <p class="header-text" >Furama, your second home</p>
    <form style="height : 80px" action="/account?action=logout" method="post">
      <p class="header-text-text" style="margin-right: 12px">Chairman: Lê Nguyễn Đình Phúc</p>
      <p class="header-text-text text-primary" style="margin-left: 140px">Log out <button class="btn btn-outline-success my-2 my-sm-0" style="margin-left: 5px">
        <i class="fas fa-sign-out-alt"></i></button></p>
    </form>
  </nav>
  <%--Header-link--%>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="/employees">Employee <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="/customers">Customer <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="/services">Service <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="/contracts">Contract <span class="sr-only">(current)</span></a>
        </li>
          <li class="nav-item active">
              <a class="nav-link" href="/contractDetails">Contract Detail<span class="sr-only">(current)</span></a>
          </li>
        <%--            <li class="nav-item">--%>
        <%--                <a class="nav-link" href="#">Link</a>--%>
        <%--            </li>--%>
        <%--            <li class="nav-item dropdown">--%>
        <%--                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
        <%--                    Dropdown--%>
        <%--                </a>--%>
        <%--                <div class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
        <%--                    <a class="dropdown-item" href="#">Action</a>--%>
        <%--                    <a class="dropdown-item" href="#">Another action</a>--%>
        <%--                    <div class="dropdown-divider"></div>--%>
        <%--                    <a class="dropdown-item" href="#">Something else here</a>--%>
        <%--                </div>--%>
        <%--            </li>--%>
        <%--            <li class="nav-item">--%>
        <%--                <a class="nav-link disabled" href="#">Disabled</a>--%>
        <%--            </li>--%>
      </ul>
      <form class="form-inline my-2 my-lg-0" action="https://www.google.com/search" method="get">
<%--        <input type="text" name="q" placeholder="Search">--%>
<%--        <input type="submit" value="Google">--%>
        <input class="form-control mr-sm-2" type="text" name="q" placeholder="Google Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Google"><i class="fas fa-search "
                style="font-size:24px;"></i></button>
      </form>
    </div>
  </nav>
</div>
<%--Body--%>
<div style="position: relative;top: 135px">
  <%--Body-left--%>
  <div class="card" style="width: 18rem;position: absolute;float: left">
    <%--    <img class="card-img-top" src="https://bazantravel.com/cdn/medias/uploads/53/53114-furama-resort-da-nang-11.jpg" alt="Card image cap">--%>
    <div id="myCarousel" class="carousel slide border" data-ride="carousel">
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img class="d-block w-100"
               src="https://luhanhvietnam.com.vn/du-lich-free-easy/vnt_upload/tour/08_2019/furama-nha-hang.jpg"
               alt="1">
        </div>
        <div class="carousel-item">
          <img class="d-block w-100"
               src="https://luhanhvietnam.com.vn/du-lich-free-easy/vnt_upload/tour/07_2019/phong-ngu-o-furama-resort-da-nang.jpg"
               alt="2">
        </div>
        <div class="carousel-item">
          <img class="d-block w-100"
               src="https://luhanhvietnam.com.vn/du-lich-free-easy/vnt_upload/tour/07_2019/phong-ngu-o-furama-resort-da-nang_1.jpg"
               alt="3">
        </div>
        <div class="carousel-item">
          <img class="d-block w-100"
               src="https://luhanhvietnam.com.vn/du-lich-free-easy/vnt_upload/tour/08_2019/furama-spa.jpg"
               alt="3">
        </div>
      </div>
    </div>
<%--    <div class="card-body">--%>
<%--      <h5 class="card-title">Furama Da Nang</h5>--%>
<%--      <p class="card-text">Furama Resort Đà Nẵng là resort 5 sao với những tiêu chuẩn dịch vụ tốt nhất cho du--%>
<%--        khách khi du lịch Đà Nẵng. Những căn phòng tiện nghi, hồ bơi rộng lớn, vị trí tuyệt vời nằm cạnh bãi--%>
<%--        biển và còn nhiều hơn nữa những điều thú vị chờ du khách phá.</p>--%>
<%--    </div>--%>
      <div id="myCarousel" class="carousel slide border" data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img class="d-block w-100"
                 src="https://furamavietnam.com/wp-content/uploads/2019/07/Vietnam_Danang_Furama_Resort_Exterior_Ocean-Pool-6.jpg"
                 alt="1">
          </div>
          <div class="carousel-item">
            <img class="d-block w-100"
                 src="https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior_Courtyard.jpg"
                 alt="2">
          </div>
          <div class="carousel-item">
            <img class="d-block w-100"
                 src="https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior-Furama-girl-with-pink-hat.jpg"
                 alt="3">
          </div>
          <div class="carousel-item">
            <img class="d-block w-100"
                 src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRF5uBBCpEQLYAZrFXeLFhsYGwPLCGeDczF2w&usqp=CAU"
                 alt="3">
          </div>
        </div>
      </div>
    <ul class="list-group list-group-flush">
      <li class="list-group-item">Cras justo odio</li>
      <li class="list-group-item">Dapibus ac facilisis in</li>
      <li class="list-group-item">Vestibulum at eros</li>
    </ul>
    <div class="card-body">
      <a href="https://www.facebook.com/furamaresort/" class="card-link"><i class="fab fa-facebook"></i></a>
      <a href="https://www.instagram.com/furama_resort_danang/?hl=vi" class="card-link"><i class="fab fa-instagram"></i></a>
    </div>
  </div>
  <%--Body right--%>
  <div class="card" style="width: 82%; margin-left: 18rem">
    <div class="card-body">
      <marquee class="body-text">
        Some beautiful scenes in Da Nang City and Furama resort welcome lady and gentlemen</marquee>
    </div>
    <div class="card-body-vids">
      <iframe style="margin-left: 167px" width="720" height="450" src="https://www.youtube.com/embed/IjlT_4mvd-c" frameborder="0" allow="autoplay; picture-in-picture" allowfullscreen></iframe>
    </div>
  </div>
  <%--Footer--%>
  <div class="card" style="margin-top: 25%">
    <div class="card-body" style="text-align: center">
      ©Create By Phúc Lee
    </div>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
