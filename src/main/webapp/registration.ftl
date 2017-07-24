<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href='/resources/materialize/css/materialize.css'/>
    <link rel="stylesheet" type="text/css" href='/resources/css/style.css'/>

    <meta charset="utf-8">
    <title>Регистрация</title>
</head>
<body class="picbackground">
<script type="text/javascript" rel="script" src="/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" rel="script" src="/resources/materialize/js/materialize.js"></script>
<#include "/template/navbar.ftl">
<div class="section row">
    <div class="col s12 m6 l6 offset-m3 offset-l3">
        <div class="card white">
            <div class="card-content black-text">
                <h4 class="light">Регистрация</h4>
                <br/>
                <form role="form" id="registration" name="registration" method="post">
                    <div class="input-field">
                        <input type="email" name="email" id="email_reg" required/>
                        <label for="email">Адрес электронной почты</label>
                    </div>
                    <div class="input-field">
                        <input type="password" name="password" id="password_reg" required/>
                        <label for="password">Пароль</label>
                    </div>
                    <div class="input-field">
                        <input type="password" name="passwordRepeated" id="password_reg_repeat" required/>
                        <label for="passwordRepeated">Повторите пароль</label>
                    </div>
                    <div>
                        <#include "/template/input/owner.ftl">
                    </div>
                    <br/>
                    <div class="right-align">
                        <button class="btn" type="submit" name="action">Зарегистрироваться</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<#--<#if error.isPresent()>
<p>Допущена ошибка либо в адресе электронной почты, либо в пароле</p>
</#if>-->
</body>
</html>
