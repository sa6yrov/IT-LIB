<html>
    <head>
        <meta charset="UTF-8">
        <title>Sign up</title>
        <link rel="stylesheet" href="/css/registrStyle.css" type="text/css">
    </head>
    <body>
        <div class="register-box">
            <h2 align="center">Sign up</h2>
            <form action="${pageContext.request.contextPath}/register" method="post">
                <div class="text-boxes">
                    <label class="label" for="fullname">Enter your full name*</label>
                    <input type="text" id="fullname" placeholder="full name" name="fullName"/>
                </div>
                <div class="text-boxes">
                    <label class="label" for="course">Choose course*</label>
                    <select id = "course" name="course">
                        <option value="java">JAVA</option>
                        <option value="python">PYTHON</option>
                        <option value="cSharp">C#</option>
                        <option value="php">PHP</option>
                        <option value="frontEnd">FRONT-END</option>
                    </select>
                </div>
                <div class="phone-boxes">
                    <label for="phone" class="label">Phone number*</label>
                    <input type="tel" id="phone" name = "phone" placeholder="+996... - .. - .. - .."/>
                </div>
                <div class="date-box">
                    <label for="date" class="label">Birth date*</label>
                    <input type="date" datatype="YYYY-MM-DD" id="date" name="date"/>
                </div>
                <div class="gender-box">
                    <label for="gender" class="label">Gender</label>
                    <div id="gender">
                        <input type="radio" name="gender">Male</input>
                        <input type="radio" name="gender">Female</input>
                    </div>
                </div>
                <div class="text-boxes">
                    <label class="label" for="login" style="float: top">Login*</label>
                    <input type="text" id="login" placeholder="login" name="login"/>
                </div>

                <div class="text-boxes">
                    <label class="label" for="password">Password*</label>
                    <input type="password" id = "password" placeholder="password" name="password"/>
                </div>
                <div class="text-boxes">
                    <label class="label" for="email">E-mail*</label>
                    <input type="email" id = "email" placeholder="example@...com" name="email"/>
                </div>

                <input class="submit" type="submit" name="submit" value="sign up">
            </form>
        </div>
    </body>
</html>