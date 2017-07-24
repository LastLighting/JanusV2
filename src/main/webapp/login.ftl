<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
<#-- @ftlvariable name="currentUser" type="topprogersgroup.entity.CurrentUser" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href='/resources/materialize/css/materialize.css'/>
    <link rel="stylesheet" type="text/css" href='/resources/css/style.css'/>
    <meta charset="utf-8">
    <title>Вход в систему</title>
</head>
<body class="picbackground">
<#include "/template/navbar.ftl">
<div class="section row">
    <div class="col s12 m6 l6 offset-m3 offset-l3">
        <div class="card white">
            <div class="card-content black-text">
                <h4 class="light">Вход</h4>
                <br/>
            <#if !currentUser??>
                <form role="form" action="/login" method="post">
                    <div>
                        <label for="email">Адрес электронной почты</label>
                        <input type="email" name="email" id="email" required autofocus/>
                    </div>
                    <div>
                        <label for="password">Пароль</label>
                        <input type="password" name="password" id="password" required/>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="col s5 m4">
                            <input type="checkbox" name="remember-me" id="remember-me"/>
                            <label for="remember-me">Запомнить меня</label>

                        </div>
                        <div class="right-align">
                            <button class="btn" type="submit" name="action">Войти</button>
                        </div>
                    </div>
                    <div class="row">
                        <a href="/registration">Зарегистрироваться</a>
                    </div>
                </form>
            </#if>
            </div>
            <br/>
        </div>
    </div>
</div>
<#--<#if error.isPresent()>
<p>Допущена ошибка либо в адресе электронной почты, либо в пароле</p>
</#if>-->
</body>
</html>
