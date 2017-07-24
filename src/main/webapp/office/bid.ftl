<#import "/spring.ftl" as spring/>

<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Заявка на вывоз</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href='/resources/materialize/css/materialize.css'/>
    <link rel="stylesheet" type="text/css" href='/resources/css/style_child.css'/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<script type="text/javascript" rel="script" src="/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" rel="script" src="/resources/materialize/js/materialize.js"></script>
<script type="text/javascript" rel="script" src="/resources/js/office.js"></script>

<#include "/template/navbar.ftl">
<br/><br/>
<div class="center-block section row">
    <div class="col offset-s7 s5">
    <#if bid.veterinaryDocument??>
        <a href="/office/vet/doc/${bid.id}" class="waves-effect waves-light btn">
            Просмотреть вет. свидетельство
        </a>
        <br/>
        <br/>
        <#if bid.veterinaryDocument.veterinaryCertificate??>
            <a href="/office/vet/sert/${bid.id}" class="waves-effect waves-light btn">
                Просмотреть вет. сертификат
            </a>
            <br/>
            <br/>
        <#else>
            <a class="btn disabled">
                Просмотреть вет. сертификат
            </a>
            <br/>
            <br/>
        </#if>
    <#else>
        <a class="btn disabled">
            Просмотреть вет. свидетельство
        </a>
        <br/>
        <br/>
    </#if>
    </div>
    <div class="col offset-s7 s5">
    <#if bid.status == "CREATED">
        <a href="/office/bids/${bid.id}/send" class="waves-effect waves-light btn">
            Отправить на расмотрение(без возможности редактирования)
        </a>
        <br/>
        <br/>
        <a href="/office/bids/${bid.id}/edit" class="waves-effect waves-light btn">
            Редактирование
        </a>
    <#elseif bid.status == "REJECTED">
        <a href="/office/bids/${bid.id}/edit" class="waves-effect waves-light btn">
            Редактирование
        </a>
        <br/>
        <br/>
    </#if>
    </div>
    <br/>
    <br/>
    <div class="col s12">
    <#include "/template/output/bidforowner.ftl"/>
    </div>
</div>
</body>
</html>