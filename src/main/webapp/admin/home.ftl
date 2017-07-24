<#-- @ftlvariable name="currentUser" type="topprogersgroup.entity.CurrentUser" -->


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Личный кабинет администратора</title>
    <link rel="stylesheet" type="text/css" href='/resources/materialize/css/materialize.css'/>
    <link rel="stylesheet" type="text/css" href='/resources/css/style.css'/>

    <script type="text/javascript" rel="script" src="/resources/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" rel="script" src="/resources/materialize/js/materialize.js"></script>
</head>
<body>

<#include "/template/navbar.ftl">

<#if currentUser?? && currentUser.role == "ADMIN">
<div class="center-block section row">
    <div class="col s12">
        <div class="row">
            <div class="col s4">
                <a href="/admin/create">
                    Добавить пользователя
                    <img src="/resources/images/users.png" class="responsive-img" alt=""/>
                </a>
            </div>
            <div id="imgzat" class="col s4">
                <a href="/admin/checkpoint/create">Добавить ПКВП
                <img src="/resources/images/checkpoint.png" class="responsive-img" alt=""/>
                </a>
            </div>
            <div class="col s4">
                <a href="/admin/vet/create">
                    Добавить ГосВетСлужбу
                    <img src="/resources/images/statevetservice.png" class="responsive-img" alt=""/>
                </a>

            </div>
        </div>
    </div>
</div>
</#if>

</body>
</html>