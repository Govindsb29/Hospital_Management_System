<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Login</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--Hello World--%>
<%--</body>--%>
<%--</html>--%>


<!DOCTYPE html>
<html>
<head>
    <style>
        *
        {
            margin:0;
            padding:0;
        }
        .header
        {
            height:150px;
            width:100%;
            background-color:#0058e6;
            background:  linear-gradient(rgba(0,0,0,0.7),rgba(0,0,0,0.7)), url("css/images/breadcrumb-2.jpg");
        }
        .header p
        {
            font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
            text-align:center;
            color:#fff;
            padding-top:50px;
            font-size:50px;
        }
        .menu
        {
            padding-top:10px;
            box-sizing:border-box;
            background:#000;
            height:60px;

        }
        .menu>ul li
        {
            display:inline;
            margin-left:50px;
        }
        .menu>ul li a
        {
            text-decoration:none;
            color:#fff;
            font-size:30px;
        }
        .menu>ul li a:hover
        {
            color:red;
        }
        .left
        {
            height:auto;
            min-height:800px;
            background: rgb(64, 128, 128);
            width:20%;
            float:left;
        }
        .right
        {
            height:auto;
            min-height:600px;

            width:80%;
            float:left;
        }
        .fade-in-image
        {
            opacity:100%;
        }
        .fade-in-image:hover
        {
            opacity: 50%;
            transition: opacity 1s;
        }
        .footer
        {
            clear:both;
            height:100px;
            width:100%;
            background-color:#000;
        }
        marquee
        {
            background-color: red;
            font-size: large;
        }
        hos
        {
            margin-left:100px;
            height:100px;
            width:50%;
        }
    </style>
</head>
<body>
<div class="header">
    <p style="color: white"><b><u>SHARDA</u> <u>HOSPITAL</u></b></p>
</div>
<div class="menu">
    <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="About.html">About</a></li>
        <li><a href="Login.html">Login</a></li>
        <li><a href="index.jsp">Contact</a></li>
    </ul>
</div>

<marquee direction="right" scrollamaount="9">
    Hospital opens at 8 am and closes  at  12 pm.
</marquee>
<div class="left">
    &emsp;
    <u style="color: white;"><h2 style="color: white;" align="center"> Founder </h2></u>
    <br/>
    <img style="margin: 0 12px 0 13px; border: 2.5px black solid" src="css/images/photo.jpg" style="border: black 2px  outset;" height="375px" width="90%" >
    <br/>
    &emsp;
    <p style="color: white" align="center">Focusing on creating a hospital environment that prioritizes patient comfort, satisfaction,
        and overall positive healthcare experiences.
        Aiming to integrate traditional medicine with alternative or complementary therapies, focusing on the overall well-being of
        individuals beyond just the treatment of diseases.</p>
</div>
<div class="right">
    <div class="fade-in-image">
        &nbsp;<img src="css/images/hospital.jpg" class="hos" height="200px">
        <img src="css/images/hospital1.webp" height="200px">
        <img src ="css/images/hospital2.avif" height="200px" width="23%">
        <img src="css/images/hospital3.jpg" height="200px" width="25%">
    </div>
    </br>
    </br>
    <h2 align="center">Your Trusted Partner in Healthcare</h2>
    </br>
    <p align="center">
        At Sharda Hospital, we are committed to providing exceptional healthcare services with compassion, expertise, and cutting-edge
        technology. Your health and well-being are our top priorities, and we strive to create a healing environment that promotes a sense
        of comfort and trust.
    </p>
    </br>
    <h2 align="center">Our Commitment to Excellence</h2>
    </br>
    </br>
    <h4>&emsp;State-of-the-Art Facilities</h4>
    &emsp;Discover world-class facilities equipped with the latest medical technology, ensuring accurate diagnoses and effective treatments.
    </br></br>
    <h4>&emsp;Expert Medical Professionals</h4>
    &emsp;Meet our team of highly skilled and experienced healthcare professionals dedicated to delivering personalized care across a range of
    specialties.
    </br>
    </br>
    <h4>&emsp;Patient-Centered Care</h4>
    &emsp;Experience patient-centered care that focuses on your unique needs, preferences, and overall well-being. We believe in building lasting
    relationships with our patients and their families.
    </br>
    </p>
    </br>
    <h2 align="center">Services We Offer</h2>
    </br>
    <h3>&emsp;Specialized Departments</h3>
    </br>

    &emsp;<b>Cardiology:</b> Comprehensive heart care, from diagnostics to advanced interventions.</br>
    &emsp;<b>Orthopedics:</b> Expert care for bone and joint health, including surgeries and rehabilitation.</br>
    &emsp;<b>Women's Health:</b> Specialized services for women, from gynecology to maternity care.</br>
    &emsp;<b>Emergency Services:</b> 24/7 emergency care with a rapid response team.</br>
</div>
</body>
</html>