<%-- 
    Document   : login
    Created on : Mar 14, 2023, 1:59:12 PM
    Author     : ThanhNam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>:root {
                --green-color: #1abc9c;
                --blue-color: rgb(57, 35, 252);
                --light-gray: rgb(197, 197, 197);
            }

            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }
            body {
                background-color: var(--green-color);
                font-family: "Source Sans Pro", sans-serif;
            }

            .main-container {
                position: absolute;
                left: 50%;
                top: 50%;
                transform: translate(-50%, -50%);
                background: white;
            }

            .container {
                width: 400px;
                height: 300px;
                border-radius: 7px;
                box-shadow: 0 6px 12px rgba(179, 179, 179, 0.7);
                z-index: 1;
                overflow: hidden;
            }

            form {
                width: 100%;
                height: 100%;
                display: flex;
                padding: 0px !important;
                flex-direction: column;
                align-items: center;
                background-color: white;
                justify-content: space-evenly;
            }

            a {
                text-decoration: none;
                cursor: pointer;
                color: black;
            }

            a:focus,
            a:hover {
                color: var(--blue-color);
                font-weight: bold;
            }

            .input {
                position: relative;
            }

            .input input,
            .login-btn {
                width: 260px;
                height: 45px;
                outline: none;
                padding: 0 0.7rem;
                border-radius: 3px;
                transition: 0.2s;
                font-weight: bold;
                z-index: 1;
            }

            .input input {
                border: none;
                border-bottom: 1px solid #8c8c8c;
            }
            .login-btn {
                border: 1px solid #8c8c8c;
                background: var(--green-color);
                cursor: pointer;
                font-size: 20px;
                color: #fff;
                text-transform: uppercase;
            }

            .login-btn:focus,
            .login-btn:hover {
                background: #fff;
                cursor: pointer;
                color: var(--green-color);
                text-transform: uppercase;
                border: 1px solid var(--green-color);
                transition: ease-in-out 0.2s;
            }

            .input label {
                position: absolute;
                top: 28%;
                left: 10px;
                font-size: 0.9rem;
                transition: 0.2s;
                font-weight: bold;
                padding: 0 0.1rem;
            }

            .input input:focus {
                border-bottom: 1px solid var(--green-color);
            }

            .input input:focus ~ label,
            .input input:valid ~ label {
                transform: translateY(-25px);
                font-size: 15px;
                color: var(--green-color);
                background: #fff;
            }</style>
    </head>
    <body>
        <div class="main-container">
            <div class="container">
                <div>
                    <form action="MainController" method="POST">
                        <center><h1>LOGIN</h1></center>

                        <div class="input">
                            <input type="text" name="email" id="username" required title="Please enter your email here" />
                            <label for="username">Username</label>
                        </div>

                        <div class="input">
                            <input type="password" name="password" id="password" required title="Please enter your Password here" />
                            <label for="username">Password</label>
                        </div>

                        <input type="submit" name="action" value="Login" class="login-btn" />
                        <a href="#">Create</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
